package com.wave.role.dao;


import com.wave.role.RoleData;

import java.util.List;

public interface RoleDao {

    public RoleData getRoleData(Long id);
    public List<RoleData> getAllRoles();
    public void saveRoleData(RoleData itemData);
}
