public class HashThread extends Thread {
    private Runnable target;

    public HashThread (Runnable t) {
        target = t;
    }

    public void run() {
            target.run("");
    }
}
