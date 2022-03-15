package view;

import static org.junit.jupiter.api.Assertions.*;

class RegexTest {
    public static Regex tool = new Regex();


    public static String[] exampleMail = {"1@2.3","a@b.c","a3@abc.as","linhmail.com","linh@mail.com","1234@mail","123@123.123","a@a.a","linh@gmail com"};
    public static String[] examplePhoneNumber = {"012345678", "fafgg", "vgdg1255"};

    public static void main(String[] args) {
        for (String e: exampleMail
        ) {
            System.out.print("\n"+ e + " is valid? ");
            System.out.print(tool.isValidEmail(e)+"\n");
        }

        for (String e: examplePhoneNumber
        ) {
            System.out.print("\n"+ e + " is valid? ");
            System.out.print(tool.isValidPhoneNumber(e)+"\n");
        }

    }






}