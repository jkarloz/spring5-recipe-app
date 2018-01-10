package guru.springframework.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.command.IngredientCommand;
import guru.springframework.converters.IngredientCommandToIngredient;
import guru.springframework.converters.IngredientToIngredientCommand;
import guru.springframework.converters.UnitOfMeasureCommandToUnitOfMeasure;
import guru.springframework.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.IngredientRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;

/**
 * @author Juan Carlos - 2017/12/19
 *
 */
public class IngredientServiceImplTest {
	
	private final IngredientToIngredientCommand ingredientToIngredientCommand;
	
	@Mock
	RecipeRepository recipeRepository;
	IngredientService ingredientService;
	UnitOfMeasureService unitOfMeasureService;
	@Mock
	UnitOfMeasureRepository unitOfMeasureRepository;
	IngredientCommandToIngredient ingredientCommandToIngredient;
	@Mock
	IngredientRepository ingredientRepository;
	
	//init converters
	public IngredientServiceImplTest() {
		this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
		this.ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, recipeRepository, 
				unitOfMeasureRepository, ingredientCommandToIngredient, ingredientRepository);		
	}
	
	@Test
	public void findByRecipeIdAndId() throws Exception {
		
	}
	
	@Test
	public void findByRecipeIdAndRecipeIdHappyPath() throws Exception {
		//given
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		
		Ingredient ingredient1 = new Ingredient();
		ingredient1.setId(1L);
		
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setId(1L);
		
		Ingredient ingredient3 = new Ingredient();
		ingredient3.setId(3L);
		
		recipe.addIngredient(ingredient1);
		recipe.addIngredient(ingredient2);
		recipe.addIngredient(ingredient3);
		Optional<Recipe> recipeOptional = Optional.of(recipe);
		
		when(recipeRepository.findById(ArgumentMatchers.anyLong())).thenReturn(recipeOptional);
		
		
		//then
		IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);
		
		//when
		assertEquals(Long.valueOf(3L), ingredientCommand.getId());
		assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
		verify(recipeRepository, times(1)).findById(ArgumentMatchers.anyLong());
		
	}
	
	@Test
	public void testSaveRecipeCommand() throws Exception{
		//given
		IngredientCommand command = new IngredientCommand();
		command.setId(3L);
		command.setRecipeId(2L);
		
		Optional<Recipe> recipeOptional = Optional.of(new Recipe());
		
		Recipe savedRecipe = new Recipe();
		savedRecipe.addIngredient(new Ingredient());
		savedRecipe.getIngredients().iterator().next().setId(3L);
		
		when(recipeRepository.findById(ArgumentMatchers.anyLong())).thenReturn(recipeOptional);
		when(recipeRepository.save(ArgumentMatchers.any())).thenReturn(savedRecipe);
		
		//when
		IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);
		
		//then
		assertEquals(Long.valueOf(3L), savedCommand.getId());
		verify(recipeRepository, times(1)).findById(ArgumentMatchers.anyLong());
		verify(recipeRepository, times(1)).save(ArgumentMatchers.any(Recipe.class));
	}
	
	@Test
	public void testDeleteById() throws Exception {
		//given
		Recipe recipe = new Recipe();
		Ingredient ingredient = new Ingredient();
		ingredient.setId(3L);
		recipe.addIngredient(ingredient);
		ingredient.setRecipe(recipe);
		Optional<Recipe> recipeOptional = Optional.of(recipe);
		
		when(recipeRepository.findById(ArgumentMatchers.anyLong())).thenReturn(recipeOptional);
		
		//when
		ingredientService.deleteByRecipeIdAndIngredientId(1L, 3L);
		
		//then
		verify(recipeRepository, times(1)).findById(ArgumentMatchers.anyLong());
		verify(recipeRepository, times(1)).save(ArgumentMatchers.any(Recipe.class));
	}

}