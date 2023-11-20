// package Practice.ThreadsPractice;

// import java.lang.reflect.InvocationHandler;
// import java.lang.reflect.InvocationTargetException;
// import java.lang.reflect.Method;
// import java.lang.reflect.Proxy;

// import org.json.Test;

// public interface ITest {
//     public Integer testIt();
// }

// public class Main2 {
//     public static void main(String[] args) {


//         try {
//             DynamicInvocationHandler myTestInvocationHandler = new DynamicInvocationHandler(new Test());

//             ITest test = (ITest) Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[] {
//                     ITest.class
//             }, myTestInvocationHandler);

//             // ITest proxy = (ITest) Proxy.newProxyInstance(ITest.class.getClassLoader(),
//             // new Class[] { ITest.class }, myTestInvocationHandler);

//             System.out.println(test.testIt());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
        
//     }
// }

// class DynamicInvocationHandler implements InvocationHandler {

//     private Object target;
//     public DynamicInvocationHandler(Object object) {
//         this.target = object;
//     }

//     @Override
//     public Object invoke(Object proxy, Method method, Object[] args)        {

//         // if ("testIt".equals(method.getName())) {
//         //     // We can write our logic in here 

//         //     try {
//         //         return method.invoke(proxy.getClass().newInstance(), args);
//         //     } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
//         //             | InstantiationException e) {
//         //         // TODO Auto-generated catch block
//         //         e.printStackTrace();
//         //     }
//         //     return 5;
//         // }

//         if ("testIt".equals(method.getName())) {
//             // We can write our logic in here 
//             try {
//                 Object result = method.invoke(proxy, args);
//                 return result;
//             } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//                 // TODO Auto-generated catch block
//                 e.printStackTrace();
//             }
//         }

//         return null;
//     }

//     @Override
//     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'invoke'");
//     }
// }
