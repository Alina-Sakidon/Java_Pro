package HW9;

public class Main {

    public static void main(String[] args) {
        DBConnectorSingleton connector = DBConnectorSingleton.getInstance();
        connector.connect();

        // Lazy singleton
        LazyInitializedSingleton connectorLazy = LazyInitializedSingleton.getInstance();
        connectorLazy.connect();

        //Thread safe

       /* new Thread(() -> {
            while (true) {
                ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
                System.out.println("Thread 1");
                instance.connect();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
                System.out.println("Thread 2");
                instance.connect();
            }
        }).start();*/
    }
}
