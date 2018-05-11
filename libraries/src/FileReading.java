import java.io.*;

public class FileReading {
    public static void main(String [] args) {
        FileReading temp = new FileReading();
        temp.start();
    }

    private void start(){
        read("WriteOut.txt");
    }

    private static void read(String fileName){
        String line;
        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                FileWriting.write(line);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }
}
