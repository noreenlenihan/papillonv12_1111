package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import resource.DataCenters;

public class IntegrationTest {
	DataCenters dcTester;

	@Before
	public void setUp() throws Exception {
		dcTester = new DataCenters();
//		connect = new Connection();
	}

	@After
	public void tearDown() throws Exception {
		dcTester = null;
	}

	@Test
	public void testHost() {
		//have created a datacenters object which need to make API calls to work
		//this tests the database connection and object creation
		assertNotNull(dcTester.getDatacenters().get(0).getFloors().get(0).getRacks().get(0).getHosts().get(0));

	}
}
