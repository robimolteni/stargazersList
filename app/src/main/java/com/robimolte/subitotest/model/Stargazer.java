package com.robimolte.subitotest.model;

import java.io.Serializable;

/**
 * Created by robimolte on 04/02/2017.
 */

public class Stargazer implements Serializable {

    private final String login;
    private final String avatar_url;



    public Stargazer(String login, String avatar_url) {
        this.login = login;
        this.avatar_url = avatar_url;
    }


    public String getLogin() {
        return login;
    }


    public String getAvatar_url() {
        return avatar_url;
    }



}
