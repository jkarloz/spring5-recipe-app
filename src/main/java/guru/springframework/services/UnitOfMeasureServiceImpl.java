package guru.springframework.services;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import guru.springframework.command.UnitOfMeasureCommand;
import guru.springframework.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.repositories.UnitOfMeasureRepository;

/**
 * @author Juan Carlos - 2017/12/21
 *
 */
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {
	
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

	public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,
			UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
	}

	@Override
	public Set<UnitOfMeasureCommand> listAllUoms() {
		return StreamSupport.stream(unitOfMeasureRepository.findAll()
				.spliterator(), false)
				.map(unitOfMeasureToUnitOfMeasureCommand::convert)
				.collect(Collectors.toSet());
	}

}