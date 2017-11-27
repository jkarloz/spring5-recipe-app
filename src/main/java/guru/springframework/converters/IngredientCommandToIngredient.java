package guru.springframework.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import guru.springframework.command.IngredientCommand;
import guru.springframework.domain.Ingredient;
import lombok.Synchronized;

/**
 * @author Juan Carlos - 2017/11/24
 *
 */
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

	@Synchronized
	@Nullable
	@Override
	public Ingredient convert(IngredientCommand source) {
		
		if (source == null) {
			return null;
		}
		
		Ingredient ingredient = new Ingredient();
		ingredient.setId(source.getId());
		ingredient.setDescription(source.getDescription());
		ingredient.setAmount(source.getAmount());
		// TODO: uncomment this line once uomConverter is completed
		//ingredient.setUom(uomConverter.convert(source.getUnitOfMeasure()));
		
		return ingredient;
	}

}
