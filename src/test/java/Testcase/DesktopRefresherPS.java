package Testcase;

import java.io.IOException;

class DesktopRefresherPS {
    public static void refreshEveryTime() {
        for (int i = 1; i <= 15; i++) {
            try {
                Runtime.getRuntime().exec("powershell -command \"$s=(New-Object -ComObject Shell.Application);$s.NameSpace(0).Self.InvokeVerb('R&efresh')\"");
                System.out.println("Desktop refreshed " + i + " time(s)");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String... args) {
        //for (int i = 1; i<10; i++) {
        while(true) {
            try {
                Runtime.getRuntime().exec("powershell -command \"$s=(New-Object -ComObject Shell.Application);$s.NameSpace(0).Self.InvokeVerb('R&efresh')\"");
                System.out.println("Desktop refreshed " + 0 + " time(s)");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
