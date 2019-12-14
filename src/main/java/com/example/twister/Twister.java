package com.example.twister;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;
import java.util.ArrayList;

@Path("/domainConfusables")
public class Twister {

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getConfusableDomains(@QueryParam( "domain" ) String domain) {
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        String domainName = queryParams.getFirst("domain");

        System.out.println(domain);
        Domain originalDomain = new Domain(domainName);
        ArrayList<String> confusableDomainNames = ConfusableWord.getConfusableWords(originalDomain.getTopLevelDomain());
        ArrayList<Domain> confusableLiveDomains = new ArrayList<Domain>();
        ArrayList<String> confusableDeadDomainsPunycodes = new ArrayList<String>();

        for (String confusableDomainName : confusableDomainNames) {
            Domain confusableDomain = new Domain(confusableDomainName +  "." + originalDomain.getSuffixDomain());

            if (confusableLiveDomains.stream().map(Domain::getPunycodeDomain).noneMatch(confusableDomain.getPunycodeDomain()::equals) &&
                    !confusableDeadDomainsPunycodes.contains(confusableDomain.getPunycodeDomain()) &&
                    !confusableDomain.getPunycodeDomain().equals(originalDomain.getPunycodeDomain())) {
                if (DomainLookup.isAlive(confusableDomain)) {
                    confusableLiveDomains.add(confusableDomain);
                }
                else {
                    confusableDeadDomainsPunycodes.add(confusableDomain.getPunycodeDomain());
                }
            }
        }

        GenericEntity<ArrayList<Domain>> entity = new GenericEntity<ArrayList<Domain>>(confusableLiveDomains) {};
        return Response.ok(entity).build();
    }
}