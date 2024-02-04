package pe.estebancoder.solutions.eshop.oauth.security;

import java.util.HashMap;
import java.util.Map;

import pe.estebancoder.solutions.eshop.oauth.model.User;
import pe.estebancoder.solutions.eshop.oauth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;


@Component
public class InfoAdicionalToken implements TokenEnhancer{

	@Autowired
	private IUserService userService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();
		
		User user = userService.findByUsername(authentication.getName());
		info.put("nombre", user.getFirstName());
		info.put("apellido", user.getLastName());
		info.put("correo", user.getEmail());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
