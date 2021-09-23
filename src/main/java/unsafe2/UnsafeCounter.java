package unsafe2;

public class UnsafeCounter {

    private int count = 0;

    // Con el synchronized, prohibe la ejecucion simultanea del metodo
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
