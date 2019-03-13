package br.com.codever.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_Venda")
public class CarrinhoCompras implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@JsonIgnore
	@OneToMany(mappedBy = "carrinhoCompras", cascade = CascadeType.ALL)
	private Set<Produto> produtos;

	private float subtotal;
	
	private boolean compra_aprovada;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public boolean isCompra_aprovada() {
		return compra_aprovada;
	}

	public void setCompra_aprovada(boolean compra_aprovada) {
		this.compra_aprovada = compra_aprovada;
	}
	
}
