package mods.lostages.configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LALogger {

	private static Logger logLA = Logger.getLogger("Lost Ages");
	
	public static void init() {
		logLA.getParent();
	}
	
	public static void log(Level level, String message) {
		logLA.log(level, message);
	}
	
}
