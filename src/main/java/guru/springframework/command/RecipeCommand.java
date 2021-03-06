package guru.springframework.command;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import guru.springframework.enums.Difficulty;
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
public class RecipeCommand {
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 255)
	private String description;
	
	@Min(1)
	@Max(999)
	private Integer prepTime;
	
	@Min(1)
	@Max(999)
	private Integer cookTime;
	
	@Min(1)
	@Max(100)
	private Integer servings;
	private String source;
	
	@URL
	private String url;
	
	@NotBlank
	private String directions;
	private Byte[] image;
	private Difficulty difficulty;
	private NotesCommand notes;	
	private Set<IngredientCommand> ingredients = new HashSet<>();
	private Set<CategoryCommand> categories = new HashSet<>();
}
