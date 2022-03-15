package storage;

import model.PhoneBook;

import java.io.*;
import java.util.ArrayList;

public class PhoneBookFile {
    public static void writeFile(ArrayList<PhoneBook> phoneBooks) throws IOException {
        File file = new File("book1.text");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(phoneBooks);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            oos.close();
            fos.close();
        }
    }

    public static ArrayList<PhoneBook> readFile(){
        File file = new File("book1.text");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object result = ois.readObject();
            ois.close();
            fis.close();
            ArrayList<PhoneBook> books = (ArrayList<PhoneBook>) result;
            return books;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
