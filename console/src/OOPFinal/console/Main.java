package OOPFinal.console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    final static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
      //  Procedures.DeleteItAll();
        Procedures.InputPath();
        Menuuuu();

    }

     private static void Menuuuu(){
        boolean optionMenu = false;
        int selection = 0;


       while (! optionMenu) {
           try {

               Scanner menuselection = new Scanner(System.in);
               System.out.println("|================= MENU =================|");
               System.out.println("| Options:                               |");
               System.out.println("|        1. Directory With Most Files    |");
               System.out.println("|        2. Directory Largest In Size    |");
               System.out.println("|        3. 5 Largest Files              |");
               System.out.println("|        4. Display all '.avi'           |");
               System.out.println("|        5. Clear DB and start over      |");
               System.out.println("|        6. EXIT                         |");
               System.out.println("=========================================|");
               System.out.println("  Hello, Please enter a selection:        ");
               selection = menuselection.nextInt();

               if (selection > 6 || selection < 1)
                   System.out.println("Not Valid Input");

               else

                   switch (selection) {

                       case (1):
                           Procedures.MostFiles();
                           System.out.println( "Most Files");
                           break;

                       case (2):
                           System.out.println("Directory Largest In Size");
                           Procedures.LargestDir();
                           break;
                       case (3):
                           System.out.println("5 Largest Files: ");
                           Procedures.TopFiveLargestFiles();
                           break;
                       case (4):
                           System.out.println("Display all .docs: ");
                           Procedures.DisplayAllType();
                           break;
                       case (5):
                           Procedures.DeleteItAll();
                           System.out.println("Database Cleared");

                           break;
                       case (6):
                           optionMenu = true;
                           System.out.println("Exiting");

                           break;

                       default:
                           System.out.println("ERRRRRRRRR");
                   }
           } catch (InputMismatchException inEX) {
               System.out.println(inEX);
           }
       }
     }
   }





