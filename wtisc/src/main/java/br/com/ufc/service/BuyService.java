package br.com.ufc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.ufc.model.Compra;
import br.com.ufc.repository.BuyRepository;

@Service
@Transactional
public class BuyService implements IBuyService {

	@Autowired
	private BuyRepository repository;

	@Override
	public List<Compra> findAll() {
		return repository.findAll();
	}

	@Override
	public Compra findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public Compra save(Compra compra) {
		return repository.save(compra);
	}

	@Override
	public Compra update(Compra compra) {

		if (!(repository.exists(compra.getId()))) {
			throw new EmptyResultDataAccessException(1);
		}
		return repository.save(compra);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);
	}

}
