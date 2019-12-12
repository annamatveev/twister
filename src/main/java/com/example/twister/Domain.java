package com.example.twister;

import java.net.IDN;
import java.text.ParseException;
import java.util.Objects;

public class Domain {

    private String domain;

    public Domain(String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getTopLevelDomain() {
        return DomainNameParser.getTopLevelDomain(this.domain);
    }

    public String getSuffixDomain() {
        return DomainNameParser.getSuffix(this.domain);
    }

    public String getPunycodeDomain() {
        return IDN.toASCII(this.domain, IDN.ALLOW_UNASSIGNED);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Domain domain = (Domain) o;
        return Objects.equals(this.getPunycodeDomain(), domain.getPunycodeDomain());
    }
}
