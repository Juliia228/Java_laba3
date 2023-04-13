public class Main {
    public static void main(String[] args) {
        System.out.print("Enter last name, first name, patronymic and date of birth: ");
        Data data = new Data();
        data.SetData();
        System.out.println(data.getLast_name() + ' ' + data.getFirst_name().charAt(0) + '.' + data.getPatronymic().charAt(0) + ". " + data.getGender() + ' ' + data.getAge() + ' ' + data.EndingForAge());
    }
}