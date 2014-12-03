package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import resource.Rack;

public class TestRack {
	
	Rack racktester;
	
	@Before
	public void setUp() throws Exception {
		racktester = new Rack(1, 1, 1);
	}

	@After
	public void tearDown() throws Exception {
		racktester = null;	
	}


	@Test
	public void testGethostdata() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHosts() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetHosts() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRackId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRackId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetXaxis() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetXaxis() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetYaxis() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetYaxis() {
		fail("Not yet implemented");
	}

}
