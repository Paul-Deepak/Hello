package Practice.Problems.ConvertJsonToJavaProblem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConvertJsonToJava {
    private int age;
    private String name;
    private List<String> phoneNo;

    public ConvertJsonToJava(Map<String, Object> map) throws JSONException {
        this.age = (int) map.get("age");
        this.name = String.valueOf(map.get("name"));

        Object phoneNoObj = map.get("phoneNo");
        if (phoneNoObj instanceof JSONArray) {
            JSONArray phoneNoArray = (JSONArray) phoneNoObj;
            this.phoneNo = new ArrayList<>();
            for (int i = 0; i < phoneNoArray.length(); i++) {
                this.phoneNo.add(phoneNoArray.getString(i));
            }
        }
    }

    public static Map<String, Object> convertJsonToMap(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        Map<String, Object> result = new HashMap<>();
        Iterator<String> keys = jsonObject.keys();

        while (keys.hasNext()) {
            String key = keys.next();
            try {
                Object value = jsonObject.get(key);
                result.put(key, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String getPrimitiveTypeName(String wrapperClassName) {
        switch (wrapperClassName) {
            case "Integer":
                return "int";
            case "JSONArray":
                return "String[]";
            case "String":
                return "String";
            default:
                return null;
        }
    }

    public static void main(String[] args) throws JSONException, NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {
        String json = "{\"name\":\"Paul\",\"age\":20,\"phoneNo\":[\"12345\",\"98765\",\"567890\"]}";
        // String json2 = "{\"name\": \"John Doe\", \"age\":
        // 30,\"phoneNo\":\"0923456664\"}";
        Map<String, Object> data = convertJsonToMap(json);

        Class<?> Al = ConvertJsonToJava.class;
        Field[] fields = Al.getDeclaredFields();

        Map<String, String> fieldMap = new HashMap<>();
        Map<String, Object> m1 = new HashMap<>();

        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldType = field.getType().getSimpleName();
            fieldMap.put(fieldName, fieldType);
        }
        for (String i : fieldMap.keySet()) {
            String val1 = fieldMap.get(i);
            String returndata = getPrimitiveTypeName(data.get(i).getClass().getSimpleName());
            if (val1.equals(returndata)) {
                m1.put(i, data.get(i));
            } else {
                m1.put(i, "");
            }
        }

        ConvertJsonToJava obj = new ConvertJsonToJava(data);
        System.out.println("Name: " + obj.name + "\nAge: " + obj.age + "\nPhoneNumber: " + obj.phoneNo);
    }
}