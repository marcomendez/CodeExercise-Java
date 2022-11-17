package helpers;

import java.util.HashMap;
import java.util.Map;

public final class EndPoints {

    private static final Map<String, String> endPointMap;
    static {
        Map<String, String> endpoints = new HashMap<String, String>();
        endpoints.put("Server", "");
        endpoints.put("Users", "");
        endpoints.put("Device","");
        endPointMap = endpoints;
    }

    public static String getUrl(String pageName){
        return endPointMap.get(pageName);
    }
}
