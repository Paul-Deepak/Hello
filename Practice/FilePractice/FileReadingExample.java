package Practice.FilePractice;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReadingExample {
    public static void main(String args[]) {
        File myObj = new File("practice\\filepractice\\testfile1.txt");
        try {
            if (myObj.createNewFile())
                System.out.println("File Created "+"ABSOLUTE PATH:"+myObj.getAbsolutePath());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
          } else {
            System.out.println("The file does not exist.");
          }
        try {
            FileWriter a = new FileWriter(myObj);
            a.write("Hi there! Iam Paul Deepak");
            a.flush();
            a.close();
            FileReader b = new FileReader(myObj);
            int i;
            while ((i = b.read()) != -1){
                System.out.print((char) i);
            }
            b.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
