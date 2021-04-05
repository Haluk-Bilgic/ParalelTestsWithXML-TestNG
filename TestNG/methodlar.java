package Testng;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class methodlar {
	
	/*@BeforeSuite@BeforeTest@BeforeClass-@BeforeMethod-@Test--@AfterMethod-@AfterClass-@AfterTest-@AfterSuite
	sýra bu þekildedir.sýrasýyla yazmasak bile o bu sýraya göre dizer.
	
	*/
	 @BeforeClass
  public  void beforeClass(){ 
		 System.out.println("Sistem açýlýyor");  
  }
   
	 @BeforeMethod
	public void beforeMethod(){
    System.out.println("Before Method---------------------");	 
     }
	 
	 @Test
	 public void Test1(){
		 System.out.println("Test 1");
	 }
	
	 
	 @Test(groups="grup1")
	 public void Test2(){
		 System.out.println("Test 2");
	 }
	 
	 @Test(groups="grup1")
	 public void Test3(){
		 System.out.println("Test 3");
	 }
	 @Test
	 public void Test4(){
		 System.out.println("Test 4");
	 }
	 @AfterMethod
	 public void aftermethod(){
		 System.out.println("after method");
	 }
	 
	 @AfterClass
	 public void afterClass(){
		 System.out.println("Sistem Kapanýyor");
	 }
	 
	}


