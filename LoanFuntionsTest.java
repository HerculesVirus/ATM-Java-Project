package Loginpkg;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.sql.SQLException;

import org.junit.Test;

public class LoanFuntionsTest {

	@Test
	public void testGet_connection() {
		LoanFuntions b = new LoanFuntions();
		assertEquals(true,b.get_connection());
	}

	@Test
	public void testResult_loan() throws SQLException {
		LoanFuntions b = new LoanFuntions();
		assertNotNull(b.result_loan());

		fail("Not yet implemented");
	}

	@Test
	public void testLoan_database() {
		LoanFuntions b = new LoanFuntions();
		assertNotSame(b.loan_database("0706","huzaifa", "hehe", "100"),true);
		fail("Not yet implemented");
	}

	@Test
	public void testLoan_function() {
		LoanFuntions b = new LoanFuntions();
		assertNotNull(b.loan_function("0706","huzaifa", "hehe", "100"));
	}

}
