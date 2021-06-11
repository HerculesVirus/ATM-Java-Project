package Loginpkg;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class DepositeUserTest {

	@Test
	public void testGet_connection() {
		DepositeUser b = new DepositeUser();
		assertEquals(b.get_connection(),true);
	}


	@Test
	public void testUser_cash() throws SQLException {
		DepositeUser b = new DepositeUser();
		assertNotSame(b.user_cash("1000"),"100");
	}

	@Test
	public void testUpdate_user_cash() throws SQLException {
		DepositeUser b = new DepositeUser();
		assertEquals(b.update_user_cash("1000", 10, "1000"), true);
	}

}
