package com.wave.user;


import com.wave.user.dao.UserData;

public interface UserService {



    public UserData getUserData(Long id);
    UserData getUserByUserName(String name);
    public void saveUserData(UserData userData);

}
