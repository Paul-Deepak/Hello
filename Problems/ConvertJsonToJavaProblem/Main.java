package Practice.Problems.ConvertJsonToJavaProblem;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class Main {
    public static void main(String args[]){
    Map<String, String> map = new HashMap<>();
map.put("name", "jon doe");
map.put("age", "22");
map.put("city", "chicago");
JSONObject jo = new JSONObject(map);
System.out.println(jo);
    }
}
