package ru.otus.qa.automation.arquillian;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/number")
public class NumberService {

    @Inject
    protected SecondBean secondBean;

    @GET
    public int getMyNumber() {
        return secondBean.getMyFavoriteNumber();
    }
}
