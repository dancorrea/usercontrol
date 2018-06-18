package br.cubas.usercontrol.services;

import br.cubas.usercontrol.beans.User;

import java.util.List;

public interface UserService {
	
	void save(User user);

	User findByUsername(String username);

	List<User> findAll();
	
}