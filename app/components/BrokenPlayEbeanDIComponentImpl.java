package components;

import dao.LogDao;
import org.joda.time.DateTime;
import play.inject.ApplicationLifecycle;
import play.libs.F;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BrokenPlayEbeanDIComponentImpl implements BrokenPlayEbeanDIComponent {
    @Inject
    public BrokenPlayEbeanDIComponentImpl(ApplicationLifecycle lifecycle,
                                          LogDao logDao) {
        logDao.create(DateTime.now(), "BrokenPlayEbeanDIComponentImpl STARTED!", null);

        lifecycle.addStopHook( () -> {
            logDao.create(DateTime.now(), "BrokenPlayEbeanDIComponentImpl STOPPED!", null);
            return F.Promise.pure(null);
        });
    }
}
