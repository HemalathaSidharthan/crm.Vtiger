package com.crm.Vtiger.commandLineExecution;

import org.testng.annotations.Test;

public class RunTimeParameterInEclipse { 
	@Test
	public void returnparameterValue() 
	{
System.out.println(System.getProperty("EmpName"));
System.out.println(System.getProperty("EmpId"));
System.out.println(System.getProperty("EmpDept"));
	}

}
