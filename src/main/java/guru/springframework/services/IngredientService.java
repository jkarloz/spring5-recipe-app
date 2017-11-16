package guru.springframework.services;

import java.util.List;
import java.util.Set;

import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;

/**
 * @author Juan Carlos - 2017/11/15
 *
 */
public interface IngredientService {
	List<Ingredient> getIngredientsByRecipe(Recipe recipe);
}
