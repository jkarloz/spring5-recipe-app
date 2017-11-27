package guru.springframework.command;

import guru.springframework.domain.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Juan Carlos - 2017/11/17
 *
 */

@Setter
@Getter
@NoArgsConstructor
public class NotesCommand {
	private Long id;
	private Recipe recipe;
	private String recipeNotes;
}
