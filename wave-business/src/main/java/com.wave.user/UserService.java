package com.wave.user;


import com.wave.user.dao.UserData;

import java.util.List;

public interface UserService {



    public UserData getUserData(Long id);
    public UserData getUserByUserName(String name);
    public void saveUserData(UserData userData);
    public List<UserData> getAllNewUsers();
    public List<UserData> getAllUsers();

}
