package Util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    public static Scanner s = new Scanner(System.in);

    public static String getStringLine() {
        return s.nextLine();
    }

    public static String getString() {
        return s.next();
    }

    public static int getInt() {
        while (true) {
            try {
                return s.nextInt();
            } catch (Exception e) {
                System.out.println("ENTER THE VALID INPUT");
                s.next();
            }
        }
    }
    public static float getFloat() {
        while (true) {
            try {
                return s.nextFloat();
            } catch (Exception e) {
                System.out.println("ENTER THE VALID INPUT");
                s.next();
            }
        }
    }

    public static String getPhoneNumber() {
        String phoneNumber;
        try {
            phoneNumber = s.next();
            Pattern pattern = Pattern.compile("^\\d{10}$"); // Corrected regex pattern
            Matcher matcher = pattern.matcher(phoneNumber);
            if (matcher.find()) {
                return phoneNumber;
            } else {
                throw new IllegalArgumentException("Invalid phone number format");
            }
        } catch (Exception e) {
            //System.out.println("Error: " + e.getMessage());
            System.out.println("PLEASE ENTER THE VALID PHONE NUMBER:");
            s.nextLine(); // Consume invalid input
            return getPhoneNumber(); // Prompt for new input
        }
    }

    public static String getDate()
    {
        String Date;
        try {
            Date=s.next();
            Pattern pattern=Pattern.compile("[0-9][0-9][0-9][0-9]-[0-1][0-2]-[0-3][0-9]");
            Matcher matcher=pattern.matcher(Date);
            if(matcher.find())
            {
                return Date;
            }
            else
                throw new IllegalArgumentException("Invalid Date format");
        }
        catch (Exception e){
            System.out.println("PLEASE ENTER THE VALID DATE");
            s.nextLine();
            return getDate();
        }
    }
}
