package helpers;

import java.util.HashMap;
import java.util.Map;

public final class EndPoints {

    private static final Map<String, String> endPointMap;
    static {
        Map<String, String> endpoints = new HashMap<String, String>();
        endpoints.put("Server", "https://staging-dot-guard-dog-257220.wm.r.appspot.com");
        endpoints.put("Users", "");
        endpoints.put("Device","");
        endPointMap = endpoints;
    }

    public static String getUrl(String pageName){
        return endPointMap.get(pageName);
    }
}
