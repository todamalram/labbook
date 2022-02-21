package com.cg.eis.comaparator;

import java.util.Comparator;
import java.util.Set;
import java.util.Map.Entry;

import com.cg.eis.bean.Employee;

public class InsuranceSchemeComparator  implements Comparator<Entry<Integer, Employee>> {

	@Override
	public int compare(Entry<Integer, Employee> o1, Entry<Integer, Employee> o2) 
	{
		String v1=o1.getValue().getInsuranceScheme();
		String v2=o2.getValue().getInsuranceScheme();
		return v1.compareTo(v2);
	}
}
