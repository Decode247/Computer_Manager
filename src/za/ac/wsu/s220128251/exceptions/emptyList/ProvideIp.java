package za.ac.wsu.s220128251.exceptions.emptyList;

import za.ac.wsu.s220128251.exceptions.IpAddressEmpty;

public class ProvideIp {
    public ProvideIp(String ip) throws IpAddressEmpty{
        if(ip.isBlank()) {
            throw new IpAddressEmpty("Provide IP Address");
        }
    }
}
