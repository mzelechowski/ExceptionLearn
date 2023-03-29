import java.util.ArrayList;
import java.util.List;

public class Zadanie01 {
    public static void main(String[] args) {
        /*Napsiz program, ktory odczyta od uzytkownika imie, nazwisko, wiek
        i zapisze te dane do pliku dodajac date wpisu na poczatku linijki
         */
        getUser();
    }
    private static void getUser(){
        User user= new User();
        user.getData();
        List<String> listUser= new ArrayList<>();
        listUser.add(user.getDate()+" "+ user.getName()+" "+ user.getLastName()+" "+user.getAge());
        CustomFileProvider customFileProvider= new CustomFileProvider("C:\\Mike\\ExceptionLearn\\src\\storage\\");
        customFileProvider.createFileBufferedFromCollections("user.txt",listUser,true);
    }
}
