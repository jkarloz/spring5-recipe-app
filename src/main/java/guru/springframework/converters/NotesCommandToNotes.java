package guru.springframework.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import guru.springframework.command.NotesCommand;
import guru.springframework.domain.Notes;
import lombok.Synchronized;

/**
 * @author Juan Carlos - 2017/11/24
 *
 */
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

	@Synchronized
	@Nullable
	@Override
	public Notes convert(NotesCommand source) {
		
		if(source == null) {
			return null;
		}
		
		Notes notes = new Notes();
		notes.setId(source.getId());
		notes.setRecipe(source.getRecipe());
		notes.setRecipeNotes(source.getRecipeNotes());
		
		return notes;
	}

}
