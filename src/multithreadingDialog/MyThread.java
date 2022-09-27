package multithreadingDialog;

public class MyThread extends Thread {
    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2500);
                System.out.println("Всем привет! Я поток " + getName());
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.println(getName() + " завершен!");
        }
    }
}
