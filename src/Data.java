import java.time.*;
import java.util.Scanner;

public class Data {
    private String first_name;
    private String last_name;
    private String patronymic;
    private LocalDate date_of_birth;
    private int age;
    private char gender;
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
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
    void DetermineGender(){
        if (patronymic.substring(patronymic.length() - 2).equals("ич")){
            setGender('М');
        } else if (patronymic.substring(patronymic.length() - 1).equals("а")){
            setGender('Ж');
        } else {
            setGender('?');
        }
    }
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
