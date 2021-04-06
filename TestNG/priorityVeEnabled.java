package Testng;

import java.util.Random;




import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class priorityVeEnabled {

//priority diyerek verdiðimz sayýnýn büyüklðüne göre methodlarý sýraya diziyor. 	
//enabled=false kullanarak o methodu görmezden geldik
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("sistem açýlýyor");
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
		public void Test2(){            //priority tanýmlamadýðým için bu method 0 oluyor ve en baþa geçiyor.
			String a="Haluk";
			String b="Haluk";
			Assert.assertEquals(b,a);
			System.out.println("Test2 baþarýlý");
		}
		
@AfterClass
public void AfterClass(){
	System.out.println("sistem kapatýlýyor");
}


}
