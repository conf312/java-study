public class ThreadTest {

    // 상속으로 구현
    class FirstThread extends Thread {
        @Override
        public void run() {
            System.out.println("thread 1..");
        }
    }

    // 내부 클래스 - Runnable 구현
    class SecondThread implements Runnable {
        @Override
        public void run() {
            System.out.println("thread 2..");
        }
    }

    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        FirstThread firstThread = t.new FirstThread();
        firstThread.start();
        Thread secondThread = new Thread(t.new SecondThread());
        secondThread.start();
    }
}
