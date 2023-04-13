/**
 * @author Julia Komarova
 */

import java.time.*;
import java.util.Scanner;

/**
 * Class including information about person
 */
public class Data {
    /**
     * first_name - first name of person
     */
    private String first_name;
    /**
     * last_name - last name of person
     */
    private String last_name;
    /**
     * patronymic - patronymic of person
     */
    private String patronymic;
    /**
     * date_of_birth - date of birth in the format YYYY-MM-DD
     */
    private LocalDate date_of_birth;
    /**
     * age - age of person
     */
    private int age;
    /**
     * gender - gender of person
     */
    private char gender;

    /**
     * Getter of gender of person
     * @return gender of person
     */
    public char getGender() {
        return gender;
    }

    /**
     * Setter to set a gender of person
     * @param gender - gender of person
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * Getter of first name of person
     * @return first name of person
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Setter to set first name of person
     * @param first_name - first name of person
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Getter of last name of person
     * @return last name of person
     */
    public String getLast_name() {
        return last_name;
    }
    /**
     * Setter to set last name of person
     * @param last_name - last name of person
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    /**
     * Getter of patronymic of person
     * @return patronymic of person
     */
    public String getPatronymic() {
        return patronymic;
    }
    /**
     * Setter to set patronymic of person
     * @param patronymic - patronymic of person
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    /**
     * Getter of date of birth of person
     * @return date of birth of person in the format YYYY-MM-DD
     */
    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }
    /**
     * Setter to set date of birth of person
     * @param date_of_birth - date of birth of person in the format YYYY-MM-DD
     */
    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
    /**
     * Getter of age of person
     * @return age of person
     */
    public int getAge() {
        return age;
    }
    /**
     * Setter to set age of person
     * @param age - age of person
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Method to set values of all params of person
     */
    void SetData(){
        Scanner sc = new Scanner(System.in);
        try {
            setLast_name(sc.next());
            setFirst_name(sc.next());
            setPatronymic(sc.next());
            String birth = sc.next();
            sc.close();
            setDate_of_birth(LocalDate.of(Integer.parseInt(birth.substring(6, 10)), Integer.parseInt(birth.substring(3, 5)), Integer.parseInt(birth.substring(0, 2))));
            LocalDate now = LocalDate.now();
            setAge(Period.between(date_of_birth, now).getYears());
            DetermineGender();
        } catch (Exception e) {
            System.out.println("Incorrect data");
        }
    }

    /**
     * Method to determine gender of person using his date of birth
     */
    void DetermineGender(){
        if (patronymic.substring(patronymic.length() - 2).equals("ич")){
            setGender('М');
        } else if (patronymic.substring(patronymic.length() - 1).equals("а")){
            setGender('Ж');
        } else {
            setGender('?');
        }
    }

    /**
     * Method to set ending for age
     * @return word-ending for age
     */
    String EndingForAge(){
        if (age % 10 == 1){
            return "год";
        } else if (age % 10 > 1 && age % 10 < 5){
            return "года";
        } else {
            return "лет";
        }
    }
}
