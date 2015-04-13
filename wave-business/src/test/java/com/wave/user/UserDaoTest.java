package com.wave.user;

import com.wave.role.dao.RoleDao;
import com.wave.role.RoleData;
import com.wave.user.dao.UserDao;
import com.wave.user.dao.UserData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/wave-business-context.xml")
@Transactional
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Test
    public void shouldSaveAndFetchUserWithRoles() {
        System.err.println("testUser1");
        UserData userData = new UserData();
        userData.setUserName("testun");
        userData.setPassword("asfdsafdss");
        userData.setEmail("a@a.com");
        userData.setUserGuid(UUID.randomUUID().toString());
        userData.setDateOfBirth(new Date());
        userData.setCreateDate(new Date());
        userData.setGender("M");
        userData.setDisplayName("asfd");
        userData.setActive(true);


        RoleData roleData = new RoleData();
        roleData.setActive(true);
        roleData.setName("admin1");
        roleData.setDescription("Administrator");
        roleDao.saveRoleData(roleData);

        ArrayList<RoleData> roles = new ArrayList<RoleData>();
        roles.add(roleData);
        userData.setRoles(roles);

        roleData = new RoleData();
        roleData.setActive(true);
        roleData.setName("gp1");
        roleData.setDescription("GP");
        roleDao.saveRoleData(roleData);
        roles.add(roleData);

        if (userDao == null) System.out.println("userDao null =======");
        else System.out.println("userDao not null =======");
        userDao.saveUserData(userData);
        UserData userData1 = userDao.getUserData(userData.getUserId());

        assertEquals("asfdsafdss", userData1.getPassword());
        assertEquals(2, userData1.getRoles().size());



    }




}
