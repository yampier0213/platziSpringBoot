package com.platzi.market.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compras")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compra")
	private Integer idCompra;
	
	@Column(name = "id_cliente")
	private String id_cliente;
	
	private LocalDateTime fecha;
	
	@Column(name = "medio_pago")
	private String medio_pago;
	
	private String comentario;
	
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", insertable = false, updatable = false)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "productos")
	private List<ComprasProducto> comprasProductos;

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public String getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getMedio_pago() {
		return medio_pago;
	}

	public void setMedio_pago(String medio_pago) {
		this.medio_pago = medio_pago;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
