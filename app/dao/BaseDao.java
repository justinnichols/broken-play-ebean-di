package dao;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import play.Configuration;
import play.db.ebean.EbeanConfig;

public class BaseDao {
    protected String datasource;
    protected EbeanServer db;

    public BaseDao(Configuration configuration, EbeanConfig ebeanConfig) {
        this.datasource = configuration.getString("datasource.name");
        this.db = Ebean.getServer(this.datasource);
    }
}
