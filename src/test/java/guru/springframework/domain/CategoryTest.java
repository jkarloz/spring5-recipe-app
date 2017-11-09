package guru.springframework.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Juan Carlos - 2017/11/09
 *
 */
public class CategoryTest {
	
	Category category;
	
	@Before
	public void setUp() {
		category = new Category();
	}

	/**
	 * Test method for {@link guru.springframework.domain.Category#getId()}.
	 */
	@Test
	public void testGetId() {
		Long idValue = 4L;
		category.setId(idValue);
		assertEquals(idValue, category.getId());
	}

	/**
	 * Test method for {@link guru.springframework.domain.Category#getDescription()}.
	 */
	@Test
	public void testGetDescription() {
	}

	/**
	 * Test method for {@link guru.springframework.domain.Category#getRecipes()}.
	 */
	@Test
	public void testGetRecipes() {
	}

}
