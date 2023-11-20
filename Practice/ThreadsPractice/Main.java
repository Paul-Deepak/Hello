package Practice.ThreadsPractice;
//we can only extend one parent, thus we use implements
public class Main extends Thread{
    public static void main(String args[]){
        Main thread1 =new Main();
        // thread1.start();
    }
    public void run(){
        System.out.println("Hii");
    }
}
