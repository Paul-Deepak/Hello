package Practice.ThreadsPractice;
//implementing allows us to extend one more class
public class Main1 implements Runnable{
    public static void main(String args[]) throws InterruptedException{
        Main1 obj1=new Main1();
        Thread t=new Thread(obj1);
        t.start();
        while(t.isAlive()){
            System.out.println("Alive");
        }
        Thread.sleep(5000);
    }
    @Override
    public void run() {
        System.out.println("Runnnning");
    }
    
}
