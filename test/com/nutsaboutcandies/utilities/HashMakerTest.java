package com.nutsaboutcandies.utilities;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashMakerTest {

	@Test
	public void makeHashTest() {
		assertNotNull(HashMaker.makeHash(""));
		assertEquals(64, HashMaker.makeHash("123456").length());
	}

}
