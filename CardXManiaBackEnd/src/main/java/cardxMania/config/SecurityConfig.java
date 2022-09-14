package cardxMania.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import cardxMania.service.CompteService;
import cardxMania.service.DBUserDetailsService;

//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {



	@Bean
	public DBUserDetailsService userDetailsService(CompteService compteService) {
		return new DBUserDetailsService(compteService);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//		http.antMatcher("/**").anonymous(); // pour désactiver la sécurité
		http.authorizeHttpRequests((authz) -> {
			authz.anyRequest().authenticated();
		}).httpBasic();

		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
