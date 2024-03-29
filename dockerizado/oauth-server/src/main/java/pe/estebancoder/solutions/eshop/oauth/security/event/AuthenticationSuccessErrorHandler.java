package pe.estebancoder.solutions.eshop.oauth.security.event;

import pe.estebancoder.solutions.eshop.oauth.model.User;
import pe.estebancoder.solutions.eshop.oauth.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;


import feign.FeignException;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

	private Logger log = LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);

	@Autowired
	private IUserService userService;
	
	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		
		// if(authentication.getName().equalsIgnoreCase("frontendapp")) {
		if(authentication.getDetails() instanceof WebAuthenticationDetails) {
			return;
		}
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String mensaje = "Success Login: " + userDetails.getUsername();
		System.out.println(mensaje);
		log.info(mensaje);

		User user = userService.findByUsername(authentication.getName());
		
		if(user.getIntentos() != null && user.getIntentos() > 0) {
			user.setIntentos(0);
			userService.update(user, user.getId());
		}
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		String mensaje = "Error en el Login: " + exception.getMessage();
		log.error(mensaje);
		System.out.println(mensaje);

		try {
			
			StringBuilder errors = new StringBuilder();
			errors.append(mensaje);
			
			User user = userService.findByUsername(authentication.getName());
			if (user.getIntentos() == null) {
				user.setIntentos(0);
			}
			
			log.info("Intentos actual es de: " + user.getIntentos());
			
			user.setIntentos(user.getIntentos()+1);
			
			log.info("Intentos después es de: " + user.getIntentos());
			
			errors.append(" - Intentos del login: " + user.getIntentos());
			
			if(user.getIntentos() >= 3) {
				String errorMaxIntentos = String.format("El user %s des-habilitado por máximos intentos.", user.getUsername());
				log.error(errorMaxIntentos);
				errors.append(" - " + errorMaxIntentos);
				user.setEnabled(false);
			}

			log.info("Antes de hacer usuarioService.update");
			
			userService.update(user, user.getId());

			log.info("Despues de hacer usuarioService.update");
			
		} catch (FeignException e) {
			log.error(String.format("El user %s no existe en el sistema", authentication.getName()), e);
		}

	}

}
