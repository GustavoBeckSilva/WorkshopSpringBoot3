package com.compass.springproject.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{ // Relação muitos para um com o usuário

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Marcação que garante que o instante seja exibido no JSON formatado no padrão ISO 8601 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") 
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "client_id") // Nomeia a chave estrangeira da tabela tb_users
	private User client;
	
	public Order() {}

	public Order(Long id, Instant moment, User client) {
		this.id = id;
		this.moment = moment;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public User getClient() {
		return client;
	}
	
	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
}

/*
 * (Um para muitos) Quando um pedido é chamado, o cliente associado a ele
 * é carregado automaticamente.
 * Quando o objeto do lado do muitos é carregado, o um vem junto dele.
 * 
 * Com a associação para muitos isso não ocorre.
 * 
 * */
