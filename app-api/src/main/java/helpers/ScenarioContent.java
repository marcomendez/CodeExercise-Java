package helpers;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContent {

    private Map<String, Object> map;
    private static ScenarioContent instance = null;


    protected ScenarioContent() {
        initialize();
    }

    public static ScenarioContent getInstance() {
        if (instance == null) {
            instance = new ScenarioContent();
        }
        return instance;
    }
    public static void add(String key, Object value){
        getInstance().map.put(key,value);
    }

    public static Object get(String key){
        return getInstance().map.get(key);
    }

    private void initialize() {
        map = new HashMap<>();
    }
}