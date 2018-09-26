package conflictos;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

class Tests {

	@Test
	void test() {
		//assertEquals(-135, Math.toDegrees(Math.atan2(-1,-1)));
		assertEquals(0.0, 0.0%45.0);
		assertEquals(0.0, 90.0%45.0);
		assertEquals(0.0, 135.0%45.0);
		assertEquals(0.0, 180.0%45.0);
		assertEquals(0.0, 225.0%45.0);
		assertEquals(0.0, 270.0%45.0);
		assertEquals(0.0, 315.0%45.0);
		assertEquals(0.0, 360.0%45.0);
		
		System.out.println(Math.toDegrees(Math.atan2(0,1)));
	}

}
