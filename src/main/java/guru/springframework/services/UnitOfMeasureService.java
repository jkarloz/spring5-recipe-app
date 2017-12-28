package guru.springframework.services;

import java.util.Set;

import guru.springframework.command.UnitOfMeasureCommand;

/**
 * @author Juan Carlos - 2017/12/21
 *
 */
public interface UnitOfMeasureService {
	Set<UnitOfMeasureCommand> listAllUoms();
}
