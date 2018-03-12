package OOPFinal.bo;



/**
 * Created by ericjohn1 on 7/12/2016.
 */
public class Directory extends BaseBO{

    private int dirId;
    private String dirName;
    private double dirSize;
    private int numberOfFiles;
    private String path;

    public Directory(){}

    
    //region get/set
    public int getDirId() {
        return dirId;
    }

    public void setDirId(int dirId) {
        this.dirId = dirId;
    }
    public String getDirName() {
        return dirName;
    }
    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public double getDirSize() {
        return dirSize;
    }

    public void setDirSize(double dirSize) {
        this.dirSize = dirSize;
    }

    public int getNumberOfFiles() {
        return numberOfFiles;
    }

    public void setNumberOfFiles(int numberOfFiles) {
        this.numberOfFiles = numberOfFiles;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //endregion



}
