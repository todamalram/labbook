package com.cg.eis.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.cg.eis.bean.Employee;
import com.cg.eis.comaparator.InsuranceSchemeComparator;

import Exception.NotFoundException;

public class EmployeeServiceInterface implements EmployeeService
{
	HashMap<Integer,Employee> empList=new HashMap<>();
	
	
	public String addDetails(int key,Employee emp) throws NotFoundException
	{
		if(emp.getEmpId()==0||emp.getEmpName()==null||emp.getSalary()==0)
		{
			throw new NotFoundException("Insufficient Information");
		}
		else
		{
		 String designation=designationCheck(emp.getSalary());
		 emp.setDesignation(designation);
		 String insuranceScheme=applyInsuranceScheme(emp.getSalary());
		 emp.setInsuranceScheme(insuranceScheme);
		empList.put(key,emp);
		}
		return "Added Successfully";
	}
	public void deleteEmpDetails(int key) throws NotFoundException
	{
		Employee e=empList.get(key);
		if(e==null)
		{
			throw new NotFoundException("Key Not Found");
		}
		else
		{
		System.out.println("Deleted data of:"+e.getEmpName());
		empList.remove(key);
		}
	}
	@Override
	public void sortByInsuranceScheme(String insuranceScheme) 
	{
		Comparator<Entry<Integer, Employee>> com=new InsuranceSchemeComparator();
		Set<Map.Entry<Integer,Employee>> set=empList.entrySet();
		 List<Entry<Integer, Employee>> list=new ArrayList<Entry<Integer, Employee>>(set);
		 
		 Collections.sort(list,com);
		 LinkedHashMap<Integer, Employee> sortedByScheme=new LinkedHashMap<Integer,Employee>(list.size());
		 for(Entry<Integer, Employee> entry:list)
		 {
			 if(entry.getValue().getInsuranceScheme().equals(insuranceScheme))
			 sortedByScheme.put(entry.getKey(),entry.getValue());
		 }
		 System.out.println("sorted:-"+sortedByScheme);
	}
	 public void printDetails()
	 {
		 System.out.println(empList.toString());
	 }
	private String applyInsuranceScheme(double salary) {
		 
		String ans="";
		 if(salary>5000 && salary<20000)
		 {
			 ans="Scheme C";
		 }
		 else if(salary>=20000 && salary<=40000)
		 {
			 ans="Scheme B";
		 }
		 else if(salary>=40000)
		 {
			 ans="Scheme A";
		 }
		 else if(salary<5000)
		 {
			 ans="No Scheme";
		 }
		 else
		 {
			 ans="Not Found";
		 }
		 return ans;
	}
	private String designationCheck(double salary) 
	{
		 String ans="";
		 if(salary>5000 && salary<20000)
		 {
			 ans="System Associate";
		 }
		 else if(salary>=20000 && salary<=40000)
		 {
			 ans="Programmer";
		 }
		 else if(salary>=40000)
		 {
			 ans="Manager";
		 }
		 else if(salary<5000)
		 {
			 ans="Clerk";
		 }
		 else
		 {
			 ans="Not Found";
		 }
		 return ans;
	}
}
