package Utilities;

import Pojo.UserData;

public class TestDataBuild {
    public UserData validUser() {
        UserData userData = new UserData();
        userData.setEmail("eve.holt@reqres.in");
        userData.setPassword("pistol");
        return userData;
    }

    public UserData invalidUser(String email, String password) {
        UserData userData = new UserData();
        userData.setEmail(email);
        userData.setPassword(password);
        return userData;
    }
}
