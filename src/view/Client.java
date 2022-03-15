package view;

import controler.PhoneBookManager;
import model.PhoneBook;
import storage.PhoneBookFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static ArrayList<PhoneBook> phoneBooksClient = new ArrayList<>();
    public static void main(String[] args) {

    }
    public static void displayMenu() throws IOException {
        int choice = -1;
        Scanner inputChoice = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("________Chương trình quản lý danh bạ_________");
            System.out.println("Chọn các chức năng theo số (để tiếp tục):");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới ");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = inputChoice.nextInt();
            switch (choice) {
                case 1:displayPhonebook();
                    break;
                case 2:addNewPhone();
                    break;
                case 3:editphoneNumber();
                    break;
                case 4: deletePhoneNumber();
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }

    public static void displayPhonebook(){
        for (PhoneBook p: phoneBooksClient
             ) {
            System.out.println(p);
        }
    }
    //2. Xây dựng chức năng thêm một mục danh bạ mới, check email và số điện thoại, trường ko để rỗng
    public static String checkInputPhoneNumber(){
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = scanner.nextLine();
        if (!Regex.isValidPhoneNumber(phoneNumber)) {
            System.err.println("Số điện thoại không hợp lệ, mời nhập lại");
             return checkInputPhoneNumber();
        }
        return phoneNumber;
    }

    public static String checkInputEmail(){
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        if (!Regex.isValidEmail(email)) {
            System.err.println("Email không hợp lệ, mời nhập lại");
             return checkInputEmail();
        }
        return email;
    }

    public static PhoneBook creatNewPhoneBook(){
        PhoneBook newPhone;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = checkInputPhoneNumber();

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Nhập tên nhóm: ");
        String group = sc2.nextLine();

        Scanner sc3 = new Scanner(System.in);
        System.out.println("Nhập họ tên: ");
        String name = sc3.nextLine();

        Scanner sc4 = new Scanner(System.in);
        System.out.println("Nhập giới tính: ");
        String gender = sc4.nextLine();

        Scanner sc5 = new Scanner(System.in);
        System.out.println("Nhập địa chỉ: ");
        String address = sc5.nextLine();

        Scanner sc6 = new Scanner(System.in);
        System.out.println("Nhập ngày tháng năm sinh: ");
        System.out.println("Nhập năm sinh: ");
        int year = sc6.nextInt();

        Scanner sc61 = new Scanner(System.in);
        System.out.println("Nhập tháng sinh:");
        int month = sc61.nextInt();

        Scanner sc62 = new Scanner(System.in);
        System.out.println("Nhập ngày sinh: ");
        int day = sc62.nextInt();

        LocalDate birthday = LocalDate.of(year, month, day);

        Scanner sc7 = new Scanner(System.in);
        System.out.println("Nhập email: ");
        String email = checkInputEmail();
        if (phoneNumber== null||group == null||name == null|| gender == null||address == null|| birthday == null||email== null){
            System.out.println("Đừng để trống, hãy nhập dữ liệu");
            return creatNewPhoneBook();
        }
        newPhone = new PhoneBook(phoneNumber, group, name, gender, address, birthday, email);
        return newPhone;
    }

    public static void addNewPhone() throws IOException {
        PhoneBookManager.phoneBooks = phoneBooksClient;
        PhoneBook newPhone = creatNewPhoneBook();
        PhoneBookManager.addNewPhone(newPhone);
        PhoneBookFile.writeFile(phoneBooksClient);
    }

    // Tìm index của số điện thoại cần sửa, nếu só trong danh bạ thì sửa.
    public static void editphoneNumber() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số điện thoại cần sửa: ");
        String inputPhoneNumber = checkInputPhoneNumber();
        int index = PhoneBookManager.getIndexByPhoneNumber(inputPhoneNumber);
        if (index == -1){
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
        } else{
            PhoneBook newPhone = creatNewPhoneBook();
            PhoneBookManager.editPhonebookByName(index, newPhone);
        }
        PhoneBookFile.writeFile(phoneBooksClient);
    }

    // Xóa có xác nhận.
    public static void deletePhoneNumber() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số điện thoại muốn xóa: ");
        String inputPhoneNumber = checkInputPhoneNumber();
        int index = PhoneBookManager.getIndexByPhoneNumber(inputPhoneNumber);
        if (index == -1){
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
            System.out.println("Nhấn enter để quay về menu");
            displayPhonebook();
        } else{
            System.out.println("Đây có phải thông tin danh bạ bạn muốn xóa");
            System.out.println(PhoneBookManager.phoneBooks.get(index));
            System.out.println("Nhấn Y để đồng ý xóa");
            String scanner = sc.nextLine();
            if (scanner.equals("Y")){
                PhoneBookManager.deletePhonebookByName(index);
            }
            PhoneBookFile.writeFile(phoneBooksClient);
        }

    }









}
