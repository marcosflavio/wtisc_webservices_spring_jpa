package br.com.ufc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.model.User;
import br.com.ufc.repository.UserRepository;

@Transactional //Essa classe cuidará das transações com o banco de dados
@Service //Essa classe será um webService
public class UserService implements IUserService{

	@Autowired // Injeção de dependência
	private UserRepository repository;
		
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public User save(User user) {
//		
//		Date now = Calendar.getInstance().getTime();
//		user.setCreationDate(now);
		return repository.save(user);
	}

	@Override
	public User update(User user) {
		return repository.save(user); //Mesmo para update, utilizamos o save, pois o spring verifica se o objeto já existe,
		//se ja existe, ele apenas dá update.
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
		
	}

	public List<User> findByName(String name){
		
		return repository.findByName(name);
	}
}
