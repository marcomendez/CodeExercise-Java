package helpers;

import java.util.HashMap;
import java.util.Map;

public final class UrlMap {

    private static final Map<String, String> urlMap;
    static {
        Map<String, String> urls = new HashMap<String, String>();
        urls.put("Login", "https://guard-dog-staging-uq26bhgsqq-uc.a.run.app/login");
        urlMap = urls;
    }

    public static String getUrl(String pageName){
        return urlMap.get(pageName);
    }
}
