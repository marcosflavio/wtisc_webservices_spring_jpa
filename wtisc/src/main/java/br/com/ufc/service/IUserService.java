package br.com.ufc.service;

import java.util.List;

import br.com.ufc.model.User;

public interface IUserService {

	public List<User> findAll();

	public User findOne(long id);

	public User save(User user);

	public User update(User user);

	public void delete(Long id);
	
	public List<User> findByName(String name);
}
