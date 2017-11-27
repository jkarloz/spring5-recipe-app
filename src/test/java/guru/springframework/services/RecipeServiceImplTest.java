package guru.springframework.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.converters.RecipeCommandToRecipe;
import guru.springframework.converters.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

/**
 * @author Juan Carlos - 2017/11/09
 *
 */
public class RecipeServiceImplTest {
	
	RecipeServiceImpl recipeService;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Mock
	RecipeCommandToRecipe  recipeCommandToRecipe;
	
	@Mock
	RecipeToRecipeCommand recipeToRecipeCommand;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
	}

	/**
	 * Test method for {@link guru.springframework.services.RecipeServiceImpl#getRecipes()}.
	 */
	@Test
	public void testGetRecipes() {
		Recipe recipe = new Recipe();
		HashSet recipesData = new HashSet();
		recipesData.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipesData);
		Set<Recipe> recipes = recipeService.getRecipes();
		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();
	}

	@Test
	public void getRecipeByIdTest() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		Optional<Recipe> recipeOptional = Optional.of(recipe);
		
		when(recipeRepository.findById(ArgumentMatchers.anyLong())).thenReturn(recipeOptional);
		
		Recipe recipeReturned = recipeService.findById(1L);
		
		assertNotNull("Null recipe returned", recipeReturned);
		verify(recipeRepository, times(1)).findById(ArgumentMatchers.anyLong());
		verify(recipeRepository, never()).findAll();
	}
	
    @Test
    public void getRecipesTest() throws Exception {

        Recipe recipe = new Recipe();
        HashSet receipesData = new HashSet();
        receipesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(receipesData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(ArgumentMatchers.anyLong());
    }
}
