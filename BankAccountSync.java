class BankAccountSync {
    private int balance = 1000;

    
    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " depositing: " + amount);
        balance += amount;
        System.out.println("New Balance after deposit: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " withdrawing: " + amount);
            balance -= amount;
            System.out.println("New Balance after withdrawal: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " - Low balance for withdrawal!");
        }
    }
}

class DepositThread extends Thread {
    private BankAccountSync account;

    public DepositThread(BankAccountSync account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(200);
        }
    }
}

class WithdrawThread extends Thread {
    private BankAccountSync account;

    public WithdrawThread(BankAccountSync account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            account.withdraw(150);
        }
    }
}

public class BankAppDemo {
    public static void main(String[] args) {
        BankAccountSync sharedAccount = new BankAccountSync();

        DepositThread t1 = new DepositThread(sharedAccount);
        WithdrawThread t2 = new WithdrawThread(sharedAccount);

        t1.setPriority(Thread.MAX_PRIORITY); 
        t2.setPriority(Thread.MIN_PRIORITY); 

        t1.setName("Deposit-Thread");
        t2.setName("Withdraw-Thread");

        t1.start();
        t2.start();
    }
}