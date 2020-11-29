/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytree;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
/**
 *
 * @author ideal
 */
public class FileHandling extends CurrentData {
    private File f; 
    private static FamilyMember rtMemb;
    public static void setRtMemb(FamilyMember rm){
        rtMemb = rm;
    }

    public static FamilyMember getRtMemb() {
        return rtMemb;
    }
    public FamilyMember readFromFile(String fileName){
        try {
            FileInputStream file = new FileInputStream(new File(fileName));
            ObjectInputStream oi = new ObjectInputStream(file);

            // Read objects
            FamilyMember tempObj;
            tempObj = (FamilyMember) oi.readObject();
//            JOptionPane.showMessageDialog(null, super.getRootMember().getName());
//            System.out.println(super.getRootMember().getName());
            
            oi.close();
            file.close();
            return tempObj;

        } catch (FileNotFoundException e) {
                System.out.println("File not found");
        } catch (IOException e) {
                System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return null;
    }
    public void writeIntoFile(){
        try {
            File temp = new File(rtMemb.getName()+"TreeData.txt");
            FileOutputStream f = new FileOutputStream(temp);
            if(temp.exists()){
                JOptionPane.showMessageDialog(null, "File OverWritten! ");
            }
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(rtMemb);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
                System.out.println("File not found");
        } catch (IOException e) {
                System.out.println("Error initializing stream");
        }
    }
}
