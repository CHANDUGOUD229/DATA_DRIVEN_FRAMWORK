package driver$cripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commanFunctionLibrary.ERP_Functions;
import exelutil.ExcelFileUtil;

public class TestNg 
{
	 ERP_Functions erp=new ERP_Functions();
	@BeforeMethod
	 public void start()
	 {
		 System.out.println("Starting Execution ");
		 
	 }
	
	 
	 
  @Test
  public void f() throws Exception 
  {
	  ExcelFileUtil ex=new ExcelFileUtil();
	  int rowcont= ex.rowCount("Supplier");
	  
	  for(int i=1;i<=rowcont;i++)
		 {
			String sname=ex.getData("Supplier", i, 0);
			String address=ex.getData("Supplier", i, 1);
			String city=ex.getData("Supplier", i, 2);
			String country=ex.getData("Supplier", i, 3);
			String cperson=ex.getData("Supplier", i, 4);
			String pnumber=ex.getData("Supplier", i, 5);
			String mail=ex.getData("Supplier", i, 6);
			String mnumber=ex.getData("Supplier", i, 7);
			String note=ex.getData("Supplier", i, 8);
			
			erp.lauchApp("http://webapp.qedge.com/login.php");
			erp.logine("admin", "master");
		 String res=erp.supplier(sname, address, city, country, cperson, pnumber, mail, mnumber, note);
		ex.setData("Supplier", i, 9,res);
	    erp.closebrw();
			 
		}
}
  @AfterMethod
  public void end()
  {
	  System.out.println("Ended");
  }
	  
	  
	 
}
