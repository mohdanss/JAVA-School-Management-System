import java.io.FileWriter;
import java.io.IOException; // Importing IOException class to handle errors

/* Class Teacher being inherited from abstract class*/
public class Students extends mySchoolManagementSystem {

  /* private data members */
  private String name;
  private static int idCounter = 1000;
  private int myID;
  private char grade; //A,B,C,D or F
  private double totalFee;
  private boolean feePaidStatus;

  /**Default Constructor */
  Students() {
    name = "";
    myID = ++idCounter;
    grade = 'A';
    totalFee = 30000;
    feePaidStatus = false;
  }

  /*Parameterized Constructor */
  Students(String name_, char grade_) {
    name = name_;
    grade = grade_;
    myID = ++idCounter;
    totalFee = 30000;
    feePaidStatus = false;
  }

  //encapsulation --> setters /getters
  public void setName(String name) {
    this.name = name;
  }

  public void setGrade(char grade) {
    this.grade = grade;
  }

  public void setTotalFee(double totalFee) {
    this.totalFee = totalFee;
  }

  public void setFeePaidStatus(boolean feePaidStatus) {
    this.feePaidStatus = feePaidStatus;
  }

  public String getName() {
    return this.name;
  }

  public int getId() {
    return this.myID;
  }

  public char getGrade() {
    return this.grade;
  }

  public double getTotalFee() {
    return this.totalFee;
  }

  public boolean getFeePaidStatus() {
    return this.feePaidStatus;
  }

  public void updateMe() {
    System.out.println("**** Update Student's Data Here ****");
    System.out.print("Update Student's Name : ");
    this.name = input.nextLine();

    System.out.print("Update Student's Grades : ");
    this.grade = input.next().charAt(0);
    System.out.println();
  }

  /**
   * Over-ridden methods
   * These method are inherited from abstract parent class
   * Hence, Polymorphism is being used here.
   */
  @Override
  void menu() {
    System.out.println("1. Display Student's Data");
    System.out.println("2. Update Student's Data");
    System.out.println("3. Delete Student's Data");
    if (!this.feePaidStatus) {
      System.out.println("4. Fee not yet Paid, Pay your fee.");
    }
  }

  @Override
  void writeToFile() throws IOException {
    // creating file writer object
    FileWriter myObj = null;
    try {
      /* 
      creating file name 'Teachers.txt' 2nd parameter true 
      means, append the new data to existing file */
      myObj = new FileWriter("Students.txt", true);

      // As on console, we use print, to write in file, write is used
      myObj.write(this.myID + "\n");
      myObj.write(this.name + "\n");
      myObj.write(this.grade + "\n");
      myObj.write(this.feePaidStatus + "\n");
    } /* Once data has been written to file, Now close the file */finally {
      try {
        myObj.close();
      }/* In case any exception occurs. */ catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
  }

  @Override
  void printData() {
    System.out.println("\tStudent's ID    :  " + this.myID);
    System.out.println("\tStudent's Name  :  " + this.name);
    System.out.println("\tStudent's Grade :  " + this.grade);
    System.out.println("\tStudent's Fee   :  " + this.totalFee);
    System.out.println("\tFee Paid?       :  " + this.feePaidStatus);
    System.out.println("\t\t  -***-   \n");
  }
}
/* 1) name of student
2) idCounter of student 
3) grade of student
4) total fees of the student.
5) current fees status paid or not. */
