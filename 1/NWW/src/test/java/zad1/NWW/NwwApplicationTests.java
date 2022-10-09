package zad1.NWW;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NwwApplicationTests {

	NwwApplication nwwApplication;

	@BeforeEach
	void setUp() {
		nwwApplication = new NwwApplication();
	}

	@AfterEach
	void tearDown() {
		nwwApplication = null;
	}

	@Test
	public void testNwwApplication1() {
		int result = NwwApplication.nww(2,4);
		assertEquals(4, result);
		System.out.println("Test1");
	}

	@Test
	public void testNwwApplication2() {
		int result = NwwApplication.nww(4,2);
		assertEquals(4, result);
		System.out.println("Test2");
	}

	@Test
	public void testNwwApplication3() {
		assertThrows(ArithmeticException.class, ()-> NwwApplication.nww(0,9));
		System.out.println("Test3");
	}

	@Test
	public void testNwwApplication4() {
		assertThrows(ArithmeticException.class, ()-> NwwApplication.nww(12,0));
		System.out.println("Test4");
	}

	@Test
	public void testNwwApplication5() {
		int result = NwwApplication.nww(-4,16);
		assertEquals(16, result);
		System.out.println("Test5");
	}

	@Test
	public void testNwwApplication6() {
		int result = NwwApplication.nww(16,-4);
		assertEquals(16, result);
		System.out.println("Test6");
	}

	@Test
	public void testNwwApplication7() {
		assertThrows(ArithmeticException.class, ()-> NwwApplication.nww(0,0));
		System.out.println("Test7");
	}

	@Test
	public void testNwwApplication8() {
		String result = NwwApplication.animals(1);
		assertEquals("Miau!!", result);
		System.out.println("Test8");
	}

	@Test
	public void testNwwApplication9() {
		assertThrows(IllegalArgumentException.class, ()-> NwwApplication.animals(-3));
		System.out.println("Test9");
	}

	@Test
	public void testNwwApplication10() {
		String result = NwwApplication.animals(3);
		assertNotEquals("Ptak", result);
		System.out.println("Test10");
	}

}

