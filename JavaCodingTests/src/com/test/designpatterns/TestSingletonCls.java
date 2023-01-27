package com.test.designpatterns;

public class TestSingletonCls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GradesSingletonCls gradesObj1 = GradesSingletonCls.getInstance();
		GradesSingletonCls gradesObj2 = GradesSingletonCls.getInstance();
		
		System.out.println("HashCode: "+ gradesObj1.hashCode());
		System.out.println("HashCode: "+ gradesObj2.hashCode());
		
		gradesObj1.printGrade(400, 1000);
		gradesObj2.printGrade(500, 1000);
	}

}
