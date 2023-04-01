/*
Kyle Schang
EECS 1510
03-30-2023

Started off with the main class Person. Then I made the class Student which extends Person. Then I made the class Undergraduate which extends Student.

 */

public class SchangKyleProj2 {

    public static void main(String[] args) {

        Person[] people = new Person[9];

        people[0] = new Undergraduate("Cotty, Manny", 4910, 1);
        people[1] = new Undergraduate("Kick, Anita", 9931, 2);
        people[2] = new Student("DeBanque, Robin", 8812);
        people[3] = new Undergraduate("Bugg, June", 9901, 4);
        people[4] = new Graduate("Schang, Kyle", 3351, 8);

        people[5] = new Employee("Shan, Kathy", 2130);
        people[6] = new Faculty("Cook, Jobs", 4356, "Cooking", "Head Chef");
        people[7] = new Staff("Smith, Bob", 7453, "Custodian", 3);
        people[8] = new Faculty("Jones, John", 1234, "Math", "Professor");



        for (Person p : people) {

            p.writeOutput();

            System.out.println();

        }


    }


    static class Person {

        String name;

        Person(String newName) {
            name = newName;
        }


        void setName(String newName) {
            this.name = newName;
        }

        String getName() {
            return name;
        }

        void writeOutput() {
            System.out.println("Name: " + name);
        }

        boolean hasSameName(Person otherPerson) {
            return this.name.equalsIgnoreCase(otherPerson.name);
        }

    }

    static class Student extends Person {

        int studentNumber;

        Student(String newName, int newStudentNumber) {
            super(newName);
            studentNumber = newStudentNumber;
        }

        void setStudentNumber(int newStudentNumber) {
            studentNumber = newStudentNumber;
        }

        int getStudentNumber() {
            return studentNumber;
        }

        void writeOutput() {
            System.out.println("Name: " + name);
            System.out.println("Student Number: " + studentNumber);
        }

        void reset(String newName, int newStudentNumber) {
            super.setName(newName);
            studentNumber = newStudentNumber;
        }

        boolean equal(Student otherStudent) {
            return this.hasSameName(otherStudent) && (this.studentNumber == otherStudent.studentNumber);
        }


    }

    static class Undergraduate extends Student {

        int level;

        Undergraduate(String newName, int newStudentNumber, int newLevel) {
            super(newName, newStudentNumber);
            level = newLevel;
        }

        void setLevel(int newLevel) {
            level = newLevel;
        }

        int getLevel() {
            return level;
        }

        void writeOutput() {
            super.writeOutput();
            System.out.println("level: " + level);
        }

        boolean equal(Undergraduate otherUndergraduate) {
            return super.equal(otherUndergraduate) && (this.level == otherUndergraduate.level);
        }

        void reset(String newName, int newStudentNumber, int newLevel) {
            super.reset(newName, newStudentNumber);
            level = newLevel;
        }



    }


    static class Graduate extends Student {

        int level;

        Graduate(String newName, int newStudentNumber, int newLevel) {
            super(newName, newStudentNumber);
            level = newLevel;
        }

        void setLevel(int newLevel) {
            level = newLevel;
        }

        int getLevel() {
            return level;
        }


        void writeOutput() {
            super.writeOutput();
            System.out.println("level: " + level);
        }

        void reset(String newName, int newStudentNumber, int newLevel) {
            super.reset(newName, newStudentNumber);
            level = newLevel;
        }

        boolean equal(Graduate otherGraduate) {
            return super.equal(otherGraduate) && (this.level == otherGraduate.level);
        }


    }


    static class Employee extends Person {

        int employeeID;

        Employee(String newName, int newEmployeeID) {
            super(newName);
            employeeID = newEmployeeID;
        }

        void setEmployeeID(int newEmployeeID) {
            employeeID = newEmployeeID;
        }

        int getEmployeeID() {
            return employeeID;
        }

        void writeOutput() {
            System.out.println("Name: " + name);
            System.out.println("Employee ID: " + employeeID);
        }


    }

    static class Faculty extends Employee {

        String department;
        String title;

        Faculty(String newName, int newEmployeeID, String newDepartment, String newTitle) {
            super(newName, newEmployeeID);
            department = newDepartment;
            title = newTitle;
        }

        void setDepartment(String newDepartment) {
            department = newDepartment;
        }

        void setTitle(String newTitle) {
            title = newTitle;
        }

        String getDepartment() {
            return department;
        }

        String getTitle() {
            return title;
        }

        void writeOutput() {
            super.writeOutput();
            System.out.println("Department: " + department);
            System.out.println("Title: " + title);
        }

        void reset(String newName, int newEmployeeID, String newDepartment, String newTitle) {
            super.setName(newName);
            super.setEmployeeID(newEmployeeID);
            department = newDepartment;
            title = newTitle;
        }

        boolean equal(Faculty otherFaculty) {
            return super.hasSameName(otherFaculty) && (this.employeeID == otherFaculty.employeeID) && (this.department.equalsIgnoreCase(otherFaculty.department)) && (this.title.equalsIgnoreCase(otherFaculty.title));
        }



    }

    static class Staff extends Employee {

        String department;
        int payGrade;

        Staff(String newName, int newEmployeeID, String newDepartment, int newPayGrade) {
            super(newName, newEmployeeID);
            department = newDepartment;
            payGrade = newPayGrade;
        }

        void setDepartment(String newDepartment) {
            department = newDepartment;
        }

        void setPayGrade(int newPayGrade) {
            payGrade = newPayGrade;
        }

        String getDepartment() {
            return department;
        }

        int getPayGrade() {
            return payGrade;
        }

        void writeOutput() {
            super.writeOutput();
            System.out.println("Department: " + department);
            System.out.println("Pay Grade: " + payGrade);
        }

        void reset(String newName, int newEmployeeID, String newDepartment, int newPayGrade) {
            super.setName(newName);
            super.setEmployeeID(newEmployeeID);
            department = newDepartment;
            payGrade = newPayGrade;
        }

        boolean equal(Staff otherStaff) {
            return super.hasSameName(otherStaff) && (this.employeeID == otherStaff.employeeID) && (this.department.equalsIgnoreCase(otherStaff.department)) && (this.payGrade == otherStaff.payGrade);
        }

    }



}


