package com.wave.user;


import com.wave.user.dao.UserDao;
import com.wave.user.dao.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public UserData getUserData(Long id) {
        return userDao.getUserData(id);
    }

    @Override
    public UserData getUserByUserName(String name) {
        return userDao.getUserByUserName(name);
    }

    public void saveUserData(UserData userData) {
        userDao.saveUserData(userData);
    }
    public List<UserData> getAllNewUsers(){
        return  userDao.getAllNewUsers();
    }
    public List<UserData> getAllUsers(){
        return  userDao.getAllUsers();
    }
}
