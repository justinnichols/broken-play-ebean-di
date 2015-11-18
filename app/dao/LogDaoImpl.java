package dao;

import com.avaje.ebean.annotation.Transactional;
import models.Log;
import org.joda.time.DateTime;
import play.Configuration;
import play.api.db.evolutions.DynamicEvolutions;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LogDaoImpl extends BaseDao implements LogDao {
    @Inject
    public LogDaoImpl(Configuration configuration, DynamicEvolutions dynamicEvolutions, EbeanConfig ebeanConfig) {
        super(configuration, ebeanConfig);
    }

    @Transactional
    public Log create(DateTime timestamp, String logText, String customData) {
        Log log = new Log();
        log.logTimestamp = timestamp;
        log.logText = logText;
        log.customData = customData;
        db.save(log);

        return log;
    }
}
