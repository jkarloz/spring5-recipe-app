package guru.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Juan Carlos - 2017/10/30
 *
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne //We don't implement cascade here, because, we dont want to remove a recipe when a recipe note is removed
	private Recipe recipe;
	
	@Lob
	private String recipeNotes;
	
}
