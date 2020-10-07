package br.nom.wbarbosa.mvc.mudi.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.nom.wbarbosa.mvc.mudi.model.entity.Usuario;
import br.nom.wbarbosa.mvc.mudi.repository.UsuarioRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and()
				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/home", true)
						.permitAll())
				.logout(logout -> logout.logoutUrl("/logout")).csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		Usuario usuario = null;

		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder);

		if (usuarioRepository.count() == 0) {
			usuario = new Usuario();
			usuario.setUsername("joao");
			usuario.setPassword(encoder.encode("joao"));
			usuario.setEnabled(true);
			usuarioRepository.save(usuario);

			usuario = new Usuario();
			usuario.setUsername("maria");
			usuario.setPassword(encoder.encode("maria"));
			usuario.setEnabled(true);
			usuarioRepository.save(usuario);
		}


	}

//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder().username("joao").password("joao").roles("USER").build(); // Nao
//																														// recomendado
//																														// para
//																														// PRD.
//
//		return new InMemoryUserDetailsManager(user);
//	}
}
