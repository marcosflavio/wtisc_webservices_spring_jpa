package br.com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.model.Compra;

@Repository
public interface BuyRepository extends JpaRepository<Compra, Long>{


	
	
}
