public class Main {
    private static int sharedNumber; 
    private static boolean hasNewNumber = false; 
    private static boolean isComplete = false;

    public static void main(String[] args) {
        new FiboThread().start();
        new SquareThread().start();
    }

    static class FiboThread extends Thread {
        public void run() {
            int a = 0, b = 1;
            for (int i = 0; i <= 20; i++) {
                synchronized (Main.class) {
                    while (hasNewNumber) {
                        try {
                            Main.class.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    sharedNumber = a;
                    hasNewNumber = true;
                    System.out.println("Fibo: " + a);
                    Main.class.notify();
                }
                int next = a + b;
                a = b;
                b = next;
            }
            synchronized (Main.class) {
                isComplete = true;
                Main.class.notifyAll();
            }
        }
    }

    static class SquareThread extends Thread {
        public void run() {
            while (true) {
                synchronized (Main.class) {
                    while (!hasNewNumber && !isComplete) {
                        try {
                            Main.class.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    if (!hasNewNumber && isComplete) break;
                    
                    System.out.println("Square: " + ((long) sharedNumber * sharedNumber));
                    hasNewNumber = false;
                    Main.class.notify();
                }
            }
        }
    }
}