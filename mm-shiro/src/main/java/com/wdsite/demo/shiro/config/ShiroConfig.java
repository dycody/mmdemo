package com.wdsite.demo.shiro.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wdsite.demo.shiro.realm.MyShiroRealm;

@Configuration
public class ShiroConfig {
	
	@Bean
	public ShiroFilterChainDefinition shiroFilterChainDefinition() {
	    DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
	    
	    // logged in users with the 'admin' role
	    chainDefinition.addPathDefinition("/admin/**", "authc, roles[admin]");
	    
	    // logged in users with the 'document:read' permission
	    chainDefinition.addPathDefinition("/docs/**", "authc, perms[document:read]");
	    
	    // all other paths require a logged in user
	    chainDefinition.addPathDefinition("/**", "authc");
	    return chainDefinition;
	}
	
	@Bean
	public Realm realm() {
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		return myShiroRealm;
	}

}
