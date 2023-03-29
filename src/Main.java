import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CustomFileProvider customFileProvider = new CustomFileProvider("C:\\Mike\\ExceptionLearn\\src\\storage\\");
//        customFileProvider.readFileBasic("plik.txt");
//        customFileProvider.createFileUsingFileClass("fileToCreate.txt");
//
//        List<String> lista = Arrays.asList("Maciek","Adam", "Bartek", "Celina", "Danuta");
//        customFileProvider.createFileFromCollections("fileFromList.txt",lista, StandardOpenOption.APPEND);
//        customFileProvider.createFileWriterFromCollections("file1.txt", lista, true);
//        customFileProvider.createFileBufferedFromCollections("file2.txt", lista, true);

//        for(String s: customFileProvider.createDataFromFile("file2.txt")){
//            System.out.println(s);
//        }
//        customFileProvider.readFileBasic("plik.txt");
//        System.out.println(customFileProvider.createDataFromFile("file2a.txt"));
//
//        for(Computer c: customFileProvider.readStorage("komputery.txt")){
//            System.out.println(c);
//        }
//        customFileProvider.countWordInFile("pantadeusz.txt", "dom");
//        customFileProvider.getDataFormUrl("https://","wp.pl", "minister");
        customFileProvider.getDataFormUrl("https://","tvn24.pl", "pis");

    }
}


