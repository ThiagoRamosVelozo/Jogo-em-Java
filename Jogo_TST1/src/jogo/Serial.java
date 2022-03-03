package jogo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serial {
    
    public static void serialize(Object obj, String path){
        
        try {
        
            FileOutputStream f = new FileOutputStream(path);
            try (ObjectOutputStream o = new ObjectOutputStream(f)) {
                o.writeObject(obj);
            }
            
        } catch (IOException ex) {System.out.println(ex);}
        
    }
    
    public static <T> T deserialize(String path){
        
        T x = null;
        
        try {
        
            FileInputStream f= new FileInputStream(path);
            try (ObjectInputStream o = new ObjectInputStream(f)) {
                x = (T) o.readObject();
            }
            
        } catch (IOException | ClassNotFoundException ex) {System.out.println(ex);}
        
        return x;
        
    }
    
}
