package guru.springframework.services;

import guru.springframework.command.IngredientCommand;

/**
 * @author Juan Carlos - 2017/12/15
 *
 */
public interface IngredientService {
	IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
