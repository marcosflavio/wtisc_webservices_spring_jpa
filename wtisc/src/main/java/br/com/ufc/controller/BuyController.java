package br.com.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufc.model.Compra;
import br.com.ufc.service.IBuyService;

@RestController
@RequestMapping(value = "/compras")
public class BuyController {
	
	@Autowired
	private IBuyService service;

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Compra>> findAll(){
		
		List<Compra> buyList = service.findAll();
		
		return new ResponseEntity<List<Compra>>(buyList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Compra> findOne(@PathVariable(value = "id") Long id){
		Compra compra = service.findOne(id);
		
		return new ResponseEntity<Compra>(compra, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Compra> save (@RequestBody Compra requestBuy){
		Compra compra = service.save(requestBuy);
		
		return new ResponseEntity<Compra>(compra, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Compra> update(@PathVariable(value = "id") Long id, @RequestBody Compra requestBuy){
		
		Compra compra = service.update(requestBuy);
		
		return new ResponseEntity<Compra>(compra, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // o que importa é o value = "id"s TESTAR
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long a){
		service.delete(a);
	
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
