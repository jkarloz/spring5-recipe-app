package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Recipe;

/**
 * @author Juan Carlos - 2017/11/01
 *
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long>{ //Recipe goes for type and Long goes for type of Id
	
}
