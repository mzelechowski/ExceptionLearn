public class Excep01 {
    public static void main(String[] args) throws IllegalAccessException {

        System.out.println(Excep01.getNumberOfSeconds(-60));

    }
    public static int getNumberOfSeconds(int hour) throws IllegalAccessException {
        if(hour<0){
            throw new IllegalAccessException("Hour must be >=0"+hour);
        }
        return hour*60*60;
    }
}
