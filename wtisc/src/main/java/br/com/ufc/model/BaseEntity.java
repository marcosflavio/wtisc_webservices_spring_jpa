package br.com.ufc.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@MappedSuperclass					//trabalhar com heranca, permite que quando extendermos essa classe usuario, ele ira criar
//todas as colunas dessa classe na tabela usuario
//criar uma heranca, e poder levar os atributs criados aqui para a pessoa que herda dessa
public abstract class BaseEntity {

		@Column(name = "data_criacao", insertable = true, updatable = false)
		@JsonProperty(value = "data_criacao")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT-3") //Brazil/East
		private Date creationDate;

		@Column(name = "data_modificacao")
		@JsonProperty(value = "data_modificacao")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT-3") //Brazil/East
		private Date updateDate;
		
		@PrePersist //antes do cara persistir esse dado.. antes de salvar, nao preciso de ir no metodo save
		protected void prePersist(){
			Date now = Calendar.getInstance().getTime();
			this.creationDate = now;
		}
	
		@PreUpdate	//antes de atualizar
		protected void preUpdate(){
			Date now = Calendar.getInstance().getTime();
			this.updateDate = now;
		}
}
