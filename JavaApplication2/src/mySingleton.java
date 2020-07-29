import java.io.*;
/**
 * Write a description of class mySingleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mySingleton{

    private static ObjectInputStream ser;
    private static mySingleton mysingleton;

    public  static mySingleton getInstance() throws IOException{
        if (mysingleton==null) {
            mysingleton=new mySingleton();
        }
        return mysingleton;
    }

    private mySingleton() throws IOException{
        ser = new ObjectInputStream(new FileInputStream("productos2.txt"));
    }

    public ObjectInputStream getObject(){
        return ser;
    }
}

