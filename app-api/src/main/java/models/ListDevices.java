package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListDevices{
   public List<Device> devices;
}

class Device {
    public String id;

    @JsonProperty("public")
    public String publicIP;
    public String device;

    @JsonProperty("private")
    public String privateIP;
}
