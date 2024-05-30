package com.vmb.enterprise.schoolTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Student
{
	String name;
	int roll_no;
	int sub1,sub2;
	int total;
	float per;
	String grade;
	
	public void getdata() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println ("Enter Name of Student");
		name = br.readLine();
		System.out.println ("Enter Roll No. of Student");
		roll_no = Integer.parseInt(br.readLine());
		System.out.println ("Enter marks out of 100 of 1st subject");
		sub1 = Integer.parseInt(br.readLine());
		System.out.println ("Enter marks out of 100 of 2nd subject");
		sub2 = Integer.parseInt(br.readLine());
	}
	void show()
	{
		total=sub1+sub2;
		per=(total*100)/200;
		
		if(per>=91 && per<=100){
			grade="A";
		}
		if(per>=81 && per<=90){
			grade="B";
		}
		if(per>=71 && per<=80){
			grade="C";
		}
		if(per>=61 && per<=70){
			grade="D";
		}
		if(per>=51 && per<=60){
			grade="E";
		}
		if(per>=41 && per<=50){
			grade="F";
		}
		System.out.println ("Roll No. = "+roll_no);
		System.out.println ("Name = "+name);
		System.out.println ("Marks of 1st Subject = "+sub1);
		System.out.println ("Marks of 2nd Subject = "+sub2);
		System.out.println ("Total Marks = "+total);
		System.out.println ("Percentage = "+per+"%");
		System.out.println ("Grade = "+grade);
	}
}
