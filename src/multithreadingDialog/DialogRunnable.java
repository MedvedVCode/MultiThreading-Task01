package multithreadingDialog;

public class DialogRunnable {
    public static void main(String[] args) throws Exception {

        ThreadGroup myThreadsGroup = new ThreadGroup("SuperThreadGroup");
        ThreadGroup myThreadGroupMinor = new ThreadGroup(myThreadsGroup, "MinorSuperThreadGroup");

        Runnable logic = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(2500);
                    System.out.println("Всем привет! Я поток " + Thread.currentThread().getName());
                }
            } catch (InterruptedException err) {
                System.out.println("\"Ой-ой\", сказал " + Thread.currentThread().getName());
            } finally {
                System.out.println(Thread.currentThread().getName() + " завершен!");
            }
        };

        Thread thread01 = new Thread(myThreadsGroup, logic, "Поток 01");
        Thread thread02 = new Thread(myThreadsGroup, logic, "Поток 02");
        Thread thread03 = new Thread(myThreadGroupMinor, logic, "Поток 03");
        Thread thread04 = new Thread(myThreadGroupMinor, logic, "Поток 04");

        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();

        Thread.sleep(10000);
        myThreadGroupMinor.interrupt();
        Thread.sleep(5000);
        myThreadsGroup.interrupt();
    }
}
