package monitores;

public class SafeDualCounter {

    private Integer count1 = 0;
    private Integer count2 = 0;

    public synchronized void incrementCount1() {
        count1++;
    }

    public void incrementCount2() {
        synchronized (this) {
            count2++;
        }
    }

    public synchronized int getCount1() {
        return count1;
    }

    public int getCount2() {
        synchronized (this) {
            return count2;
        }
    }
}
