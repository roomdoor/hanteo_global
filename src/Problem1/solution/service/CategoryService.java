package Problem1.solution.service;

import Problem1.solution.domain.Category;
import Problem1.solution.dto.CategoryDto;
import Problem1.solution.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;

public class CategoryService {

	private final CategoryRepository categoryRepository;


	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	public CategoryDto getSubCategoryById(Long id) {
		return categoryRepository.findById(id)
			.map(this::getSubCategory)
			.orElse(null);
	}

	public CategoryDto getSubCategoryByName(String name) {
		return categoryRepository.findByName(name)
			.map(this::getSubCategory)
			.orElse(null);
	}


	private CategoryDto getSubCategory(Category category) {
		CategoryDto categoryDto = new CategoryDto(category.getName());

		List<Long> children = category.getChild_idxes();

		for (Long c : children) {
			Optional<Category> optionalSubCategory = categoryRepository.findById(c);
			optionalSubCategory.ifPresent(value -> categoryDto.addChildren(getSubCategory(value)));
		}

		return categoryDto;
	}

}
