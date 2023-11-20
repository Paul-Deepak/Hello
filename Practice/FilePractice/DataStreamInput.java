package Practice.FilePractice;

import java.io.FileInputStream;

public class DataStreamInput {
    public static void main(String args[]) {
        try {
            FileInputStream fin = new FileInputStream("C:\\Users\\paul\\OneDrive\\ZL-Java-Training\\Practice\\FilePractice\\test.txt");
            int i = 0;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
