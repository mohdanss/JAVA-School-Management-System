import java.io.FileWriter;
import java.io.IOException; // Importing IOException class to handle errors

public class Teachers extends mySchoolManagementSystem {

  /* private data members */
  private String name;
  private static int idCounter = 100;
  private int myID;
  private String subjectTeaches;
  private double salary;
  private boolean salaryPaidStatus;

  /* Default contructor */
  Teachers() {
    name = "";
    subjectTeaches = "";
    myID = ++idCounter;
    salary = 25000;
    salaryPaidStatus = false;
  }

  /* Parameterized constructor */
  Teachers(String name_, String Subject_) {
    this.name = name_;
    this.subjectTeaches = Subject_;

    //below, all data feilds are set to default
    myID = ++idCounter;
    this.salary = 25000;
    this.salaryPaidStatus = false;
  }

  //encapsulation --> setters /getters
  public void setName(String name_) {
    this.name = name_;
  }

  public void setSubject(String subject_) {
    this.subjectTeaches = subject_;
  }

  public void setSalary(double salary_) {
    this.salary = salary_;
  }

  public void setPaidStatus(Boolean status_) {
    this.salaryPaidStatus = status_;
  }

  public String getName() {
    return this.name;
  }

  public int getId() {
    return this.myID;
  }

  public String getSubjectTeaches() {
    return this.subjectTeaches;
  }

  public double getSalary() {
    return this.salary;
  }

  public boolean getPaidStatus() {
    return this.salaryPaidStatus;
  }

  public void updateMe() {
    System.out.println("**** Update Teacher's Data Here ****");
    System.out.print("Update Teacher's Name : ");
    this.name = input.nextLine();

    System.out.print("Update Subject He/She wanna teach : ");
    this.subjectTeaches = input.nextLine();
    System.out.println();
  }

  /**
   * Over-ridden methods
   * These method are inherited from abstract parent class
   * Hence, Polymorphism is being used here.
   */
  @Override
  void menu() {
    System.out.println("1. Display Teacher's Data");
    System.out.println("2. Update Teacher's Data");
    System.out.println("3. Delete Teacher's Data");
    if (!this.salaryPaidStatus) {
      System.out.println("4. Get your salary?");
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
      myObj = new FileWriter("Teachers.txt", true);

      // As on console, we use print, to write in file, write is used
      myObj.write(this.myID + "\n");
      myObj.write(this.name + "\n");
      myObj.write(this.subjectTeaches + "\n");
      myObj.write(this.salary + "\n");
      myObj.write(this.salaryPaidStatus + "\n");
    }
    /* Once data has been written to file, Now close the file */
     finally {
      try {
        myObj.close();
      }
       /* In case any exception occurs. */
       catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
  }

  @Override
  void printData() {
    System.out.println("\tTeacher's ID     :  " + this.myID);
    System.out.println("\tTeacher's Name   :  " + this.name);
    System.out.println("\tSubject Teaches  :  " + this.subjectTeaches);
    System.out.println("\tTeacher's Salary :  " + this.salary);
    System.out.println("\tSalary Paid?     :  " + this.salaryPaidStatus);
    System.out.println("\t\t  -***-   \n");
  }
}
/* 
1) name of teacher
2) idCounter of teacher
3) subject of teacher
4) Salary of the teacher.
6) Current salary status paid or not.
 */
