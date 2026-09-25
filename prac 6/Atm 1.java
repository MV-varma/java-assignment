class TransactionSteps implements Runnable{
	
	public void run(){
		try{
			System.out.println("Card Inserted");
			Thread.sleep(1500);	
			
			System.out.println("Pin Verified");
			Thread.sleep(1500);	

			System.out.println("Transaction Processing");
			Thread.sleep(1500);	
		}
		catch(InterruptedException e){
			System.out.println("Thread's been interrupted");
		}	
	}
}

class AccountNotification implements Runnable{
	
	public void run(){
		try{
			System.out.println("Checking Balance");
			Thread.sleep(1500);	
			
			System.out.println("Amount Debited");
			Thread.sleep(1500);	

			System.out.println("SMS Sent");
			Thread.sleep(1500);	
		}
		catch(InterruptedException e){
			System.out.println("Thread's been interrupted");
		}	
	}
}

public class Atm{
	public static void main(String cp[]){
		TransactionSteps ts= new TransactionSteps();
		AccountNotification an= new AccountNotification();

		Thread t1 = new Thread(ts);
		Thread t2 = new Thread(an);
		System.out.println("Atm execution started:");
		
		t1.start();
		t2.start();
	}	
}