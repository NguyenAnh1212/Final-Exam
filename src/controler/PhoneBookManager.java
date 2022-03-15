package controler;

import model.PhoneBook;
import storage.PhoneBookFile;

import java.util.ArrayList;

public class PhoneBookManager {
    public static ArrayList<PhoneBook> phoneBooks = PhoneBookFile.readFile();

    public static void addNewPhone(PhoneBook newPhone){
        phoneBooks.add(newPhone);
    }

    public static void editPhonebookByName(int index, PhoneBook newPhone){
        phoneBooks.set(index, newPhone);
    }

    public static void deletePhonebookByName(int index){
        phoneBooks.remove(index);
    }

    public static int getIndexByPhoneNumber(String inputPhonenumber){
        int index = -1;
        for (int i = 0; i < phoneBooks.size(); i++) {
            String phoneNumber = phoneBooks.get(i).getPhoneNumber();
            if (phoneNumber.equals(inputPhonenumber)){
                index = i;
            }
        }
        return index;
    }




}
