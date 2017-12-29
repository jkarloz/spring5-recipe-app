package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;

/**
 * @author Juan Carlos - 2017/12/28
 *
 */
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

	/**
	 * @param ingredientId
	 * @param recipeOptional
	 */
	void deleteByIdAndRecipe(Long ingredientId, Recipe recipeOptional);

}
