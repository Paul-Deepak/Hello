package Practice.Problems.ConvertJsonToJavaProblem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ConvertJsonToJava {

    public static String getPrimitiveTypeName(String wrapperClassName) {
        switch (wrapperClassName) {
            case "Integer":
                return "int";
            case "JSONArray":
                return "List";
            case "String":
                return "String";
            case "Double":
                return "Double";
            case "Float":
                return "Float";
            default:
                return null;
        }
    }

    public static <T> T convertJsonToObj(String jsonData, Class<T> destClass)
            throws JSONException, IllegalAccessException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException {
        JSONObject jsonObject = new JSONObject(jsonData);

        T obj = destClass.getDeclaredConstructor().newInstance();

        for (Field field : destClass.getDeclaredFields()) {
            String fieldName = field.getName();
            if (jsonObject.has(fieldName)) {
                field.setAccessible(true);

                String ExpfieldType = field.getType().getSimpleName();
                String ObtfieldType = getPrimitiveTypeName(jsonObject.get(fieldName).getClass().getSimpleName());
                System.out.println(ExpfieldType + "..");
                System.out.println(ObtfieldType);
                if (jsonObject.get(fieldName).getClass().getSimpleName().equals("JSONArray")) {

                    JSONArray jsonArray = (JSONArray) jsonObject.get(fieldName);
                    List<T> list = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        list.add((T) jsonArray.get(i));
                    }
                    field.set(obj, list);
                } else {
                    if (ObtfieldType.equals(ExpfieldType)) {
                        field.set(obj, jsonObject.get(fieldName));
                    }
                }
            }
        }
        return obj;
    }
}