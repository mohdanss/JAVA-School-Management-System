import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException; // Importing IOException class to handle errors
import java.util.Scanner;

//class School, extended/inherited from abstract class(polymorphism)
public class School extends mySchoolManagementSystem {

  Scanner input = new Scanner(System.in);
  // privte data members of school class
  private int teachersCapacity;
  private int studentsCapacity;
  private int noOfTeachers;
  private int noOfStudents;
  private double totalIncome;
  private double totalExpense;

  // list of teachers in students
  private Teachers[] teachers;
  private Students[] students;

  /* Default Constructor */
  School() {
    studentsCapacity = 50;
    teachersCapacity = 10;
    noOfTeachers = 0;
    noOfStudents = 0;
    teachers = new Teachers[teachersCapacity];
    students = new Students[studentsCapacity];
    totalIncome = 0;
    totalExpense = 0;
  }

  /**
   * Parameterized contructor,
   * all other data members are set to default
   * @param stCap_
   * @param teachCap_
   */
  School(int stCap_, int teachCap_) {
    studentsCapacity = stCap_;
    teachersCapacity = teachCap_;
    noOfTeachers = 0;
    noOfStudents = 0;
    teachers = new Teachers[teachersCapacity];
    students = new Students[studentsCapacity];
    totalIncome = 0;
    totalExpense = 0;
  }

  /**
   * Setters/Getters
   * Encapsulation is used in this way...
   */

  public void setStudentsCapacity(int studentsCapacity) {
    this.studentsCapacity = studentsCapacity;
  }

  public void setTeachersCapacity(int teachersCapacity) {
    this.teachersCapacity = teachersCapacity;
  }

  /* method to get teacher's list */
  public Teachers[] getTeachers() {
    return teachers;
  }

  /* method to get student's list */
  public Students[] getStudents() {
    return students;
  }

  public int getNoOfTeachers() {
    return noOfTeachers;
  }

  public int getNoOfStudents() {
    return noOfStudents;
  }

  public int getTeachersCapacity() {
    return teachersCapacity;
  }

  public int getStudentsCapacity() {
    return studentsCapacity;
  }

  /**
   * Checks if the student's list is full or not
   */
  public boolean isStudentsFull() {
    return noOfStudents == studentsCapacity;
  }

  /**
   * Checks if the teacher's list is full or not
   */
  public boolean isTeachersFull() {
    return noOfTeachers == teachersCapacity;
  }

  /**
   * Unit Fee is set to default,
   * Total income is calculated through this method
   * @return Total income
   */
  public double getTotalIncome() {
    totalIncome = noOfStudents * 30000;
    return this.totalIncome;
  }

  /**
   * Unit salary is set to default,
   * Total expense is calculated through this method
   * @return Total Expense
   */
  public double getTotalExpense() {
    totalExpense = noOfTeachers * 25000;
    return this.totalExpense;
  }

  /**
   * Adds new teacher to the list
   * If List is full, displays appropriate message
   * else, adds the teacher to the list
   */
  public void addTeacher() {
    if (isTeachersFull()) {
      System.out.println("Faculty is upto limit, teacher can't be added!");
    } else {
      //scanner object to get data from user
      // Scanner input = new Scanner(System.in);

      System.out.println("=== Welcome to Teacher's Registration System ===");
      System.out.print("Enter Teacher's Name : ");
      String name_ = input.nextLine();
      System.out.print("Enter Subject He/She wanna teach : ");
      String subject_ = input.nextLine();

      /* 
		All other data fields Like ID, salary 
		and paid status are set to default 
	  */

      //adding new teacher to the list
      teachers[noOfTeachers++] = new Teachers(name_, subject_);
      System.out.println(name_ + " Has joined the Faculty Successfully!");
    }
  }

  /**
   * Adds new student to the list
   * If List is full, displays appropriate message
   * else, adds the student to the list
   */
  public void addStudent() {
    if (isStudentsFull()) {
      System.out.println("No seat available for new students.");
    } else {
      //scanner object ot get data from user
      // Scanner input = new Scanner(System.in);

      System.out.println("=== Welcome to Student's Registration System ===");
      System.out.print("Enter Student's Name  : ");
      String name_ = input.nextLine();
      char grade_;
      do {
        System.out.print("Enter his/her Grade (A,B,C,D OR F) : ");
        grade_ = input.nextLine().charAt(0);

        if (
          !(
            grade_ == 'A' ||
            grade_ == 'B' ||
            grade_ == 'C' ||
            grade_ == 'D' ||
            grade_ == 'F'
          )
        ) {
          System.out.print("Invalid!");
        } else {
          break;
        }
      } while (true);

      /* 
		All other data fields Like ID, Fee 
		and paid status are set to default 
	  */

      //adding new teacher to the list
      students[noOfStudents++] = new Students(name_, grade_);
      System.out.println(name_ + " Admitted to school Successfully!");
    }
  }

  public void removeTeacher(Teachers teacherObj) {
    int target = 0;
    boolean found = false;
    for (int i = 0; i < noOfTeachers; i++) {
      if (teachers[i] == teacherObj) {
        target = i;
        found = true;
        break;
      }
    }
    if (found) {
      for (int i = target; i < this.noOfTeachers - 1; i++) {
        this.teachers[i] = this.teachers[i + 1];
      }
      this.teachers[noOfTeachers--] = null;
    } else {
      System.out.println("No record Found\n");
    }
  }

  public void removeStudent(Students studentObj) {
    int target = 0;
    boolean found = false;
    for (int i = 0; i < noOfStudents; i++) {
      if (students[i] == studentObj) {
        target = i;
        found = true;
        break;
      }
    }
    if (found) {
      for (int i = target; i < this.noOfStudents - 1; i++) {
        this.students[i] = this.students[i + 1];
      }
      this.students[noOfStudents--] = null;
    } else {
      System.out.println("No record Found\n");
    }
  }

  /**
   * This method displays the school's statistics
   */
  public void ourStatistics() {
    System.out.println("\n\t  **** Our Statistics **** ");
    System.out.println("\tTotal Teachers : " + this.noOfTeachers);
    System.out.println("\tTotal Students : " + this.noOfStudents);
    System.out.println("\tTotal Income   : " + this.getTotalIncome());
    System.out.println("\tTotal Expense  : " + this.getTotalExpense());
    System.out.println("\t\t   ***   \n");
  }

  /**
   * This method, checks
   * if there are Teachers in the list,
   * Displays 'em
   */
  public void showTeacherData() {
    if (this.noOfTeachers != 0) {
      System.out.println("\n\t=== Teacher's Data === ");

      for (int i = 0; i < noOfTeachers; i++) {
        teachers[i].printData();
      }
    } else {
      System.out.println("No teacher in the school's faculty.");
    }
  }

  /**
   * This method, checks
   * if there are Students in the list,
   * Displays 'em
   */
  public void showStudentData() {
    if (this.noOfStudents != 0) {
      System.out.println("\n\t=== Student's Data === ");

      for (int i = 0; i < noOfStudents; i++) {
        students[i].printData();
      }
    } else {
      System.out.println("No Student has yet admited to the school.");
    }
  }

  /**
   * Over-ridden methods
   * These method are inherited from abstract parent class
   * Hence, Polymorphism is being used here.
   */
  @Override
  void menu() {
    System.out.println("\n**** Welcome to School Management System ****");
    System.out.println("\t1. Show School's Data");
    System.out.println("\t2. Show Teacher's Data");
    System.out.println("\t3. Show Student's Data");
    System.out.println("\t4. Show School's Statictics.");
    System.out.println("\t5. Deal With a Teacher");
    System.out.println("\t6. Deal With a Student");
    System.out.println("\t7. Add a Teacher");
    System.out.println("\t8. Add a Student");
    System.out.println("\t9. Save Data to File");
    System.out.println("\t10. Exit");
    System.out.println("---------------------------------------------");
  }

  @Override
  void writeToFile() throws IOException {
    if (!(noOfStudents == 0 && noOfTeachers == 0)) {
      // creating file writer object
      FileWriter myObj = null;
      try {
        /* 
      creating file name 'School.txt' 2nd parameter true 
      means, append the new data to existing file */
        myObj = new FileWriter("School.txt");

        // As on console, we use print, to write in file, write is used
        myObj.write(this.studentsCapacity + "\n");
        myObj.write(this.teachersCapacity + "\n");
        myObj.write(this.noOfTeachers + "\n");
        myObj.write(this.noOfStudents + "\n");
        myObj.write((int) this.getTotalIncome() + "\n");
        myObj.write((int) this.getTotalExpense() + "\n");
      } /* Once data has been written to file, Now close the file */finally {
        try {
          myObj.close();
        } /* In case any exception occurs. */catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
      }
    }
  }

  void readFromFile() {
    /* Reading from SCHOOL.TXT */
    int schoolDataArr[] = { 0, 0, 0, 0, 0, 0 };
    //as we've got 6 values in file,
    //so we'll store them in array of 6 elements.

    File schoolFileObj = new File("School.txt");
    if (!(schoolFileObj.length() == 0)) {
      try {
        Scanner myReader = new Scanner(schoolFileObj);
        for (int i = 0; myReader.hasNextLine(); i++) {
          String data = myReader.nextLine();
          schoolDataArr[i] = Integer.parseInt(data);
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred!!!");
        e.printStackTrace();
      }
    }
    // else {
    //   System.out.println("School.txt is empty...");
    // }

    //Reading data from file, adn assigning it to class data members
    this.teachersCapacity = schoolDataArr[0];
    this.studentsCapacity = schoolDataArr[1];
    this.noOfTeachers = schoolDataArr[2];
    this.noOfStudents = schoolDataArr[3];
    this.totalIncome = schoolDataArr[4];
    this.totalExpense = schoolDataArr[5];

    /* Reading from TEACHERS.TXT */
    // as first element is capacity of teachers at school
    //And each teacher object must have 5 data members
    String tchDataArr[] = new String[schoolDataArr[0] * 5];

    File tchrFileObj = new File("Teachers.txt");
    if (!(tchrFileObj.length() == 0)) {
      try {
        Scanner myReader = new Scanner(tchrFileObj);
        for (int i = 0; myReader.hasNextLine(); i++) {
          String data = myReader.nextLine();
          tchDataArr[i] = data;
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
    // else {
    // System.out.println("Teachers.txt is empty...");
    // }

    if (tchrFileObj.length() != 0) {
      for (int i = 0; i < noOfTeachers * 5; i++) {
        int ID = Integer.parseInt(tchDataArr[i++]);
        String name = tchDataArr[i++].strip();
        String subject = tchDataArr[i++].strip();
        double salary = Double.parseDouble(tchDataArr[i++]);
        String salStatus = tchDataArr[i].strip();
        boolean status = false;
        if (salStatus.equals("true")) {
          status = true;
        }
        if (salStatus.equals("false")) {
          status = false;
        }
        if (!name.equals(null)) {
          this.getTeachers()[i / 5] = new Teachers(name, subject);
          this.getTeachers()[i / 5].setPaidStatus(status);
        }
      }
    }

    /* Reading from STUDENTS.TXT */
    // as second element is capacity of teachers at school
    //And each students object must have 4 data members
    String studDataArr[] = new String[schoolDataArr[1] * 5];

    File studFileObj = new File("Students.txt");
    if (!(studFileObj.length() == 0)) {
      try {
        Scanner myReader = new Scanner(studFileObj);
        for (int i = 0; myReader.hasNextLine(); i++) {
          String data = myReader.nextLine();
          studDataArr[i] = data;
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
    // else {
    // System.out.println("Students.txt is empty...");
    // }

    if (studFileObj.length() != 0) {
      for (int i = 0; i < noOfStudents * 4; i++) {
        int ID = Integer.parseInt(studDataArr[i++]);
        String name = studDataArr[i++].strip();
        String grade = studDataArr[i++].strip();
        String feeStatus = studDataArr[i].strip();
        boolean status = false;
        if (feeStatus.equals("true")) {
          status = true;
        }
        if (feeStatus.equals("false")) {
          status = false;
        }
        if (!name.equals(null)) {
          this.getStudents()[i / 4] = new Students(name, grade.charAt(0));
          this.getStudents()[i / 4].setFeePaidStatus(status);
        }
      }
    }
  }

  /**
   * Method to display all the vailable data of school
   */
  @Override
  void printData() {
    //if no students and teacher, don't diplay anything
    if (noOfStudents == noOfTeachers && noOfTeachers == 0) {
      System.out.println("No data available for School yet!!!");
    }
    //else check, which (student or teacher) is present, and siplay them
    else {
      System.out.println("\n\t==== School's Data ====");

      //Dsiplaying teachers in the list
      if (noOfTeachers != 0) {
        System.out.println("\n\t**** Teacher's At School ****");
        for (int i = 0; i < noOfTeachers; i++) {
          this.teachers[i].printData();
        }
      } else {
        System.out.println("\nNo teacher in the school's faculty");
      }

      //Dsiplaying students in the list
      if (noOfStudents != 0) {
        System.out.println("\n\t**** Student's At School ****");
        for (int i = 0; i < noOfStudents; i++) {
          students[i].printData();
        }
      } else {
        System.out.println("No students in the school.");
      }
    }
  }
}
/* 
The school class should have following:
1) list of students
2) list of teachers
3) method to get teachers list
4) method to get student list
5) method to add any new teacher
6) method to add any new student
7) method to calculate total money earned by school
8) method to calculate total money spent on teachers
9) method update spent money 
 */
