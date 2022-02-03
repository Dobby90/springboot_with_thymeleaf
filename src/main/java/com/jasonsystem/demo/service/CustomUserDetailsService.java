package com.jasonsystem.demo.service;

import java.util.Collection;

import com.jasonsystem.demo.model.UserVO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    /**
     * 인증
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO userVO = userService.getUserId(username);
        return new User(userVO.getUserId(), userVO.getPassword(), getAuthorities(userVO));
    }

    /**
	 * 권한
	 * @param userVO
	 * @return
	 */
	private Collection<? extends GrantedAuthority> getAuthorities(UserVO userVO) {
		String userRoles =  userVO.getRoleCd();
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
		return authorities;
	}
	
}
