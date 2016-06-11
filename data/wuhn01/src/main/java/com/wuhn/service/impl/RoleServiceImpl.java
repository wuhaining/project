package com.wuhn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuhn.dao.RoleMapper;
import com.wuhn.module.Role;
import com.wuhn.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Resource  
	private RoleMapper roleDao;
	
	public boolean saveRole(Role role) {
		if (roleDao.insertSelective(role)==1) {
			return true;
		}
		return false;
	}

	public boolean deleteRole(String roleid) {
		if (roleDao.deleteByPrimaryKey(roleid)==1) {
			return true;
		}
		return false;
	}

	public boolean updateRole(Role role) {
		if (roleDao.updateByPrimaryKeySelective(role)==1) {
			return true;
		}
		return false;
	}

	public Role getRole(String roleid) {
		return roleDao.selectByPrimaryKey(roleid);
	}

	public List<Role> getAllRole() {
		return roleDao.selectAll();
	}

	public List<Role> getByRole(Role role) {
		return roleDao.selectByRole(role);
	}

}
