package com.example.twister;
import com.google.common.net.InternetDomainName;

public class DomainNameParser {
    public static String DOMAIN_SEPERATOR = "\\.";

    public static String getTopLevelDomain(String domain) {
        String tld = InternetDomainName.from(domain).topPrivateDomain().toString();
        return tld.split(DOMAIN_SEPERATOR)[0]; // return google for google.com
    }

    public static String getSuffix(String domain) {
        return InternetDomainName.from(domain).publicSuffix().toString(); // return com for google.com
    }
}
