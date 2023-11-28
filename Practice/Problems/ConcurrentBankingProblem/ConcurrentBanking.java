package Practice.Problems.ConcurrentBankingProblem;

public class ConcurrentBanking {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread depositThread1 = new TransactionThread(account, true, 100);
        Thread withdrawThread1 = new TransactionThread(account, false, 50);
        Thread depositThread2 = new TransactionThread(account, true, 200);
        Thread withdrawThread2 = new TransactionThread(account, false, 250);
       
        depositThread1.start();
        withdrawThread1.start();
        depositThread2.start();
        withdrawThread2.start();    
        
        depositThread1.setName("DThread1");
        withdrawThread1.setName("WThread1");
        depositThread2.setName("DThread2");
        withdrawThread2.setName("WThread2");
        try {
            depositThread1.join();
            withdrawThread1.join();
            depositThread2.join();
            withdrawThread2.join();
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}