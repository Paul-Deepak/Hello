package Practice.Problems.ConvertJsonToJavaProblem;

import java.lang.reflect.InvocationTargetException;

import org.json.JSONException;

public class Main {
    public static void main(String args[]) {
        // String json2 = "{\"name\": \"John Doe\", \"rollNo\": 10,\"phoneNo\":[\"12345\",\"98765\",\"567890\"], \"age\": 30}";
        // String json = "{\"name\": \"John\", \"age\":20}";
        String json = "{\"name\":\"Paul\",\"age\":20,\"phoneNo\":[\"12345\",\"98765\",\"567890\"]}";
        try {
            Demo obj = ConvertJsonToJava.convertJsonToObj(json, Demo.class);
            System.out.println(obj.name + "  " + obj.age + "  " + obj.phoneNo);
        } catch (InstantiationException e) {

            e.printStackTrace();
        } catch (IllegalAccessException e) {

            e.printStackTrace();
        } catch (IllegalArgumentException e) {

            e.printStackTrace();
        } catch (SecurityException e) {

            e.printStackTrace();
        } catch (JSONException e) {

            e.printStackTrace();
        } catch (InvocationTargetException e) {

            e.printStackTrace();
        } catch (NoSuchMethodException e) {

            e.printStackTrace();
        }
    }

}
