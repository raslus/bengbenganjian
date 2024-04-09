package beng;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Test {
    public static void main(String[] args) {
        Map<String,Object> testMap = new HashMap<>();
        testMap.put("a","b");
        Map<String,Object> bMap = new HashMap<>();
        bMap.put("b","c");
        testMap.put("b0",bMap);

        ConcurrentMap<String,String> rsMap = new ConcurrentHashMap<>();
        for(Map.Entry<String,Object> entry :testMap.entrySet()){
            String val = String.valueOf(entry.getValue());
            rsMap.put(entry.getKey(), val);
        }
        System.out.println(testMap);
        System.out.println(rsMap);
    }
}
