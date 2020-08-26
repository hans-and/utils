package hasses.magical.helpers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidationHelperTest {

	@Test
	void test() {
		
		assertTrue(ValidationHelper.isValidEmail("hans.andersson@gmail.com"));
		assertTrue(ValidationHelper.isValidEmail("hans.andersson@tco.se"));
		assertFalse(ValidationHelper.isValidEmail(null));
		assertFalse(ValidationHelper.isValidEmail(""));
		assertFalse(ValidationHelper.isValidEmail("hans.andersson@"));
	}
	
	
	

}
