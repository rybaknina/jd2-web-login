package _java._se._07_connectionpool.ConnectionPool;

public class ConnectionPoolException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ConnectionPoolException(String message,Exception e){
		super(message,e);
	}

}
