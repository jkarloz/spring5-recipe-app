package guru.springframework.command;

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
public class UnitOfMeasureCommand {
	private Long id;
	private String description;
}
