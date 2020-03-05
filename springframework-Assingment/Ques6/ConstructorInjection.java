package com.tothenew.bootcamp.springframework.Ques6;

interface StudentDetails{
    public void show();
}
public class ConstructorInjection {
        StudentDetails studentDetails;
    public ConstructorInjection(StudentDetails stu) {
            studentDetails = stu;
        }
    public ConstructorInjection() {
            studentDetails = new Student();
        }
        public void showStudentDetails () {
            studentDetails.show();
        }
}
class Student implements StudentDetails{
    private int id=4040;
    private String name = "Harsh Yadav";

    @Override
    public void show() {
        System.out.println("Student id: "+id);
        System.out.println("Student Name:"+name);
    }
}
class ConstructorInjectionDriver{
    public static void main(String[] args) {
        ConstructorInjection constructorInjection = new ConstructorInjection();
        constructorInjection.showStudentDetails();
    }
}
