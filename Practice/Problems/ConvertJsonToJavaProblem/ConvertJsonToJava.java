package Practice.Problems.ConvertJsonToJavaProblem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConvertJsonToJava {
    private int age;
    private String name;
    private String[] phoneNo;
    
    public ConvertJsonToJava(Map<String, Object> map) {
            this.age=(int)map.get(age);
            this.name=String.valueOf(map.get(name));
            this.phoneNo=new Array(map.get(phoneNo));

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

    

    public static void main(String[] args) throws JSONException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        String json = "{\"name\":\"Paul\",\"age\":20,\"phoneNo\":[\"12345\",\"98765\",\"567890\"]}";
        // String json2 = "{\"name\": \"John Doe\", \"age\": 30, \"phoneNo\":\"0923456664\"}";
        Map<String, Object> data = convertJsonToMap(json);
        // ConvertJsonToJava obj1 = new ConvertJsonToJava(data);

        Class Al=ConvertJsonToJava.class;
        Field[] fields = Al.getDeclaredFields();
        
        
        Map<String, String> fieldMap = new HashMap<>();
        Map<String,Object>m1=new HashMap<>();
 

         for (Field field : fields) {
             String fieldName = field.getName();
             String fieldType = field.getType().getSimpleName();
             System.out.println(fieldName +" ... "+fieldType);
             fieldMap.put(fieldName, fieldType);
         }
         for(String i:fieldMap.keySet()){
            String val1=fieldMap.get(i);
            String returndata=getPrimitiveTypeName(data.get(i).getClass().getSimpleName());
            System.out.println(data.get(i).getClass().getSimpleName());
            System.out.println(returndata);
            
            
             System.out.println(val1);
            // if(data.get(i).getClass().getSimpleName().equals("JSONArray")){
            //     // String arr[]=data.get(i).split("");

            // }
            if(val1.equals(returndata) ){
                System.out.println("true");
                m1.put(i,data.get(i));
             }

         }
        System.out.println(m1);
         
        
        //  ConvertJsonToJava obj= new ConvertJsonToJava();
        }

        
    public static String getPrimitiveTypeName(String wrapperClassName) {
        switch (wrapperClassName) {
            case "Integer":
                return "int";
            case "JSONArray":
                return "String[]";
            case "String":
                return "String";
            // Add more mappings for other primitive types...
            default:
                return null;
        }
    }

    
}