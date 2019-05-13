package ru.otus.qa.automation.arquillian;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class NumberApplication extends Application {

    public Set<Class<?>> getClasses()
    {
        return new HashSet<>(Collections.singletonList(NumberService.class));
    }
}
