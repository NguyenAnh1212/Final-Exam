package model;

import java.time.LocalDate;

public class PhoneBook {

    private String phoneNumber;
    private String group;
    private String name;
    private String gender;
    private String address;
    private LocalDate birthday;
    private String email;

    public PhoneBook() {
    }

    public PhoneBook(String phoneNumber, String group, String name, String gender, String address) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    public PhoneBook(String phoneNumber, String group, String name, String gender, String address, LocalDate birthday, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Danh bạ{" +
                "Số điện thoại='" + phoneNumber + '\'' +
                ", Nhóm='" + group + '\'' +
                ", Tên='" + name + '\'' +
                ", Giới tính='" + gender + '\'' +
                ", Địa chỉ='" + address + '\'' +
                ", Ngày sinh=" + birthday +
                ", Email='" + email + '\'' +
                '}';
    }
}
