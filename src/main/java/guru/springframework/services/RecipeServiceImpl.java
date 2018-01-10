package guru.springframework.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import guru.springframework.command.RecipeCommand;
import guru.springframework.converters.RecipeCommandToRecipe;
import guru.springframework.converters.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.exceptions.NotFoundException;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Juan Carlos - 2017/11/06
 *
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
	private final RecipeCommandToRecipe recipeCommandToRecipe;
	private final RecipeToRecipeCommand recipeToRecipeCommand;
	
		public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
		this.recipeRepository = recipeRepository;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
	}

	@Override
	public Set<Recipe> getRecipes() {
		log.debug("I'm in the service");
		Set<Recipe> recipeSet = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		return recipeSet;
	}

	/**
	 * @param l
	 * @return
	 */
	public Recipe findById(long l) {
		Optional<Recipe> recipeOptional = recipeRepository.findById(l);
		
		if(!recipeOptional.isPresent()) {
			//throw new RuntimeException("Recipe Not found!");
			throw new NotFoundException("Recipe Not found!");
		}
		
		return recipeOptional.get();
	}

	/* (non-Javadoc)
	 * @see guru.springframework.services.RecipeService#saveRecipeCommand(guru.springframework.command.RecipeCommand)
	 */
	@Override
	@Transactional
	public RecipeCommand saveRecipeCommand(RecipeCommand command) {

        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
	}

	/* (non-Javadoc)
	 * @see guru.springframework.services.RecipeService#findCommandById(java.lang.Long)
	 */
	@Override
	public RecipeCommand findCommandById(Long l) {
		return recipeToRecipeCommand.convert(findById(l));
	}

	/* (non-Javadoc)
	 * @see guru.springframework.services.RecipeService#deleteById(java.lang.Long)
	 */
	@Override
	public void deleteById(Long idToDelete) {
		recipeRepository.deleteById(idToDelete);
	}

}
