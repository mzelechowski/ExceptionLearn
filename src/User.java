import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class User {
    private String date;
    private String name;
    private String lastName;
    private String age;

    public User(){
    }

    public void getData(){
        System.out.println("Podaj swoje dane");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię: ");
        this.setName(scanner.nextLine());
        System.out.println("Podaj nazwisko: ");
        this.setLastName(scanner.nextLine());
        System.out.println("Podaj wiek: ");
        this.setAge(scanner.nextLine());
        this.setDate(fromUtilDateToString(new Date()));
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String fromUtilDateToString(Date date){
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
