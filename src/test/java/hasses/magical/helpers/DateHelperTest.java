package hasses.magical.helpers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateHelperTest {

	@Test
	void test() {
		long floor = DateHelper.millisecondToFloorMin(60000);		
		assertTrue(floor==1);
		floor = DateHelper.millisecondToFloorMin(59999);
		assertTrue(floor==0);
		floor = DateHelper.millisecondToFloorMin(60001);		
		assertTrue(floor==1);
		floor = DateHelper.millisecondToFloorMin(120000);		
		assertTrue(floor==2);
		floor = DateHelper.millisecondToFloorMin(119999);		
		assertTrue(floor==1);
	}

}
