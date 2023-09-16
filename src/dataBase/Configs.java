package dataBase;

public class Configs {
    protected String dbHost ="localhost";
    protected String dbPort="3306";
    protected String dbUser="root";
    protected String dbPass="1234";
    protected String dbName="mydb";
    private static Configs configs;
    private Configs()
    {

    }
    public static Configs intConfig()
    {
        if(configs==null)
        {
            configs = new Configs();
        }
        return configs;
    }

    public String getDbHost() {
        return dbHost;
    }

    public String getDbPort() {
        return dbPort;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public String getDbName() {
        return dbName;
    }
}
