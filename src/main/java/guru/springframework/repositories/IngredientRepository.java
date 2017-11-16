package guru.springframework.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;

/**
 * @author Juan Carlos - 2017/11/15
 *
 */
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
	Optional<List<Ingredient>> findByRecipe(Recipe recipe);
}
