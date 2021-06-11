package Loginpkg;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class Transfer_FunctionTest {

	@Test
	public void testGet_connection() {
		Transfer_Function b = new Transfer_Function();
		equals(b.get_connection());
	}

	@Test
	public void testUser_cash() throws SQLException {
		Transfer_Function b = new Transfer_Function();
		assertEquals(b.user_cash("1000"),true);
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate_user_cash() throws SQLException {
		Transfer_Function b = new Transfer_Function();
		assertEquals(b.update_user_cash("huzaifa",1),true);	
		fail("Not yet implemented");
	}

	@Test
	public void testTransfer() {
		Transfer_Function b = new Transfer_Function();
		assertEquals(b.transfer("1000","1000","1000"),true);
		fail("Not yet implemented");
	}

}
