package br.com.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "usuario")
public class User extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty(value = "nome") //Renomear o nome do Json
	@Column(name = "nome", length = 30, nullable = false)
	@NotNull(message = "{user.name.notNull}")
	@Size(min = 3, max = 30, message = "{user.name.size}" )
	private String name;
	
	@Column(name = "email", length = 30)
	private String email;
	
	@Column(name = "cpf", length = 11, nullable = false)
	private String cpf;
	
	
//	@Column(name = "data_criacao")
//	private Date creationDate;
//	
	
	//Construtor default
	public User() {
		super();
	}

	//Construtor com os atributos que não podem ser nulos
	public User(String name, String cpf) {
		super();
		this.name = name;
		this.cpf = cpf;
	}
	
	//Construtor com a chave primária do BD
	public User(Long id) {
		super();
		this.id = id;
	}

//Gets e Sets

	
	public Long getId() {
		return id;
	}

//	public Date getCreationDate() {
//		return creationDate != null ? (Date) creationDate.clone() : null;
//		//simplificacao do if e else
//		
//	}
//	
//	@Column(name = "data_criacao")
//	@JsonProperty(value = "data_criacao")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT-3") //Brazil/East
//	public void setCreationDate(Date creationDate) {
//		this.creationDate = creationDate != null ? (Date) creationDate.clone() : null;
//	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

//Equals and HashCode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
