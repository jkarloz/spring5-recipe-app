package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.domain.Recipe;
import guru.springframework.services.CategoryService;
import guru.springframework.services.IngredientService;
import guru.springframework.services.RecipeService;

/**
 * @author Juan Carlos - 2017/11/13
 *
 */
@Controller
public class RecipeController {

	private final RecipeService recipeService;
	private final CategoryService categoryService;
	private final IngredientService ingredientService;
	
	public RecipeController(RecipeService recipeService, CategoryService categoryService, IngredientService ingredientService) {
		this.recipeService =  recipeService;
		this.categoryService = categoryService;
		this.ingredientService = ingredientService;
	}
	
	@RequestMapping("recipe/show/{recipeId}")
	public String showById(@PathVariable String recipeId, Model model) {
		Recipe recipe = recipeService.findById(new Long(recipeId));
		model.addAttribute("categories", categoryService.getCategories());
		model.addAttribute("ingredients", ingredientService.getIngredientsByRecipe(recipe));
		model.addAttribute("recipe", recipe);
		return "recipe/show";
	}

}
