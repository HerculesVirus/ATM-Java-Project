package Loginpkg;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class WithdrawUserAccountTest {

	@Test
	public void testGet_connection() {
		WithdrawUserAccount b = new WithdrawUserAccount();
		assertEquals(b.get_connection(),true);
	}

	@Test
	public void testUser_cash() throws SQLException {
		WithdrawUserAccount b = new WithdrawUserAccount();
		assertEquals(b.user_cash("huzaifa"),true);	
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate_user_cash() throws SQLException {
		WithdrawUserAccount b = new WithdrawUserAccount();
		assertEquals(b.update_user_cash("huzaifa",10,"huzaifa"),true);

		fail("Not yet implemented");
	}

}
