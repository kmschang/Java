public class SchangKyleProj2 {

    static class Person {

        static String name;

        Person(String newName){
                name = newName;
        }

        public void setName(String name){
                this.name = name;
        }

        public static String getName(){
                return name;
        }

        public void writeOutput(){}

        public boolean hasSameName(Person otherPerson){
                return this.name.equalsIgnoreCase(otherPerson.name);
        }

    }

    static class Student extends Person {

        int studentNumber;

        Student(String newName, int newStudentNumber) {
            super(newName);
            studentNumber = newStudentNumber;
        }

        public void reset(String newName, int newStudentNumber) {
            super.setName(newName);
            studentNumber = newStudentNumber;
        }

        public int getStudentNumber() {
            return studentNumber;
        }

        public void setStudentNumber(int newStudentNumber){
            studentNumber = newStudentNumber;
        }

        public void writeOutput() {
            System.out.println("Name: " + super.name);
            System.out.println("Student Number: " + studentNumber);
        }

        public boolean equal (Student otherStudent) {
            return this.hasSameName(otherStudent) && (this.studentNumber == otherStudent.studentNumber);
        }

    }

    static class Undergraduate extends Student {

        int level;

        Undergraduate(String newName, int newStudentNumber, int newLevel) {
            super(newName, newStudentNumber);
            level = newLevel;
        }

        public void reset(String newName, int newStudentNumber, int newLevel) {
            super.reset(newName, newStudentNumber);
            level = newLevel;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int newLevel) {
            level = newLevel;
        }

        public void writeOutput() {
            System.out.println("Name: " + super.getName());
            System.out.println("Student Number: " + studentNumber);
            System.out.println("Student Level: " + level);
        }

        public boolean equal (Undergraduate otherUndergraduate) {
            return this.equal(otherUndergraduate) && (this.level == otherUndergraduate.level);
        }


    }

    static class Graduate extends Undergraduate {

        Graduate(String newName, int newStudentNumber, int newLevel) {
            super(newName, newStudentNumber, newLevel);
        }

        public boolean equal (Graduate othergraduate) {
            return this.equal(othergraduate) && (this.level == othergraduate.level);
        }

    }


    public static void main(String[] args) {

        Person[] people = new Person[4];

        people[0] = new Undergraduate("Cotty, Manny", 4910, 1);
        people[1] = new Undergraduate("Kick, Anita", 9931, 2);
        people[2] = new Student("DeBanque, Robin", 8812);
        people[3] = new Undergraduate("Bugg, June", 9901, 4);

        for (Person p : people) {
            p.writeOutput();
            System.out.println(); }

    }




}
