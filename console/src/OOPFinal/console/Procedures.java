package OOPFinal.console;
import OOPFinal.bo.Directory;
import OOPFinal.bo.BaseBO;
import OOPFinal.bo.FileOBJ;
import OOPFinal.dao.DirectoryDAO;
import OOPFinal.*;
import OOPFinal.dao.FileOBJDAO;

import OOPFinal.dao.mysql.DirectoryDAOImpl;
import OOPFinal.dao.mysql.FileOBJDAOImpl;

import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;


/**
 * Created by ericjohn1 on 7/13/2016.
 */
       public class Procedures {
    final static Logger logger = org.apache.logging.log4j.LogManager.getLogger(Main.class);


    //Create an input for entry, Then passe this info to another method
        public static void InputPath(){
        String path;
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter a path: "); // Enter Directory !
        try {
            path = input.nextLine();
            File file = new File(path);
            if (file.exists()) {
                BaseDirectory(file);                // Pass to Base Directory
            }else{
                System.out.println("Cannot Enter!");
            }
        }catch(InputMismatchException imEx){
            logger.error(imEx);
        }}

//      Base Directory Method, Needed to set
        public static void BaseDirectory(File dir) {
        //notes:    create base directory object
        Directory directory = new Directory();
        directory.setDirName(dir.getName());
        directory.setPath(dir.getParent());
        double directorySizeBytes = (DirectorySizeHelp(dir));
        double directorySizeKB = directorySizeBytes / 1024;
        double directorySizeMB =  directorySizeKB /1024;
        directory.setDirSize(directorySizeMB);
        directory.setNumberOfFiles(dir.list().length);

        DirectoryDAO directoryDAO = new DirectoryDAOImpl();
        int dirId = directoryDAO.insertDirectory(directory);

        FileBucket(dir, dirId);

        // Pass to create remaining directories and files
    }
//      PASSES THE dir, dirId over to the FileBucket method

        public static void FileBucket(File dir, int parentDirectory) {

        Directory directory = new Directory();
        FileOBJ fileOBJ = new FileOBJ();

        try {
            int dirId = 0;
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory())
               // recursion happens here
                {   // set name
                    directory.setDirName(file.getName());
                    // set path
                    directory.setPath(file.getPath());
                     // return size MB
                    double directorySizeBytes = (DirectorySizeHelp(file));
                    double directorySizeKB = directorySizeBytes / 1024;
                    double directorySizeMB =  directorySizeKB /1024;
                    directory.setDirSize(directorySizeMB);
                    // Set number of files.  Create a list of files and count


                    DirectoryDAO directoryDAO = new DirectoryDAOImpl();
                    directory.setDirId(dirId);
                    dirId = directoryDAO.insertDirectory(directory);
                    logger.info("Directory Stored");


                    FileBucket(file, dirId);
                }
                else{

                   //set name
                   fileOBJ.setFileName(file.getName());
                   //set file type
                   fileOBJ.setFileType(Files.probeContentType(file.toPath()));
                   //set Path
                   fileOBJ.setPath(file.getParent());

                    double fileSizeInBytes = file.length();
                    // Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
                    double fileSizeInKB = fileSizeInBytes / 1024;
                    // Convert the KB to MegaBytes (1 MB = 1024 KBytes)
                    double fileSizeInMB = fileSizeInKB / 1024;

                    fileOBJ.setFileSize(fileSizeInMB);

                    FileOBJDAO fileOBJDAO = new FileOBJDAOImpl();
                    fileOBJ.setDirId(parentDirectory);

                    int id = fileOBJDAO.insertFile(fileOBJ);
                    logger.info("File Printed");
                }
                }
            }catch (IOException ioEx) {
            System.out.println(ioEx);
        }
     }

        public static double DirectorySizeHelp(File dir){
        double sum = 0;
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()){
                DirectorySizeHelp(file);
            }else{
                sum = sum + file.length();
            }
        }
        return sum;

    }
        public static void DeleteItAll(){
        DirectoryDAO directoryDAO = new DirectoryDAOImpl();
        FileOBJDAO fileOBJDAO = new FileOBJDAOImpl();

        try{
            fileOBJDAO.deleteAllFile(1);
            directoryDAO.deleteAllDirectory(1);
            System.out.println("Deleted");

        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

// region menu methods

        public static void MostFiles() {

        DirectoryDAO directoryDAO = new DirectoryDAOImpl();
        List<Directory> directoryList = directoryDAO.getMostFiles();

        for(Directory directory: directoryList){
            System.out.println("Directory With Most Files: "+ directory.getDirName() +"Number of Files: " + directory.getNumberOfFiles());
        }

    }

        public static void LargestDir() {
        DirectoryDAO directoryDAO = new DirectoryDAOImpl();
        List<Directory> directoryList = directoryDAO.getLargestDirectory();

        for(Directory directory:directoryList){
            System.out.println("Largest Directory: " + directory.getDirName()+ "  Directory Size: " + directory.getDirSize() + " MB ");
        }
    }

        public static void TopFiveLargestFiles(){

        FileOBJDAO fileOBJDAO = new FileOBJDAOImpl();
        List<FileOBJ> fileOBJList = fileOBJDAO.getTopFiles();

        for(FileOBJ fileOBJ: fileOBJList){
            System.out.println("5 Largest Files: " + fileOBJ.getFileName() +"  Size: " + fileOBJ.getFileSize());
        }
    }

        public static void DisplayAllType(){

        FileOBJDAO fileOBJDAO = new FileOBJDAOImpl();
        List<FileOBJ> fileOBJList = fileOBJDAO.getAllFileType();

        for (FileOBJ fileOBJ: fileOBJList){
            System.out.println("AVI Files: " + fileOBJ.getFileName() + "   Type:  " + fileOBJ.getFileType());
        }
    }

// endregion
}


