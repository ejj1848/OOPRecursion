package OOPFinal.dao.mysql;

import OOPFinal.dao.FileOBJDAO;
import OOPFinal.bo.FileOBJ;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by ericjohn1 on 7/12/2016.
 */
public class FileOBJDAOImpl extends MySql implements FileOBJDAO {
    @Override
    public FileOBJ getFileById(int fileId) {
        Connect();
        FileOBJ fileOBJ = null;

        try{
            String sp = "{call getFile(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID );
            cStmt.setInt(2,fileId);
            ResultSet rs =cStmt.executeQuery();
            if (rs.next()) {
                fileOBJ = HydrateObject(rs);
            }
        }catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException sqlEx){
                logger.error(sqlEx);
            }
        }

        return fileOBJ;
    }

    @Override
    public List<FileOBJ> getFileList() {

            Connect();
            List<FileOBJ> fileOBJList = new ArrayList<FileOBJ>();

            try {
                String sp = "{call getFile(?,?)}";
                CallableStatement cStmt = connection.prepareCall(sp);

                cStmt.setInt(1, GET_COLLECTION);
                cStmt.setInt(2,0);
                ResultSet rs = cStmt.executeQuery();

                while (rs.next()){
                    fileOBJList.add(HydrateObject(rs));
                }
            }catch (SQLException sqlEx){
                logger.error(sqlEx);
            }
            finally {
                try {
                    connection.close();
                }
                catch (SQLException sqlEx){
                    logger.error(sqlEx);
                }
            }

        return fileOBJList;
        }

    @Override
    public List<FileOBJ> getTopFiles() {
        Connect();
        List<FileOBJ> fileOBJList = new ArrayList<FileOBJ>();

        try {
            String sp = "{call getFile(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_TOPFILES);
            cStmt.setInt(2,0);
            ResultSet rs = cStmt.executeQuery();

            while (rs.next()){
                fileOBJList.add(HydrateObject(rs));
            }
        }catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException sqlEx){
                logger.error(sqlEx);
            }
        }

        return fileOBJList;
    }

    @Override
    public List<FileOBJ> getAllFileType() { Connect();
        List<FileOBJ> fileOBJList = new ArrayList<FileOBJ>();

        try {
            String sp = "{call getFile(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_CERTAINTYPE);
            cStmt.setInt(2,0);
            ResultSet rs = cStmt.executeQuery();

            while (rs.next()){
                fileOBJList.add(HydrateObject(rs));
            }
        }catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException sqlEx){
                logger.error(sqlEx);
            }
        }

        return fileOBJList;

    }


    @Override
    public int insertFile(FileOBJ fileOBJ) {
        Connect();
        int id = 0;
        try {
            String sp ="{call ExecFile(?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setInt(3, fileOBJ.getDirId());
            cStmt.setString(4, fileOBJ.getFileName());
            cStmt.setString(5, fileOBJ.getFileType());
            cStmt.setDouble(6, fileOBJ.getFileSize());
            cStmt.setString(7, fileOBJ.getPath());

            ResultSet rs = cStmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }   catch (SQLException sqlEx){
            logger.equals(sqlEx);
        }

        return id;
    }

    @Override
    public boolean updateFile(FileOBJ fileOBJ) {
        Connect();
        int id = 0;
        try {
            String sp = "{call ExecFile(?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, fileOBJ.getFileId());
            cStmt.setInt(3, fileOBJ.getDirId());
            cStmt.setString(4, fileOBJ.getFileName());
            cStmt.setString(5, fileOBJ.getFileType());
            cStmt.setDouble(6, fileOBJ.getFileSize());
            cStmt.setString(7, fileOBJ.getPath());

            ResultSet rs = cStmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }   catch (SQLException sqlEx){
            logger.equals(sqlEx);
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException sqlEx){
                logger.error(sqlEx);
            }
        }


        return id > 0;
    }

    @Override
    public boolean deleteFile(int fileId) {
        Connect();
        int id = 0;
        try {
            String sp = "{call ExecFile(?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, fileId);
            cStmt.setInt(3, 0);
            cStmt.setString(4, "");
            cStmt.setString(5, "");
            cStmt.setInt(6, 0);
            cStmt.setString(7,"");

            ResultSet rs = cStmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }   catch (SQLException sqlEx){
            logger.equals(sqlEx);
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException sqlEx){
                logger.error(sqlEx);
            }
        }


        return id > 0;

    }

    @Override
    public boolean deleteAllFile(int fileId) {Connect();
        int id = 0;
        try {
            String sp = "{call ExecFile(?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETEALL);
            cStmt.setInt(2, 1);
            cStmt.setInt(3, 0);
            cStmt.setString(4, "");
            cStmt.setString(5, "");
            cStmt.setInt(6, 0);
            cStmt.setString(7,"");

            ResultSet rs = cStmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }   catch (SQLException sqlEx){
            logger.equals(sqlEx);
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException sqlEx){
                logger.error(sqlEx);
            }
        }

        return false;
    }

    private static FileOBJ HydrateObject(ResultSet rs) throws SQLException{

        FileOBJ fileOBJ = new FileOBJ();

        fileOBJ.setFileId(rs.getInt(1));
        fileOBJ.setDirId(rs.getInt(2));
        fileOBJ.setFileName(rs.getString(3));
        fileOBJ.setFileType(rs.getString(4));
        fileOBJ.setFileSize(rs.getInt(5));
        fileOBJ.setPath(rs.getString(6));

        return fileOBJ;



    }
}








