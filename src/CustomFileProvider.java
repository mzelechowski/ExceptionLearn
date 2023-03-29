import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomFileProvider {
    private final String path;

    public CustomFileProvider(String path) {
        this.path = path;
    }

    /* czytanie pliku za pomocą bufferedreader linia po lini za pomocą klasy BufferedReader*/
    public void readFileBasic(String fileName) {
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader(path + fileName));
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* utrzownie pustego pliku */
    public void createFileUsingFileClass(String fileName) {
        File file = new File(path + fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created in: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Zapisywanie pliku z podaniem wartości w formie List<String>*/
    public void createFileFromCollections(String fileName, List<String> list, OpenOption openOption) {
        Path path = Paths.get(this.path + fileName);
        try {
            if (Files.notExists(path)) Files.createFile(path);
            Files.write(path, list, StandardCharsets.UTF_8, openOption);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Zapisywanie pliku z podaniem wartości w formie List<String> przy pomocy klasy FileWriter*/
    public void createFileWriterFromCollections(String fileName, List<String> list, boolean option) {
        FileWriter fw = null;
        File file = new File(path + fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created in: " + file.getAbsolutePath());
            } else {
                System.out.println(file.getName() + " is exist.");
            }
            fw = new FileWriter(file, option);
            for (String s : list) {
                fw.append(s + "\n");
            }
            fw.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /* Zapisywanie pliku z podaniem wartości w formie List<String> przy pomocy klasy BufferedWriter*/
    public void createFileBufferedFromCollections(String fileName, List<String> list, boolean option) {
        File file = new File(path + fileName);
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            if (file.createNewFile()) {
                System.out.println("File created in: " + file.getAbsolutePath());
            } else {
                System.out.println(file.getName() + " is exist.");
            }
            bw = new BufferedWriter(new FileWriter(file, option));
            for (String s : list) {
                bw.write(s);
                bw.newLine();
            }
            bw.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public List<String> createDataFromFile(String fileName) {
        BufferedReader br;
        List<String> output = new ArrayList<>();
        File file = new File(path + fileName);
        int counter = 0;
        if (!file.exists()) {
            System.out.println(file.getName() + " Nie istnieje. Zwracam pustą listę.");
            return output;
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                output.add(line);
                counter++;
            }
            System.out.println("Odczytałem lini kodu w ilości: " + counter);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("This line will always execute HAHAHA, unless return will work ");
        }
        return output;
    }

    public List<Computer> readStorage(String fileName) {
        BufferedReader br;
        List<Computer> output = new ArrayList<>();
        String line;
        try {
            br = new BufferedReader(new FileReader(path + fileName));
            while ((line = br.readLine()) != null) {
                String[] item = line.split(",");
                output.add(new Computer(item[0].trim(), item[1].trim(), item[2].trim(), item[3].trim(), item[4].trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public void countWordInFile(String fileName, String pattern) {
        BufferedReader br;
        int wordCounter = 0;
        int lineCounter = 0;
        try {
            String line;

            br = new BufferedReader(new FileReader(path + fileName));
            while ((line = br.readLine()) != null) {
                lineCounter++;
                String[] words = line.split(" ");
                for (String w : words) {
                    if (w.replace(",","").replace(".","").equalsIgnoreCase(pattern)) {
                        wordCounter++;
                        System.out.println("Znalazłem szukane słowo w lini: " + lineCounter + " | " + line);
                    }
                }
            }
            System.out.println("Znalazłem szukanych słow w ilości: " + wordCounter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getDataFormUrl(String protocol, String page, String pattern){
        try {
            URL url = new URL(protocol+page);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            File file = new File(path + page.replace(".","").replace("www","")+".txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            int lineCounter=0, wordCounter=0;
            while ((line = br.readLine()) != null) {
                lineCounter++;
                bw.write(line);
                bw.newLine();
                String[] words = line.split(" ");
                for (String w : words) {
                    if (w.replace(",","").replace(".","").equalsIgnoreCase(pattern)) {
                        wordCounter++;
                        //System.out.println("Znalazłem szukane słowo w lini: " + lineCounter + " | " + line);
                    }
                }
            }
            System.out.println("Znalazłem szukanych słow w ilości: " + wordCounter);
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
