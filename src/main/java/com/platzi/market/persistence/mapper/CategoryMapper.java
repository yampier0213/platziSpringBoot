package com.platzi.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	
	@Mappings({
		@Mapping(source = "idCategoria", target = "CategoryId"),
		@Mapping(source = "descripcion", target = "category"),
		@Mapping(source = "estado", target = "active")
	})
	Category toCategory(Category category);
	
	@InheritInverseConfiguration
	@Mapping(target = "productos", ignore = true)
	Category toCategoria(Categoria categoria);
}
