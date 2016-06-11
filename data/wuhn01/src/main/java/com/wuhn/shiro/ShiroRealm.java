package com.wuhn.shiro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.wuhn.module.Role;
import com.wuhn.module.User;
import com.wuhn.service.UserService;

/**
 * @author wuhn
 * @创建时间 20156-01-22
 * @功能 shiro认证授权
 * **/
public class ShiroRealm extends AuthorizingRealm {
	
	@Resource
	private UserService userService; 
	
	/**
	 * @功能 为当前登录的Subject授予角色和权限 
	 * **/
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()  
        String currentUsername = (String)super.getAvailablePrincipal(principals);  
        System.out.println("currentUsername:"+currentUsername);
        List<String> roleList = new ArrayList<String>();  
        User user = userService.getUserByName(currentUsername);
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        if (null!=user) {
        	if(null!=user.getRoles() && user.getRoles().size()>0){ 
        		List<Role> roles= user.getRoles();
    			for (Role role : roles) {
    				roleList.add(role.getRolepermission());
    			}
        	}
        	simpleAuthorInfo.addRoles(roleList);	
        	return simpleAuthorInfo;
		}
		return null;
	}
	
	/**
	 * @功能 验证当前登录的Subject
	 * **/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		//获取基于用户名和密码的令牌  
        //实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的  
        //两个token的引用都是一样的,本例中是org.apache.shiro.authc.UsernamePasswordToken@33799a1e  
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;  
        System.out.println("tokenName:"+token.getUsername());
        User user = userService.getUserByName(token.getUsername());
        if (null!=user) {
			System.out.println(user.getNickname());
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getEmail(), user.getPassword(), user.getNickname());  
			this.setSession("currentUser", user);  
			return authcInfo;
		}else{
			return null;
		}
        //此处无需比对,比对的逻辑Shiro会做,我们只需返回一个和令牌相关的正确的验证信息  
        //说白了就是第一个参数填登录用户名,第二个参数填合法的登录密码(可以是从数据库中取到的,本例中为了演示就硬编码了)  
        //这样一来,在随后的登录页面上就只有这里指定的用户和密码才能通过验证  

        //没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常  
		
	}
	
	
	/** 
     * 将一些数据放到ShiroSession中,以便于其它地方使用 
     * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到 
     */  
    private void setSession(Object key, Object value){  
        Subject currentUser = SecurityUtils.getSubject();  
        if(null != currentUser){  
            Session session = currentUser.getSession();  
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");  
            if(null != session){  
                session.setAttribute(key, value);  
            }  
        }  
    }  

}
