package com.assembleyourpc.app.mapper;

import com.assembleyourpc.app.dto.CategoryRequestDTO;
import com.assembleyourpc.app.dto.CategoryResponseDTO;
import com.assembleyourpc.app.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mappings({
            @Mapping(target = "categoryId", ignore = true),
            @Mapping(target = "products", ignore = true),
            @Mapping(target = "categoryCreationDT", ignore = true)
    })
    Category fromCategoryRequestDtoToCategoryObj(CategoryRequestDTO categoryRequestDTO);

    List<CategoryResponseDTO> fromListOfCategoryObjToListOfCategoryResponseDto(List<Category> categories);

    CategoryResponseDTO fromCategoryObjToCategoryResponseDto(Category category);

}
