package models;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Log extends BaseModel {
    public static Model.Finder<UUID, Log> find = new Model.Finder<>(datasource, Log.class);

    @Id
    public UUID id;

    @Column(columnDefinition = "datetime")
    public DateTime logTimestamp;

    @Column(columnDefinition = "TEXT")
    public String logText;

    @Column(columnDefinition = "TEXT")
    public String customData;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Log log = (Log) o;

        if (id != null ? !id.equals(log.id) : log.id != null) return false;
        if (logTimestamp != null ? !logTimestamp.equals(log.logTimestamp) : log.logTimestamp != null) return false;
        if (logText != null ? !logText.equals(log.logText) : log.logText != null) return false;
        return !(customData != null ? !customData.equals(log.customData) : log.customData != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (logTimestamp != null ? logTimestamp.hashCode() : 0);
        result = 31 * result + (logText != null ? logText.hashCode() : 0);
        result = 31 * result + (customData != null ? customData.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", timestamp=" + logTimestamp +
                ", logText='" + logText + '\'' +
                ", customData='" + customData + '\'' +
                '}';
    }
}
