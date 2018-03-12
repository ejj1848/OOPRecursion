package OOPFinal.dao;

import OOPFinal.bo.FileOBJ;

import java.util.List;

/**
 * Created by ericjohn1 on 7/12/2016.
 */
public interface FileOBJDAO {

    //get
    public FileOBJ getFileById (int fileId);
    public List<FileOBJ> getFileList();
    public List<FileOBJ> getTopFiles();
    public List<FileOBJ> getAllFileType();

    //execute
    public int insertFile (FileOBJ fileOBJ);
    public boolean updateFile (FileOBJ fileOBJ);
    public boolean deleteFile (int fileId);
    public boolean deleteAllFile(int fileId);
}
