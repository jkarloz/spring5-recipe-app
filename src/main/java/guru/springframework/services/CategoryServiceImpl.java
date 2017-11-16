package guru.springframework.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.domain.Category;
import guru.springframework.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Juan Carlos - 2017/11/14
 *
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Set<Category> getCategories() {
		log.debug("In service : getting category list");
		Set<Category> categorySet =  new HashSet<>();
		categoryRepository.findAll().iterator().forEachRemaining(categorySet::add);
		return categorySet;
	}

}
