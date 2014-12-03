package testing;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import resource.DataCenter;

public class TestDataCenter {
	
	static DataCenter tester1;

	@BeforeClass
	public static void setUp() throws Exception {
		tester1 = new DataCenter(1);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tester1 = null;
	}

	@Test
	public void testSetFloors() {
		//tested fully in integration testing
	}

	@Test
	public void testGetId() {
		tester1.setId(1);
		assertEquals(1, tester1.getId());
	}

	@Test
	public void testSetId() {
		tester1.setId(1);
		assertEquals(1, tester1.getId());
	}

	@Test
	public void testGetName() {
		tester1.setName("Teddy");
		assertEquals("Teddy", tester1.getName());
	}

	@Test
	public void testSetName() {
		tester1.setName("Teddy");
		assertEquals("Teddy", tester1.getName());
	}

	@Test
	public void testGetDescription() {
		tester1.setDescription("TEST");
		assertEquals("TEST", tester1.getDescription());
	}

	@Test
	public void testSetDescription() {
		tester1.setDescription("TEST");
		assertEquals("TEST", tester1.getDescription());
	}

	@Test
	public void testGetLatitude() {
		tester1.setLatitude(12.156);
		double expected = 12.156;
		assertEquals((Object)expected, (Object)tester1.getLatitude());
	}

	@Test
	public void testSetLatitude() {
		tester1.setLatitude(12.156);
		double expected = 12.156;
		assertEquals((Object)expected, (Object)tester1.getLatitude());
	}

	@Test
	public void testGetLongitude() {
		tester1.setLongitude(12.156);
		double expected = 12.156;
		assertEquals((Object)expected, (Object)tester1.getLongitude());
	}

	@Test
	public void testSetLongitude() {
		tester1.setLongitude(12.156);
		double expected = 12.156;
		assertEquals((Object)expected, (Object)tester1.getLongitude());
	}


}
