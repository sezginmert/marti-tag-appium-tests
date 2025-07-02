package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmsReader {

    public static String getLatestMartiCode() {
        String command = "adb -s aa4d26697d79 shell content query --uri content://sms/inbox --projection \"body,date\" | findstr \"Marti\"";
        String latestCode = null;
        long latestDate = 0;

        try {
            Process process = Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c", command });
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            Pattern codePattern = Pattern.compile("code is (\\d{4})");
            Pattern datePattern = Pattern.compile("date=(\\d+)");

            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);  // DEBUG
                Matcher codeMatcher = codePattern.matcher(line);
                Matcher dateMatcher = datePattern.matcher(line);

                if (codeMatcher.find() && dateMatcher.find()) {
                    long date = Long.parseLong(dateMatcher.group(1));
                    if (date > latestDate) {
                        latestDate = date;
                        latestCode = codeMatcher.group(1);
                    }
                }
            }

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Gelen Kod: " + latestCode);
        return latestCode;
    }


}
