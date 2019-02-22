package Q1Thread;

public class RunnableDemo implements Runnable {
    public static void main(String[] args) {
        new Thread(new RunnableDemo())
                .start();
    }

    @Override
    public void run() {
        System.out.println("Running Runnable Thread");
    }
}

