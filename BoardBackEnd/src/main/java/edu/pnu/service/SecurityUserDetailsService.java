package edu.pnu.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService{

	private final BoardRepository boardRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Long userId;
		try {
			userId = Long.parseLong(username);
		} catch (Exception e) {
			throw new UsernameNotFoundException("Invalid user Id format");
		}
		
		Board board = boardRepo.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return new User(board.getId().toString(), board.getPassword(), AuthorityUtils.createAuthorityList(board.getRole().toString()));
	}
	
	
}
