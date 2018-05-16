package utils;

import java.io.IOException;
import java.io.*;

public class FileWriting {
    public static void main(String args[]){
        FileWriting temp = new FileWriting();
        temp.start();
    }

    private void start(){
        String test = "banana harambe";
        write(test);
        write("\n");
    }

    public static void write(String input){
        try(FileWriter fw = new FileWriter("WriteIn.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(input);
        } catch (IOException e) {
            System.out.println("Error with write()\n");
            e.printStackTrace();
        }
    }
}
