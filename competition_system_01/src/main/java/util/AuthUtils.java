package util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import competition.domain.view.AuthView;

public class AuthUtils {
	public static List<String> getAuthNames(List<AuthView> authList, int authIds){
		int sumAuth = authIds;
		List<String> authNames = new ArrayList<String>();
		
		for(AuthView av : authList){
			if(sumAuth >= av.getAuthId()){
				sumAuth -= av.getAuthId();
				authNames.add(av.getAuthName());
			}
		}
		return authNames;
	}
	
	public static List<String> getAuthNames(Authentication auth){
		List<String> authNames =  new ArrayList<String>();
		for(GrantedAuthority authName : auth.getAuthorities())
			authNames.add(authName.getAuthority());
		return authNames;
	}
}
