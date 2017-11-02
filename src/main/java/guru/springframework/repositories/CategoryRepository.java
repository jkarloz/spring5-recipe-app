package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Category;

/**
 * @author Juan Carlos - 2017/11/01
 *
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
