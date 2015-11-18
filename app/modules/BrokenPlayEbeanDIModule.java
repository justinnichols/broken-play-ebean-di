package modules;

import components.BrokenPlayEbeanDIComponent;
import components.BrokenPlayEbeanDIComponentImpl;
import dao.LogDao;
import dao.LogDaoImpl;
import play.api.Configuration;
import play.api.Environment;
import play.api.inject.Binding;
import play.api.inject.Module;
import scala.collection.Seq;

public class BrokenPlayEbeanDIModule extends Module {
    public Seq<Binding<?>> bindings(Environment environment, Configuration configuration) {
        return seq(
                bind(LogDao.class).to(LogDaoImpl.class),
                bind(BrokenPlayEbeanDIComponent.class).to(BrokenPlayEbeanDIComponentImpl.class).eagerly()
        );
    }
}
