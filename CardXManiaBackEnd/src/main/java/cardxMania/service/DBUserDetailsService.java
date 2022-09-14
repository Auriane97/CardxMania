package cardxMania.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cardxMania.model.Compte;
import cardxMania.model.Role;


public class DBUserDetailsService implements UserDetailsService {

	private final CompteService compteService;

	public DBUserDetailsService(CompteService compteService) {
		super();
		this.compteService = compteService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
		Optional<Compte> optCompte = compteService.getByPseudo(pseudo);

		if (!optCompte.isPresent()) {
			throw new UsernameNotFoundException(pseudo);
		}

		Compte compte = optCompte.get();

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		for (Role role : compte.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.name()));
		}
		User user = new User(compte.getPseudo(), compte.getPassword(), compte.isActivated(), true, true, true, grantedAuthorities);

		return user;
	}

	

}
