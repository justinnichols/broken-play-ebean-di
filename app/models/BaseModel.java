package models;

import com.avaje.ebean.Model;
import com.typesafe.config.ConfigFactory;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel extends Model {
    protected static final String datasource = ConfigFactory.load().getString("datasource.name");
}
