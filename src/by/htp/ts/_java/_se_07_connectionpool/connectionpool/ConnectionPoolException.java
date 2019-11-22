package by.htp.ts._java._se_07_connectionpool.connectionpool;

public class ConnectionPoolException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ConnectionPoolException(String message,Exception e){
		super(message,e);
	}

}
