package helpers;

import Elements.CheckBox;
import Elements.Label;
import Elements.LabelLink;
import Elements.interfaces.IElement;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public final class UrlMap {

    private static final Map<String, String> urlMap;
    static {
        Map<String, String> urls = new HashMap<String, String>();
        urls.put("Login", "https://guard-dog-257220.wm.r.appspot.com/auth/login");
        urlMap = urls;
    }

    public static String getUrl(String pageName){
        return urlMap.get(pageName);
    }
}
