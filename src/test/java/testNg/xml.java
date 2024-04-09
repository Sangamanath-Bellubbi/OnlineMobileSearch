package testNg;

import org.testng.annotations.Test;

public class xml {
    @Test(priority=1)
	void s()
	{
		System.out.println("Sangam");
	}
    @Test(priority=2)
	void a() {
		System.out.println("A.......i");
	}
}
