package Loginpkg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;


class bankingFunctionsTest {
	@Test
	void testConnect() {
		bankingFunctions b=new bankingFunctions();
		assertEquals(true,b.connect());
	}


	@Test
	void testLoginCheck()  {
		bankingFunctions b=new bankingFunctions();
		try {
			 String output = b.loginCheck("huzaifa","hamid");
			assertNotSame("wrong", output);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
