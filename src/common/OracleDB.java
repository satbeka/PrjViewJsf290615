package common;

/**
 * Created by SAbdikalikov on 04.09.2015.
 */
public class OracleDB {

    private static String SYSTEM_DB = null;
    private static String DB_PWD=null;
    private static String DB_USERNAME=null;

    public static String getSystemDb()
    {
        if (SYSTEM_DB == null) {
            SYSTEM_DB = PropertiesBuilder.getProperty("urlJDBC");
        }
        return SYSTEM_DB;
    }

    public static String getDbPwd()
    {
        if (DB_PWD == null) {
            DB_PWD = PropertiesBuilder.getProperty("password");
        }
        return DB_PWD;
    }

    public static String getDbUsername()
    {
        if (DB_USERNAME == null) {
            DB_USERNAME = PropertiesBuilder.getProperty("username");
        }
        return DB_USERNAME;
    }


}
