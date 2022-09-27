package multithreadingDialogCounter;

public class CallAnswer {
    private final int repeats;
    private final String threadName;

    public CallAnswer(int repeats, String threadName) {
        this.repeats = repeats;
        this.threadName = threadName;
    }

    public int getRepeats() {
        return repeats;
    }

    public String getThreadName() {
        return threadName;
    }

    @Override
    public String toString() {
        return "Выведенных сообщений: " +
                repeats + ", потоком: " + threadName;
    }
}
