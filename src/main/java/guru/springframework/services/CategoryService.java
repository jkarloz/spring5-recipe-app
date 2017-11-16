package guru.springframework.services;

import java.util.Set;

import guru.springframework.domain.Category;

/**
 * @author Juan Carlos - 2017/11/14
 *
 */
public interface CategoryService {
	Set<Category> getCategories();
}
