package com.platzi.market.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;

@Repository
public class ProductoRepository implements ProductRepository{
	
	@Autowired
	private ProductoCrudRepository productoCrudRepository;
	
	@Autowired
	@Qualifier("delegate")
	private ProductMapper mapper;
	
	@Override
	public List<Product> getAll(){
		List<Producto> productos = (List<Producto>) this.productoCrudRepository.findAll();
		return mapper.toProducts(productos);
	}
	
	@Override
	public Optional<List<Product>> getByCategory(Integer categoryId) {
		List<Producto> productos = this.productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
		return Optional.of(mapper.toProducts(productos));
	}
	
	@Override
	public Optional<List<Product>> getScarseProducts(Integer quantity) {
		Optional<List<Producto>> productos = this.productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
		return productos.map(prods -> mapper.toProducts(prods));
	}
	
	@Override
	public Optional<Product> getProduct(Integer productId) {
		return this.productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
	}
	
	@Override
	public Product save(Product product) {
		Producto producto = mapper.toProducto(product);
		return mapper.toProduct(this.productoCrudRepository.save(producto));
	}
	
	@Override
	public void delete(Integer idProducto) {
		this.productoCrudRepository.deleteById(idProducto);
	}

	

	
}
