package HW9;

public class DBConnectorSingleton {

    private static final DBConnectorSingleton instance = new DBConnectorSingleton();

    private DBConnectorSingleton() {
    }

    public static DBConnectorSingleton getInstance() {
        return instance;
    }

    public void connect(){
        System.out.println("Connected");
    }
}
