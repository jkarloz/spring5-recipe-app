package guru.springframework.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.IngredientRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Juan Carlos - 2017/11/15
 *
 */
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {
	
	private final IngredientRepository ingredientRespository;

	public IngredientServiceImpl(IngredientRepository ingredientRespository) {
		this.ingredientRespository = ingredientRespository;
	}

	/* (non-Javadoc)
	 * @see guru.springframework.services.IngredientService#getIngredientsByRecipe(guru.springframework.domain.Recipe)
	 */
	@Override
	public List<Ingredient> getIngredientsByRecipe(Recipe recipe) {
		log.debug("In IngredientService to get ingredients by recipe");

		Optional<List<Ingredient>> ingredientOptional = ingredientRespository.findByRecipe(recipe);
		
		if(!ingredientOptional.isPresent()) {
			throw new RuntimeException("Ingredient Not found!");
		}
		
		return ingredientOptional.get();
	}

}
