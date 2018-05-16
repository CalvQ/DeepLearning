package utils;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class StringGenerator {
    public static void main(String args[]){
        StringGenerator temp = new StringGenerator();//REVELATION:  HAVE 'IN' BE WORDS AND THOSE WILL BE NODES OF 0/1
        temp.start();                                   //THEN OUTPUTS ARE PHRASES
    }                                                   //FIND KEYWORDS FIRST AND THEN IF NOT SENT IT TO NN

    private void start(){
        //Verification of duplicates
        HashSet <String> stringsIn = new HashSet<>();
        HashSet <String> stringsOut = new HashSet<>();
        read("WriteIn.txt", stringsIn);
        read("WriteOut.txt", stringsOut);
        System.out.println("Let's begin");

        //var declaration
        Scanner sc = new Scanner(System.in);
        String sentence = "";

        while(!sentence.equalsIgnoreCase("done")) {
            System.out.println("Prompt: ?");
            sentence = sc.nextLine();

            sentence = cut(sentence);

            String[] arr = sentence.split(" ");
            for (String in : arr) {
                in = in.toLowerCase();
                in = cut(in);
                stringsIn.add(in);
            }

            System.out.println("Response: ?");
            sentence = sc.nextLine();

            sentence = cut(sentence);

            if(!sentence.equalsIgnoreCase("done")) {
                stringsOut.add(sentence);
            }
        }
        clearFile("WriteIn.txt");
        clearFile("WriteOut.txt");
        for(String temp: stringsIn){
            write(temp, "WriteIn.txt");
        }
        for(String temp: stringsOut){
            write(temp, "WriteOut.txt");
        }
    }

    private String cut(String sentence){
        if(sentence.charAt(sentence.length()-1) == '.'||
                sentence.charAt(sentence.length()-1) == '"'||
                sentence.charAt(sentence.length()-1) == '?'||
                sentence.charAt(sentence.length()-1) == '!'||
                sentence.charAt(sentence.length()-1) == ' '||
                sentence.charAt(sentence.length()-1) == '\n'||
                sentence.charAt(sentence.length()-1) == ','||
                sentence.charAt(sentence.length()-1) == ';'||
                sentence.charAt(sentence.length()-1) == ':')
        {
            sentence = sentence.substring(0,sentence.length()-1);
            sentence = cut(sentence);
        }
        return sentence;
    }

    private void clearFile(String fileName){
        try(FileWriter fw = new FileWriter(fileName, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.print("");
        } catch (IOException e){
            System.out.println("error reading file '" +fileName + "'");
        }
    }

    private void write(String input, String fileName){
        try(FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(input);
        } catch (IOException e) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    private void read(String fileName, HashSet <String> strings){
        String line;
        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                strings.add(line);
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
