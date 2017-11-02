package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.UnitOfMeasure;

/**
 * @author Juan Carlos - 2017/11/01
 *
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

}
