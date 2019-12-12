package com.example.twister;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class DomainLookup {
    public static int PING_TIMEOUT  = 3000;

    public static boolean isAlive(Domain domain) {
        try {
            InetAddress address = InetAddress.getByName(domain.getPunycodeDomain());
            return true;
        }
        catch (UnknownHostException e) {
            System.err.println("Unable to lookup " + domain.getPunycodeDomain());
            return false;
        }
    }
}
