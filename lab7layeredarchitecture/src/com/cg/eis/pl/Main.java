package com.cg.eis.pl;
import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeServiceInterface;

import Exception.NotFoundException;

public class Main 
{
	public static void main(String[] args) 
	{ 
		 EmployeeServiceInterface empService=new EmployeeServiceInterface();
		 Employee emp1=new Employee(10,"Ram",25000,null,null);
		 Employee emp2=new Employee(5,"Prashant",30000,null,null);
		 Employee emp3=new Employee(15,"Krutika",20000,null,null);
		 Employee emp4=new Employee(12,"Akash",42000,null,null);
		 try {
			empService.addDetails(1, emp1);
			empService.addDetails(2, emp2);
			empService.addDetails(3, emp3);
			empService.addDetails(4, emp4);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		empService.printDetails();
		 /*try {
			empService.deleteEmpDetails(4);
		} catch (NotFoundException e) {
			 
			e.printStackTrace();
		}*/
		 //empService.sortByInsuranceScheme("Scheme A");
	}
}
