package unsafe;

public class LazyInit {

    private Object instance = null;

    // Con el synchronized, prohibe la ejecucion simultanea del metodo
    public synchronized Object getInstance() {
        if (instance == null) {
            instance = new Object();
        }
        return instance;
    }
}
