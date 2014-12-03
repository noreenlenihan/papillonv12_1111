/**
 * 
 */
package testing;
// This class tests the Datacenters class
import static org.junit.Assert.assertEquals;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import resource.DataCenters;

public class TestDatacenters {

	/**
	 * Test method for {@link resource.DataCenters#DataCenters()}.
	 */
	DataCenters tester; 
	
	@Before
		 public void setUp() {
	
		 tester = new DataCenters();
		 
		 }
	@After
	
	 public void tearDown() {
		
		 tester = null;
		 }
	

	/**
	Test method for {@link resource.DataCenters#getURL()}.
	 */
	@Test
	public void testGetURL() {
		String testUrl = "datacenters/";
		assertEquals(testUrl, tester.getURL().toString());
		}




}
