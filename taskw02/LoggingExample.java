import java.util.logging.Logger;

public class LoggingExample {

	private static final Logger log =
        	Logger.getLogger(LoggingExample.class.getName());

	public static void main(String[] args) {
        	log.info("Server starting");
		log.warning("This is a warning");
	}

}
