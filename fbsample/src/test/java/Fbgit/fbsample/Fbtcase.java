package Fbgit.fbsample;

	
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Test;

public class Fbtcase {



			public static WebDriver driver;

			@BeforeSuite(groups = "Smoke")
			public static WebDriver setup_Browser() {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				// cookies delete
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.get("https://www.facebook.com/");
				return driver;
			}
		  @Test(priority = 1, groups = "Regression")
			public static void Verify_Url() {
				// Actual url
				String my_url = driver.getCurrentUrl();
				System.out.println("page title is " + my_url);

				// expected url
				String expected_url = "https://www.facebook.com/";
				Assert.assertEquals(my_url, expected_url);
				System.out.println("**************************");

				System.out.println("Test Case One with Thread Id:- "
						+ Thread.currentThread().getId());
			}

		  @Test(priority = 2, groups = "Regression")
			public void verifyApplicationTitle() {
				// Actual title
				String my_title = driver.getTitle();
				System.out.println("page title is " + my_title);
				System.out.println("..................");

				// expected title
				String expected_title = "Facebook – log in or sign up";
				Assert.assertEquals(my_title, expected_title);
				System.out.println("************************");
				System.out.println("Test Case two with Thread Id:- "
						+ Thread.currentThread().getId());
		  }
		 /* 
		  @Test(priority = 3, groups = "Regression")
		 	public void verify_Title() {
		 		String stitle = driver.findElement(By.xpath(".//i[contains(@class='fb_logo img sp_e_sJSkd7GFN sx_28855e')])")).getText();
		 		String exp = "fb_logo img sp_9BdNWkW8OEw sx_716d90";
		 		Assert.assertEquals(stitle, exp);
		 		System.out.println("Application title verify " + stitle);
		 		System.out.println("**********************");
		 	}*/
		  
		   @Test(priority = 3, groups = "Regression")
			public void loginsesion() {
				driver.findElement(By.xpath("//span[contains(text(),'Create an account')]"));
				System.out.println("Create an account");
				System.out.println("***********************");

			}
		  
		 
		   
		   @Test(priority = 4, groups = "Regression")
			public void Check_Type_Firstname() {
				String str = driver.findElement(By.xpath("//input[@id='u_0_j']")).getAttribute("type");
				String exp = "text";
				Assert.assertEquals(str, exp);
				System.out.println("Type Text-verified");
				System.out.println("*******************");
			}
		   @Test(priority = 5, groups = "Regression")
		  	public void Check_Type_surname() {
		  		String str = driver.findElement(By.xpath("//input[@id='u_0_l']")).getAttribute("aria-label");
		  		String exp = "Surname";
		  		Assert.assertEquals(str, exp);
		  		System.out.println("aria lable surname-verified");
		  		System.out.println("*******************");
		  	}
		   
		   @Test(priority = 6, groups = "Regression")
			public void check_Button_color() {
				WebElement signup = driver.findElement(By.xpath("//button[contains(@type,'submit')] "));
				System.out.println("befor mouse over button color is "+ signup.getCssValue("background-color"));
				Actions act = new Actions(driver);
				act.moveToElement(signup).build().perform();
				System.out.println("after mouse over button color "+ signup.getCssValue("color"));
				System.out.println("*******************");

			}

		  @Test(priority = 7, groups = "Regression")
			public void blank_Firstname_surname() {
				WebElement stract = driver.findElement(By.name("firstname"));
				stract.sendKeys("");
				String strexp = "sa";
				Assert.assertNotEquals(stract, strexp);
				driver.findElement(By.xpath(".//*[@id='u_0_l']")).click();
				String sname = driver.findElement(By.xpath("//input[@id='u_0_l']")).getText();
				System.out.println(sname);
				/*driver.findElement(By.xpath(".//*[@id='u_0_j']")).click();
				String fname=driver.findElement(By.xpath("//input[@id='u_0_j']")).getText();*/
		  
		  }
		  @Test(priority = 8, groups = "Regression")
		      public void mob_or_email(){
			  WebElement mobnum=driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"));
			  mobnum.sendKeys("");
			  String mobexp="9405524856";
			  driver.findElement(By.xpath(".//*[@id='u_0_o']")).click();
				Assert.assertNotEquals(mobnum, mobexp);
			  System.out.println("mob field empty");
			  driver.findElement(By.xpath("//input[@id='u_0_v']")).click();
			  String pwd = driver.findElement(By.xpath("//input[@id='u_0_v']")).getText();
				System.out.println(pwd);
				

		  }
		       @Test(priority = 9, groups = "Regression")
		        
					public void signupclick() {
						driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
						System.out.println("Signupclick");
				     	System.out.println("*******************");
					}
				@Test(priority = 10, groups = "Resgression")
				public void validFirstname_surname() throws InterruptedException {
					driver.findElement(By.xpath("//input[@id='u_0_j']")).sendKeys("Diksha");
					driver.findElement(By.xpath("//input[@id='u_0_l']")).sendKeys("Patil");
					
							 
				
				}
				
			@Test(priority = 11, groups = "Resgression")
			public void invalidmob() throws InterruptedException{
				WebElement mob=driver.findElement(By.xpath("//input[@id='u_0_o']"));
				mob.sendKeys("94055");
				String mobexp=("9405524856");
				Assert.assertNotEquals(mob,mobexp);
				Thread.sleep(2000);
				mob.clear();
				
				System.out.println("Enter valid password");	
			}
			@Test(priority = 12, groups = "Resgression")
			public void valid_mobnum(){
				driver.findElement(By.xpath("//input[@id='u_0_o']")).sendKeys("9405524856");
				
				
			}
			@Test(priority = 13, groups = "Resgression")
			public void invalid_password() throws InterruptedException{
				WebElement pwd=driver.findElement(By.xpath("//input[@id='u_0_v']"));
				/*driver.findElement(By.xpath("//input[contains(@class='inputtext _58mg _5dba _2ph-']"));[@id='u_0_v'*/
				pwd.sendKeys("1234");
				String pwdexp=("9405524856");
				Assert.assertNotEquals(pwd,pwdexp);
				Thread.sleep(1500);
				pwd.clear();
				System.out.println("Invalid password");
				driver.findElement(By.xpath("//input[@id='u_0_v']")).sendKeys("varsha123456&!");

		       }
			@Test(priority = 14, groups = "Resgression")
			public void birthdate(){
				WebElement day=driver.findElement(By.id("day"));
				Select dayselect=new Select(day);
				dayselect.selectByVisibleText("27");
				
				WebElement month=driver.findElement(By.id("month"));
				Select monthselect=new Select(month);
				monthselect.selectByIndex(7);
				
				WebElement year=driver.findElement(By.id("year"));
				Select yearselect=new Select(year);
				yearselect.selectByValue("1991");
				
			}
			@Test(priority = 15, groups = "Resgression")
			public void selectfemale(){
				
				WebElement female=driver.findElement(By.name("sex"));
				female.click();
				
			}
			@Test(priority = 16, groups = "Resgression")
			public void sign_up(){
				WebElement button=driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
				button.click();
			}
		}

		  

		 



