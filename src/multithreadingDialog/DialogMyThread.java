package multithreadingDialog;

public class DialogMyThread {
    public static void main(String[] args) throws Exception {
        ThreadGroup mainGroup = new ThreadGroup("main thread group");

        MyThread thread01 = new MyThread(mainGroup, "Поток A");
        MyThread thread02 = new MyThread(mainGroup, "Поток B");
        MyThread thread03 = new MyThread(mainGroup, "Поток C");
        MyThread thread04 = new MyThread(mainGroup, "Поток D");

        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        Thread.sleep(15000);

        mainGroup.interrupt();
    }
}
