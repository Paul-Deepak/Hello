package Practice.FilePractice;

import java.io.FileOutputStream;

public class DataStreamOutput {
    public static void main(String args[]){
        try{
            FileOutputStream fout=new FileOutputStream("C:\\Users\\paul\\OneDrive\\ZL-Java-Training\\Practice\\FilePractice\\test.txt");
            fout.write(65);
            String s="This is me Writing this file--Hellllooooo";    
             byte b[]=s.getBytes();//converting string into byte array    
             fout.write(b);    
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
