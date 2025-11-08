package Testcase;

import java.io.IOException;

public class KillChromeDriver {
    public static void killAll() {
    	try {
    	    // Kill chromedriver.exe directly
    	    Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");

    	    // Kill only Chrome instances started by Chromedriver
    	    String cmd = "wmic process where \"name='chrome.exe' and commandline like '%remote-debugging-port%'\" delete";
    	    Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", cmd});

    	    System.out.println("Killed Chromedriver and its Chrome instances, manual Chrome untouched.");
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}

    }
}

