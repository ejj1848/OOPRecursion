package OOPFinal.dao.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ericjohn1 on 7/7/2016.
 */
public abstract class MySql {


    protected static String dbHost = "localhost";
    protected static String dbName = "filerecursion";
    protected static String dbUser = "root";
    protected static String dbPassword = "qwe123$!";
    protected static String useSSL = "false";
    protected static String procBod = "true";

    protected static Connection connection = null;

    final static Logger logger = LogManager.getLogger(MySql.class);

    protected static final int GET_BY_ID = 10;
    protected static final int GET_COLLECTION = 20;
    protected static final int GET_DETAILS = 30;
    protected static final int GET_LARGEDIR= 40;
    protected static final int GET_MOSTFILES= 50;
    protected static final int GET_TOPFILES= 60;
    protected static final int GET_CERTAINTYPE = 70;
    protected static final int INSERT = 10;
    protected static final int UPDATE = 20;
    protected static final int DELETE = 30;
    protected static final int DELETEALL =50;

    protected static void Connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("My Sql Driver not Found!" + ex);

        }

        logger.info("My SQL Driver Registered");


        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":3306/" + dbName + "?useSSL=" + useSSL + "&noAccessToProcedureBodies=" + procBod, dbUser, dbPassword);
        } catch (SQLException ex) {
            logger.error("Connection Failed!" + ex);

        }

        if (connection != null) {
            logger.info("Successfully connected");

        } else {
            logger.info("Connection Failed");

        }
    }
}
