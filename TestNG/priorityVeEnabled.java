package Testng;

import java.util.Random;




import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class priorityVeEnabled {

//priority diyerek verdi�imz say�n�n b�y�kl��ne g�re methodlar� s�raya diziyor. 	
//enabled=false kullanarak o methodu g�rmezden geldik
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("sistem a��l�yor");
	}
	
	    @Test(priority=1111)
		public void a(){
			System.out.println("a");
		}
		@Test(priority=21)
		public void b(){
			System.out.println("b");
			
		}
		@Test(priority=32,enabled=false)
		public void c(){
			System.out.println("c");
			
		}
		@Test(priority=322)
		public void d(){
			System.out.println("d");
			
		}
		
		@Test(priority=111111)
		public void Test1(){
			
			Random random=new Random();
			int a=random.nextInt(10);
			int b=random.nextInt(10);
			int c=a+b;
			System.out.println("c:"+c);
			Assert.assertTrue(c<12);
		}
	
		@Test
		public void Test2(){            //priority tan�mlamad���m i�in bu method 0 oluyor ve en ba�a ge�iyor.
			String a="Haluk";
			String b="Haluk";
			Assert.assertEquals(b,a);
			System.out.println("Test2 ba�ar�l�");
		}
		
@AfterClass
public void AfterClass(){
	System.out.println("sistem kapat�l�yor");
}


}
