package pe.estebancoder.solutions.eshop.oauth.service;


import pe.estebancoder.solutions.eshop.oauth.model.User;

public interface IUserService {
	
	public User findByUsername(String username);
	
	public User update(User user, Long id);

}
