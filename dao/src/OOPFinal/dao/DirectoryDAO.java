package OOPFinal.dao;


import OOPFinal.bo.Directory;
import java.util.List;

/**
 * Created by ericjohn1 on 7/12/2016.
 */
public interface DirectoryDAO {

    public Directory getDirectoryById (int directoryId);
    public List<Directory> getDirectoryList();
    public List<Directory> getLargestDirectory();
    public List<Directory> getMostFiles();

    //execute
    public  int insertDirectory(Directory directory);
    public boolean updateDirectory (Directory directory);
    public boolean deleteDirectory (int directoryId);
    public boolean deleteAllDirectory (int directoryId);
}
