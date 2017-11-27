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
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {
	
    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomConverter = uomConverter;
    }

	@Synchronized
	@Nullable
	@Override
	public IngredientCommand convert(Ingredient source) {
		
		if(source == null) {
			return null;
		}
		
		IngredientCommand ingredientCommand = new IngredientCommand(); 
		ingredientCommand.setId(source.getId());
		ingredientCommand.setDescription(source.getDescription());
		ingredientCommand.setAmount(source.getAmount());
		ingredientCommand.setUnitOfMeasure(uomConverter.convert(source.getUom()));
		return ingredientCommand;
	}

}
