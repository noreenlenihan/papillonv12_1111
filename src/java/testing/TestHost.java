package testing;
// this is the junit test for the Host class
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import resource.Host;
public class TestHost {

	String trackerId;
	Host hosttester;

	@Before
	public void setUp() throws Exception {
	trackerId = "dc1fl1rk1ht1";
		hosttester = new Host(1, 1, 1, 1);

	}

	@After
	public void tearDown() throws Exception {
		
		hosttester = null;
	}

	@Test
	public void testHost() {
	    try {
		      new Host(1,1,1,1);
		      new Host (0, 0, 0, 0);

		    } catch (Exception e) {
		      fail(e.getMessage());
		    }
		}
	

	
	

	
	@Test
	public void testGetPower() {
		assertNotNull(hosttester.getPower(trackerId));
	}

	@Test
	public void testGetHostId() {
		hosttester.setHostId(45);
		assertEquals(45, hosttester.getHostId());
	}

	@Test
	public void testSetHostId() {
		hosttester.setHostId(45);
		assertEquals(45, hosttester.getHostId());
	}

	@Test
	public void testGetModelGroupId() {
		hosttester.setModelGroupId(2);
		assertEquals(2, hosttester.getModelGroupId());
	}

	@Test
	public void testSetModelGroupId() {
		hosttester.setModelGroupId(2);
	assertEquals(2, hosttester.getModelGroupId());
	}

	@Test
	public void testGetName() {
		hosttester.setName("Mary");
		assertEquals("Mary", hosttester.getName());
	}

	@Test
	public void testSetName() {
		hosttester.setName("Mary");
		assertEquals("Mary", hosttester.getName());
	}

	@Test
	public void testGetDescription() {
		hosttester.setDescription("a very nice server");
		assertEquals("a very nice server", hosttester.getDescription());
	}

	@Test
	public void testSetDescription() {
		hosttester.setDescription("a very nice server");
		assertEquals("a very nice server", hosttester.getDescription());
	}

	@Test
	public void testGetHostType() {
		hosttester.setHostType("CLIENT");
		assertEquals("CLIENT",hosttester.getHostType());
	}

	@Test
	public void testSetHostType() {
		hosttester.setHostType("CLIENT");
		assertEquals("CLIENT",hosttester.getHostType());
	}

	@Test
	public void testGetIpAddress() {
		String IpAddress = "127.0.0.1";
		hosttester.setIpAddress(IpAddress);
		assertEquals(IpAddress, hosttester.getIpAddress());
	}

	@Test
	public void testSetIpAddress() {
		String IpAddress = "127.0.0.1";
		hosttester.setIpAddress(IpAddress);
		assertEquals(IpAddress, hosttester.getIpAddress());
	}

	@Test
	public void testGetTrackerId() {
			hosttester.setTrackerId();
		assertNotNull(hosttester.getTrackerId());
	}

	@Test
	public void testSetTrackerId() {
			hosttester.setTrackerId();
		assertNotNull(hosttester.getTrackerId());
		
	}

}
