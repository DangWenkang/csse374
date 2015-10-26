package problem.renderers;

import java.util.HashMap;
import java.util.Map;

import problem.renderers.linux.LinuxRendererFactory;
import problem.renderers.osx.OSXRendererFactory;
import problem.renderers.windows.WindowRendererFactory;

public class Configuration {
	private static boolean TEST = true;
	private static String defaultOS = "linux"; // Also try "Windows"
	private static Map<String, IRendererFactory> osToFactoryMap = new HashMap<String, IRendererFactory>();
	
	static {
		osToFactoryMap.put("windows", new WindowRendererFactory());
		osToFactoryMap.put("linux", new LinuxRendererFactory());
		osToFactoryMap.put("osx", new OSXRendererFactory());
	}
	
	public static String getDefaultOS() {
		return defaultOS;
	}

	public static boolean isTest() {
		return TEST;
	}
	
	public static void setDefaultOS(String os) {
		defaultOS = os;
	}
	
	public static void setTest(boolean t) {
		TEST = t;
	}

	public static String getOS() {
		if(TEST)
			return defaultOS.toLowerCase();
		else
			return System.getProperty("os.name").toLowerCase();
	}
	
	public static IRendererFactory getRendererFactory() {
		return osToFactoryMap.get(getOS());
	}
}
