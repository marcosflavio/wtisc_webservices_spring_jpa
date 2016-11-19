package br.com.ufc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ufc.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//Passo a classe, e o tipo que define a sua chave primária
	//Quem é que faz isso?
	//JPA faz isso
	
	//Consultas JPQL, baseadas em Objeto
	@Query("SELECT u FROM User u WHERE u.name LIKE %?1%") //1 significa o primeiro parametro, ou seja,  o "name"
	public List<User> findByName(String name);	
}
