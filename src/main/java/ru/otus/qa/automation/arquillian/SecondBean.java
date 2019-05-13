package ru.otus.qa.automation.arquillian;

import javax.inject.Inject;

public class SecondBean {

    @Inject
    private FirstBean firstBean;

    public int getMyFavoriteNumber() {
        return firstBean.getSecretNumber();
    }
}
