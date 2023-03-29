import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Excep01 {
    public static void main(String[] args) throws IllegalAccessException {

      //  System.out.println(Excep01.getNumberOfSeconds(-60));
         //getPageByUrl();
         getResult(3,0);

    }
    public static int getNumberOfSeconds(int hour) throws IllegalAccessException {
        if(hour<0){
            throw new IllegalAccessException("Hour must be >=0"+hour);
        }
        return hour*60*60;
    }
    private static void getResult(int x, int y){
        try {
            System.out.println(x / y);
        } catch (ArithmeticException e){
            System.out.println("Dzielisz przez zero "+e.getMessage());
        }
    }

    private static void getPageByUrl(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj adres URL:  ");
        try {
            URL url = new URL(scanner.nextLine());
        } catch (MalformedURLException e) {
            //e.printStackTrace();
            System.out.println("Podałes niepoprawy adres url. Jeszcze raz.");
            getPageByUrl();
        }
    }
}