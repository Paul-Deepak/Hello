package Practice.Problems.ConcurrentBankingProblem;

public class ConcurrentBanking {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread depositThread1 = new TransactionThread(account, true, 100);
        Thread withdrawThread1 = new TransactionThread(account, false, 50);
        Thread depositThread2 = new TransactionThread(account, true, 200);
        Thread withdrawThread2 = new TransactionThread(account, false, 250);
        Thread depositThread3 = new TransactionThread(account, true, 500);
        Thread withdrawThread3 = new TransactionThread(account, false, 550);

        depositThread1.start();
        withdrawThread1.start();
        depositThread2.start();
        withdrawThread2.start();
        depositThread3.start();
        withdrawThread3.start();

        try {
            depositThread1.join();
            withdrawThread1.join();
            depositThread2.join();
            withdrawThread2.join();
            depositThread3.join();
            withdrawThread3.join();
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}