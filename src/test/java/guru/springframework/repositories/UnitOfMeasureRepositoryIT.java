package guru.springframework.repositories;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.UnitOfMeasure;

/**
 * @author Juan Carlos - 2017/11/09
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {
	
	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link guru.springframework.repositories.UnitOfMeasureRepository#findByDescription(java.lang.String)}.
	 */
	@Test
	@DirtiesContext //In case we want to reset the context so the next unit test won be affected by the changes of this one
	public void testFindByDescription() throws Exception {
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
		assertEquals("Teaspoon", uomOptional.get().getDescription());
	}
	
	@Test
	public void testFindByDescriptionCup() throws Exception {
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
		assertEquals("Cup", uomOptional.get().getDescription());
	}

}
