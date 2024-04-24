package HO;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import Recieve.Recieve;
public class HO extends JFrame  {
    public static void main(String[] args) {
        try {
            Recieve reciever = new Recieve("BO1");
        } catch (Exception et) {
            et.printStackTrace();
        }
        try {
            Recieve reciever = new Recieve("BO2");
        } catch (Exception et) {
            et.printStackTrace();
        }
    }
}