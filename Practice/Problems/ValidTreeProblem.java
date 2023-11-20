package Practice.Problems;
import java.util.HashMap;
import java.util.Map;
public class ValidTreeProblem {
    public static void main(String args[]){
        // String s1[]={"(2,4)","(3,4)","(5,2)","(6,3)","(8,4)"};
        String s1[]={"(2,4)","(3,4)","(5,2)","(6,3)"};
        System.out.println(isValid(s1));

    }
    public static boolean isValid(String arr[]){
        Map<Integer, Integer> m1 = new HashMap<>();
        int len=0;
        for (String pair : arr) {
            pair=pair.replace("(","").replace(")","");           
            String[] parts = pair.trim().split(",");
            int child = Integer.parseInt(parts[0].trim());
            int parent = Integer.parseInt(parts[1].trim());
            m1.put(child,parent);
            len++;
        }
        
        if(m1.size()==len){
        Map<Integer,Integer> m2=new HashMap<>();
        for(Map.Entry<Integer,Integer>map:m1.entrySet()){
            if(m2.containsKey(map.getValue())){
                m2.put(map.getValue(),m2.get(map.getValue())+1);
            }
            else{
                m2.put(map.getValue(),1);
            }
        }
        System.out.println(m2);
        int flag=0;
        for(int count: m2.values()){
            if(count>2){
                flag=1;
            }
        }
        if(flag==1)
        return false;
        else
        return true;
    }
    return false;
    }
}
