package oop.sructure.utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Logs {

    public static void createLog (String str){
        try(FileWriter writer = new FileWriter("output.txt", false))
        {
            // запись всей строки

            writer.write(str);


            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public static StringBuilder readLog (){
        StringBuilder res = new StringBuilder();
        try(FileReader reader = new FileReader("output.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                res.append((char)c);
                //System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    return res;
}
}
