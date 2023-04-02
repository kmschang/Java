/*
Kyle Schang
EECS 1510
03-30-2023

Started off by making the person class with a variable name. I made instances so that you could input the name into the class.
I then made the methods to set the name, get the name, reset the person, write the output and see if there is an overlap

Then I made the student class which extends the person class. This class has a new variable student number.
I made methods to set the number, get the number, reset the person, write an output and check or overlap with people.

Then I made the undergraduate class which extends student with the student level variable.
I made methods to set the level, get the level, reset the person, write an output and check or overlap with people.

Then I made the graduate class which also extends student with a student level variable as well.
I made methods to set the level, get the level, reset the person, write an output and check or overlap with people.

Then I made the employee class which extends person. This class has a new variable employee ID.
I made methods to set the ID, get the ID, reset the person, write the output, and check for overlap.

Then I amd teh Faculty class which extends employee class. This class has two new variables, department and title.
I made methods to set and get both of the new variables along with output, reset the person, anc check for overlapping.

Then I made the last class Staff which extends employee. This class only has one new variable pay grade.
I made methods to set pay grade, get pay grade, reset the person, write output, and check for overlap.

Then I made test cases to make sure all the printing was working, and it was passing all the variables correctly.

This is a test about hooks.

 */

public class SchangKyleProj2 {


    // main class meant for test cases
    public static void main(String[] args) {}


    // Top Person class which everything is based off
    static class Person
    {

        // making the name variable
        String name;

        // way to set the name the person class
        Person(String newName)
        {
            name = newName;
        }

        // setting the name with a method
        void setName(String newName)
        {
            this.name = newName;
        }

        // getting the name
        String getName()
        {
            return name;
        }

        // writing the output to print the name
        void writeOutput()
        {
            System.out.println("Name: " + name);
        }

        // making sure that no one has the same name
        boolean hasSameName(Person otherPerson)
        {
            return this.name.equalsIgnoreCase(otherPerson.name);
        }

    }

    // student class which extends person
    static class Student extends Person {

        // making the student number variable
        int studentNumber;

        // way to set the name and student number with the student number
        Student(String newName, int newStudentNumber) {
            super(newName);
            studentNumber = newStudentNumber;
        }

        // set student number
        void setStudentNumber(int newStudentNumber) {
            studentNumber = newStudentNumber;
        }

        // get student number
        int getStudentNumber() {
            return studentNumber;
        }

        // writing the output with name and student number
        void writeOutput() {
            System.out.println("Name: " + name);
            System.out.println("Student Number: " + studentNumber);
        }

        // resetting the people with a new name and student number
        void reset(String newName, int newStudentNumber) {
            super.setName(newName);
            studentNumber = newStudentNumber;
        }

        // making sure no one else has the same name and student number
        boolean equal(Student otherStudent) {
            return this.hasSameName(otherStudent) && (this.studentNumber == otherStudent.studentNumber);
        }


    }

    // undergraduate class which extends student
    static class Undergraduate extends Student {

        // new variable of level
        int level;

        // way to set the name. student number, and level from the class
        Undergraduate(String newName, int newStudentNumber, int newLevel) {
            super(newName, newStudentNumber);
            level = newLevel;
        }

        // set the level
        void setLevel(int newLevel) {
            level = newLevel;
        }

        // get the level
        int getLevel() {
            return level;
        }

        // write output with name, student number, and level
        void writeOutput() {
            super.writeOutput();
            System.out.println("level: " + level);
        }

        // checking for overlap
        boolean equal(Undergraduate otherUndergraduate) {
            return super.equal(otherUndergraduate) && (this.level == otherUndergraduate.level);
        }

        // resetting the name
        void reset(String newName, int newStudentNumber, int newLevel) {
            super.reset(newName, newStudentNumber);
            level = newLevel;
        }



    }

    // graduate class which extends student
    static class Graduate extends Student {

        // variable level
        int level;

        // setting the name, student number, and level with the class
        Graduate(String newName, int newStudentNumber, int newLevel) {
            super(newName, newStudentNumber);
            level = newLevel;
        }

        // set level
        void setLevel(int newLevel) {
            level = newLevel;
        }

        // get level
        int getLevel() {
            return level;
        }

        // write output with functions
        void writeOutput() {
            super.writeOutput();
            System.out.println("level: " + level);
        }

        // reset name, student number, and level
        void reset(String newName, int newStudentNumber, int newLevel) {
            super.reset(newName, newStudentNumber);
            level = newLevel;
        }

        // making sure there is not overlap
        boolean equal(Graduate otherGraduate) {
            return super.equal(otherGraduate) && (this.level == otherGraduate.level);
        }


    }

    // employee class which extends person
    static class Employee extends Person {

        // new variable employee ID
        int employeeID;

        // setting name and ID with class
        Employee(String newName, int newEmployeeID) {
            super(newName);
            employeeID = newEmployeeID;
        }

        // set employee id
        void setEmployeeID(int newEmployeeID) {
            employeeID = newEmployeeID;
        }

        // get employee id
        int getEmployeeID() {
            return employeeID;
        }

        // write output
        void writeOutput() {
            System.out.println("Name: " + name);
            System.out.println("Employee ID: " + employeeID);
        }

    }

    // class faculty which extends employee
    static class Faculty extends Employee {

        // new variables department and title
        String department;
        String title;

        // way to set the name, employee id, department, and title
        Faculty(String newName, int newEmployeeID, String newDepartment, String newTitle) {
            super(newName, newEmployeeID);
            department = newDepartment;
            title = newTitle;
        }

        // set department
        void setDepartment(String newDepartment) {
            department = newDepartment;
        }

        // set title
        void setTitle(String newTitle) {
            title = newTitle;
        }

        // get department
        String getDepartment() {
            return department;
        }

        // get title
        String getTitle() {
            return title;
        }

        // write output
        void writeOutput() {
            super.writeOutput();
            System.out.println("Department: " + department);
            System.out.println("Title: " + title);
        }

        // reset name, employee id, department, and title
        void reset(String newName, int newEmployeeID, String newDepartment, String newTitle) {
            super.setName(newName);
            super.setEmployeeID(newEmployeeID);
            department = newDepartment;
            title = newTitle;
        }

        // making sure there is not overlap
        boolean equal(Faculty otherFaculty) {
            return super.hasSameName(otherFaculty) && (this.employeeID == otherFaculty.employeeID) && (this.department.equalsIgnoreCase(otherFaculty.department)) && (this.title.equalsIgnoreCase(otherFaculty.title));
        }

    }

    // staff class which extends employee too
    static class Staff extends Employee {

        // new department and payg rade variable
        String department;
        int payGrade;

        // setting name, employee id, department, and pay grade with the class
        Staff(String newName, int newEmployeeID, String newDepartment, int newPayGrade) {
            super(newName, newEmployeeID);
            department = newDepartment;
            payGrade = newPayGrade;
        }

        // setting department
        void setDepartment(String newDepartment) {
            department = newDepartment;
        }

        // set pay grade
        void setPayGrade(int newPayGrade) {
            payGrade = newPayGrade;
        }

        // getting department
        String getDepartment() {
            return department;
        }

        // getting pay grade
        int getPayGrade() {
            return payGrade;
        }

        // write output
        void writeOutput() {
            super.writeOutput();
            System.out.println("Department: " + department);
            System.out.println("Pay Grade: " + payGrade);
        }

        // reset the name, employee, department, and pay grade
        void reset(String newName, int newEmployeeID, String newDepartment, int newPayGrade) {
            super.setName(newName);
            super.setEmployeeID(newEmployeeID);
            department = newDepartment;
            payGrade = newPayGrade;
        }

        // making sure that there is no overlap between other staffers
        boolean equal(Staff otherStaff) {
            return super.hasSameName(otherStaff) && (this.employeeID == otherStaff.employeeID) && (this.department.equalsIgnoreCase(otherStaff.department)) && (this.payGrade == otherStaff.payGrade);
        }

    }

}


