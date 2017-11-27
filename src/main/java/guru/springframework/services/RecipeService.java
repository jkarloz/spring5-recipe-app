package guru.springframework.services;

import java.util.Set;

import guru.springframework.command.RecipeCommand;
import guru.springframework.domain.Recipe;

/**
 * @author Juan Carlos - 2017/11/06
 *
 */
public interface RecipeService {
	Set<Recipe> getRecipes();
	Recipe findById(long l);
	RecipeCommand findCommandById(Long l);
	RecipeCommand saveRecipeCommand(RecipeCommand command);
}
