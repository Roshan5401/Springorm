package org.antwalk.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.antwalk.orm.dao.StudentDao;
import org.antwalk.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	StudentDao studentDao= context.getBean("studentDao",StudentDao.class);
	/*
	 * Student student= new Student(235,"fazil Tarry","Anantnag"); int r =
	 * studentDao.insert(student); System.out.println("insert done"+ r);
	 * studentDao.deleteStudent(234); System.out.println("delete done");
	 */
	
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	boolean go=true;
	while(true) {
	System.out.println("PRESS 1 for add new Student");
	System.out.println("PRESS 2 for display all students");
	System.out.println("PRESS 3 for get details of single student");
	System.out.println("PRESS 4 for delete students");
	System.out.println("PRESS 5 for update student");
	System.out.println("PRESS 6 for exit");
	
	try {
		int input= Integer.parseInt(br.readLine());
		
		switch (input) {
		case 1:
			//add a new student
			Student st=new Student(1,"Roshan","kolkata");
			StudentDao studentdao;
			int r=studentDao.insert(st);
			System.out.println(r);
			break;
			
		case 2:
			//display all student
			List<Student> lis=studentDao.getAllSudents();
			for(Student l:lis)
			{
				System.out.println(l);
			}
			break;
			
		case 3:
			//get single student data
			st=studentDao.getStudent(1);
			System.out.println(st);
			break;
			
		case 4:
			//delete student
			studentDao.deleteStudent(1);
			break;
		case 5:
			//update student
			studentDao.updateStudent(new Student(1,"Raj","bihar"));
			break;
		case 6:
			//exit
			go=false;
			break;
		default:
			break;
		}
	}
	catch(Exception e) {
		System.out.println("Invalid input try with another one ");
		System.out.println(e.getMessage());
	}
	}
	//System.out.println("ThankYou for using my application");
}
}
