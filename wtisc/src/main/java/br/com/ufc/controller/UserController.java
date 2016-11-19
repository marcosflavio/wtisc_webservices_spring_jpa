package br.com.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufc.model.User;
import br.com.ufc.service.IUserService;

@RestController //Esta notação é pra criar um controlador de RestFull
@RequestMapping(value = "/usuarios")
public class UserController {
	
	@Autowired //Injeção de dependência
	private IUserService service;
	
	@RequestMapping(method = RequestMethod.GET) //Digo que quero pegar (GET) dados do Banco
	public ResponseEntity<List<User>> findAll(){
		List<User> userList = service.findAll();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
		
		//Como ele reconheceu que era o UserService e nao outra classe implementando??
	}
/*
 * https://localhost:8060/usuarios/1 conceito de parametrização
 * @return
 * */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> findOne(@PathVariable(value = "id") int id){ // 
		User user = service.findOne(id);
		
		return new ResponseEntity<User>(user, HttpStatus.OK); //Retorna o usuário encontrado e o 200 que deu certo
	}
	
	@RequestMapping(method = RequestMethod.POST) //DDigo ao jpa que quero enviar
	public ResponseEntity<User> save(@RequestBody User requestUser){ //passando um objeto via json
		
		User user = service.save(requestUser);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	//Padrao do srping jpa é get

	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@PathVariable(value = "id") int id, 							
			@RequestBody User requestUser){
		
		requestUser.setId(Long.valueOf(id));
	User user = service.update(requestUser);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // o que importa é o value = "id"s TESTAR
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long a){
		service.delete(a);
	
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
// listar?nome = name
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public  ResponseEntity<List<User>> findByName(@RequestParam(value = "nome") String name){
		
		List <User> userList = service.findByName(name);
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
}