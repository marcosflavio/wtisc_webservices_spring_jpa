package br.com.ufc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "compra")
public class Compra {

	@Id
	@GeneratedValue
	private Long id;
	
	@JoinColumn(name = "usuario_id") // so renomeio o nome da chave estrangeira
	@ManyToOne
	@JsonProperty(value = "usuario")
	private User user;
	
	@JsonProperty(value = "data")
	@Column(name = "data")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT-3")
	private Date date;
	
	@JsonProperty(value = "total")
	@Column(name = "total", nullable = false)
	private Float total;
	
	@JsonProperty(value = "quantidade")
	@Column(name = "quantidade", nullable = false)
	private Integer quantity;

	public Compra(Long id) {
		super();
		this.id = id;
	}

	public Compra() {
		super();
	}

	public Compra(Float total, Integer quantity) {
		super();
		this.total = total;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
