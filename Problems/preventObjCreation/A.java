package Practice.Problems.preventObjCreation;

import java.util.HashSet;
import java.util.Set;

public class A {
    // private static A firstInstance=null;
    public static Set<Class> instances = new HashSet<>();
    public A(){
        if (instances.contains(this.getClass())) {
            throw new IllegalStateException("Instance Already Created");
        }
        instances.add(getClass());
    }
}

