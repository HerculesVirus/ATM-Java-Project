package Loginpkg;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class Manager_FunctionsTest {

	@Test
	public void testGet_connection() throws SQLException {
		Manager_Functions b = new Manager_Functions();
		assertEquals(true,b.get_connection());
	}

	@Test
	public void testDelete_emp() throws SQLException {
		Manager_Functions b = new Manager_Functions();
		assertEquals(b.delete_emp("huzaifa"),true);	
		fail("Not yet implemented");
	}

	@Test
	public void testResult_emp() throws SQLException {
		Manager_Functions b = new Manager_Functions();
		assertNotNull(b.result_emp());	
		fail("Not yet implemented");
	}

	@Test
	public void testResult_loan() throws SQLException {
		Manager_Functions b = new Manager_Functions();
		assertNotNull(b.result_loan());
		fail("Not yet implemented");
	}

	@Test
	public void testResult_user() throws SQLException {
		Manager_Functions b = new Manager_Functions();
		assertNotNull(b.result_user());
		fail("Not yet implemented");
	}

	@Test
	public void testWhere_emp_id() throws SQLException {
		Manager_Functions b = new Manager_Functions();
		assertEquals(b.where_emp_id("huzaifa"),true);
		fail("Not yet implemented");
	}

	@Test
	public void testInsert_into_database() throws SQLException {
		Manager_Functions b = new Manager_Functions();
		assertEquals(b.insert_into_database("huzaifa","huzaifa","huzaifa","huzaifa","huzaifa"),true);
		fail("Not yet implemented");
	}

	@Test
	public void testInsert_user_value() throws SQLException {
		Manager_Functions b = new Manager_Functions();
		assertEquals(b.insert_user_value("huzaifa","huzaifa","huzaifa","huzaifa","huzaifa"),true);
		fail("Not yet implemented");
	}

	@Test
	public void testWhere_user_id() throws SQLException {
		Manager_Functions b = new Manager_Functions();
		assertEquals(b.where_user_id("huzaifa"),true);	
		fail("Not yet implemented");
	}

	@Test
	public void testUser_cash() throws SQLException {
		Manager_Functions b = new Manager_Functions();
		assertEquals(b.user_cash("huzaifa"),true);	
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate_user_cash() throws SQLException {
		Manager_Functions b = new Manager_Functions();
		assertEquals(b.update_user_cash("huzaifa",1),true);	
		fail("Not yet implemented");
	}

	@Test
	public void testWhere_loan_id() throws SQLException {
		Manager_Functions b = new Manager_Functions();
		assertEquals(b.where_loan_id("huzaifa"),true);
		fail("Not yet implemented");
	}

}
