package Loginpkg;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.sql.SQLException;

import org.junit.Test;

public class Donation_FunctionsTest {

	@Test
	public void testGet_connection() {
		 Donation_Functions b = new  Donation_Functions();
		 assertEquals(b.get_connection(),true);
	}

	@Test
	public void testgetIntId() throws SQLException {
		Donation_Functions b = new Donation_Functions();
		assertNotSame(b.getIntId("Huzaifa"),"10");
		fail("Not yet implemented");
	}

	@Test
	public void testAccountDonation() throws SQLException {
		Donation_Functions b = new Donation_Functions();
		assertNotSame(b.accountDonation("0706","huzaifa", "hehe", "100"),true);
		fail("Not yet implemented");
	}

	@Test
	public void testUnknownDonation() throws SQLException {
		Donation_Functions b = new Donation_Functions();
		assertEquals(b.unknownDonation("0706","huzaifa", "hehe", "100"),true);
		fail("Not yet implemented");
	}

	@Test
	public void testDonation() {
		
		Donation_Functions b = new Donation_Functions();
		assertEquals(b.donation("0706","huzaifa", "hehe", "100"),true);
		fail("Not yet implemented");
	}

}
