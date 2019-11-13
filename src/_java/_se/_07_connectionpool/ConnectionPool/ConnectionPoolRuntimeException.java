package _java._se._07_connectionpool.ConnectionPool;

public class ConnectionPoolRuntimeException extends Exception {
    private static final long serialVersionUID = 1L;
    public ConnectionPoolRuntimeException(String message,Exception e){
        super(message,e);
    }
}
