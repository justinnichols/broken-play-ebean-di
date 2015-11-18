package dao;

import models.Log;
import org.joda.time.DateTime;

public interface LogDao {
    Log create(DateTime timestamp, String logText, String customData);
}