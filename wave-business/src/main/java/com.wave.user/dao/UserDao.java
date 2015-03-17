package com.wave.user.dao;


public interface UserDao  {



    public UserData getUserData(Long id);
    UserData getUserByUserName(String name);
    public void saveUserData(UserData userData);

}
