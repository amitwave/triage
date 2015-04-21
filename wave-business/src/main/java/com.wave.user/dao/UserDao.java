package com.wave.user.dao;


import java.util.List;

public interface UserDao  {



    public UserData getUserData(Long id);
    public UserData getUserByUserName(String name);
    public void saveUserData(UserData userData);
    public List<UserData> getAllNewUsers();
    public List<UserData> getAllUsers();
}
