package com.wuhn.shiro;

import java.util.ArrayList;
import java.util.List;

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

/**
 * @author wuhn
 * @创建时间 20156-01-22
 * @功能 shiro认证授权
 * **/
public class ShiroRealm extends AuthorizingRealm {
	
	/**
	 * @功能 为当前登录的Subject授予角色和权限 
	 * **/
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()  
        String currentUsername = (String)super.getAvailablePrincipal(principals);  
        
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        if(null != currentUsername && "123456@qq.com".equals(currentUsername)){
        	//添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色 
        	simpleAuthorInfo.addRole("admin");
        	//添加权限
        	simpleAuthorInfo.addStringPermission("admin:manage");
        	return simpleAuthorInfo;
        }
        else if(null != currentUsername && "1234561@qq.com".equals(currentUsername)){
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
        
        //此处无需比对,比对的逻辑Shiro会做,我们只需返回一个和令牌相关的正确的验证信息  
        //说白了就是第一个参数填登录用户名,第二个参数填合法的登录密码(可以是从数据库中取到的,本例中为了演示就硬编码了)  
        //这样一来,在随后的登录页面上就只有这里指定的用户和密码才能通过验证  
        if("123456@qq.com".equals(token.getUsername())){  
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo("123456@qq.com", "123456", this.getName());  
            this.setSession("currentUser", "123456@qq.com");  
            return authcInfo;  
        }else if("1234561@qq.com".equals(token.getUsername())){  
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo("1234561@qq.com", "123456", this.getName());  
            this.setSession("currentUser", "1234561@qq.com");  
            return authcInfo;  
        }  
        //没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常  
        return null;  
		
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
