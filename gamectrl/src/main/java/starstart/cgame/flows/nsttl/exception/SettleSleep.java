package starstart.cgame.flows.nsttl.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SettleSleep extends RuntimeException{

	long sleepMS = 1000;
	
	public SettleSleep() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SettleSleep(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SettleSleep(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SettleSleep(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SettleSleep(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
