package mods.lostages.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class LALogger {

	private static Logger logLA = Logger.getLogger("LostAges");
	
	public static void init() {
		logLA.setParent(FMLLog.getLogger());
	}
	
	public static void log(Level level, String message) {
		logLA.log(level, message);
	}
	
}
