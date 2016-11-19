package br.com.ufc.service;

import java.util.List;

import br.com.ufc.model.Compra;

public interface IBuyService {
	
	
	public List<Compra> findAll();
	public Compra findOne( long id);
	public Compra save(Compra compra);
	public Compra update(Compra compra);
	public void delete(long id);

}
