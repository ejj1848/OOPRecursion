package OOPFinal.bo;

/**
 * Created by ericjohn1 on 7/12/2016.
 */
public class FileOBJ extends BaseBO {

    private int fileId;
    private int dirId;
    private String fileName;
    private String fileType;



    private double  fileSize;
    private String  path;

    public FileOBJ(){}

    //region get/set
    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getDirId() {
        return dirId;
    }

    public void setDirId(int dirId) {
        this.dirId = dirId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    //endregion


}
