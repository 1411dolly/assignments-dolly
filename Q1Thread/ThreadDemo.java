package Q1Thread;

public class ThreadDemo extends Thread {

    public static void main(String[] args) {
        new ThreadDemo().start();
    }

    @Override
    public void run() {
        System.out.println("Running Thread Demo");
    }

}

