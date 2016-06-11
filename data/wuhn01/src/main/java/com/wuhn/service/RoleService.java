package com.wuhn.service;

import java.util.List;

import com.wuhn.module.Role;


/**
 * @author wuhn
 * @创建时间 2016-02-14
 * @功能 角色接口
 * **/
public interface RoleService {
	/**
	 * @功能 保存角色
	 * @param role 角色
	 * **/
	public boolean saveRole(Role role);
	
	/**
	 * @功能 删除角色
	 * @param roleid 角色主键
	 * **/
	public boolean deleteRole(String roleid); 
	
	/**
	 * @功能 修改角色
	 * @param role【一定要有roleid】 角色
	 * **/
	public boolean updateRole(Role role);
	
	/**
	 * @功能 获取角色详细信息
	 * @param roleid 角色主键
	 * **/
	public Role getRole(String roleid);
	
	/**
	 * @功能 查询全部角色【不分页】
	 * @param List<Role>
	 * **/
	public List<Role> getAllRole();
	
	
	/**
	 * @功能 根据条件查询
	 * @param List<Role> 
	 * **/
	public List<Role> getByRole(Role role);
}
