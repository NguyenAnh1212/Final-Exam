package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static final String regexPhoneNumber = "^[0-9]+$";
    private static final String regexEmail = "^[\\w]+[\\w]*@[\\w]+(\\.[\\w]+)$";

    public static boolean isValidPhoneNumber(String phoneNumber){
        Pattern p = Pattern.compile(regexPhoneNumber);
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }
    public static boolean isValidEmail(String email){
        Pattern p = Pattern.compile(regexEmail);
        Matcher m = p.matcher(email);
        return m.matches();
    }





}
