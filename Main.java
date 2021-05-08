import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static Scanner input = new Scanner(System.in);

  /*1. This method is used to pdisplay the Main Menu*/
  static void menu(School schoolObj) {
    schoolObj.menu();
  }

  /* This method is used to display the school's Data */
  static void ShowSchoolData(School schoolObj) {
    schoolObj.printData();
  }

  /* This method is used to display the Teacher's Data */
  static void showTeacherData(School schoolObj) {
    //looping through the list of teachers to display it's data
    for (int i = 0; i < schoolObj.getNoOfTeachers(); i++) {
      schoolObj.getTeachers()[i].printData();
    }
  }

  /* This method is used to display the Student's Data */
  static void showStudentData(School schoolObj) {
    //looping through the list of students to display it's data
    for (int i = 0; i < schoolObj.getNoOfStudents(); i++) {
      schoolObj.getStudents()[i].printData();
    }
  }

  /* This method is used to display the Statistics of school */
  static void ShowSchoolStatistics(School schoolObj) {
    schoolObj.ourStatistics();
  }

  /**
   * This method is used to
   * Display
   * Edit
   * Delete
   * the existing teacher's Data....
   */
  static void dealWithTeacher(School schoolObj, int id_) {
    int choice = -1;
    do {
      if (choice == 0) {
        break;
      }
      schoolObj.getTeachers()[id_ - 101].menu();
      System.out.print("\nSelect From Menu (0 to exit) : ");
      choice = input.nextInt();
      switch (choice) {
        case 1:
          schoolObj.getTeachers()[id_ - 101].printData();
          break;
        case 2:
          schoolObj.getTeachers()[id_ - 101].updateMe();
          break;
        case 3:
          schoolObj.removeTeacher(schoolObj.getTeachers()[id_ - 101]);
          break;
        case 4:
          System.out.print("Enter 1 to Confirm ");
          int choicee = input.nextInt();

          if (choicee == 1) {
            schoolObj.getTeachers()[id_ - 101].setPaidStatus(true);
            System.out.println("Fund will be transferred into your account!\n");
          }
          break;
        case 0:
          System.out.println("Thanks for visiting you profile!\n");
          choice = 0;
          break;
        default:
          break;
      }

      //if user deleted, then nothing to deal with it, so back to main menu.
      if (choice == 3) {
        break;
      }
    } while (choice != 0);
  }

  /**
   * This method is used to
   * Display
   * Edit
   * Delete
   * the existing student's Data....
   */
  static void dealWithStudent(School schoolObj, int id_) {
    int choice = -1;
    while (choice != 0) {
      schoolObj.getStudents()[id_ - 1001].menu();
      System.out.print("\nSelect From Menu (0 to exit) : ");
      choice = input.nextInt();

      switch (choice) {
        case 1:
          schoolObj.getStudents()[id_ - 1001].printData();
          break;
        case 2:
          schoolObj.getStudents()[id_ - 1001].updateMe();
          break;
        case 3:
          schoolObj.removeStudent(schoolObj.getStudents()[id_ - 1001]);
          break;
        case 4:
          System.out.print("Enter 1 to Confirm ");
          int choicee = input.nextInt();

          if (choicee == 1) {
            schoolObj.getStudents()[id_ - 1001].setFeePaidStatus(true);
            System.out.println("Fee submitted successfully!\n");
          }
          break;
        case 0:
          System.out.println("Thanks for visiting you profile!\n");
          choice = 0;
          break;
        default:
          break;
      }
      //if user deleted, then nothing to deal with it, so back to main menu.
      if (choice == 3) {
        break;
      }
    }
  }

  static void removeFiles() {
    File myObj = new File("School.txt");
    File myObj2 = new File("Teachers.txt");
    File myObj3 = new File("Students.txt");
    if (myObj.delete() && myObj2.delete() && myObj3.delete()) {
      System.out.println(
        "Deleted the files : \n" +
        myObj.getName() +
        "\n" +
        myObj2.getName() +
        "\n" +
        myObj3.getName()
      );
    }
    //  else {
      // System.out.println("Failed to delete the file.");
    // }
  }

  static void saveToFile(School schoolObj) throws IOException {
    schoolObj.writeToFile();
    for (int i = 0; i < schoolObj.getNoOfTeachers(); i++) {
      schoolObj.getTeachers()[i].writeToFile();
    }
    for (int i = 0; i < schoolObj.getNoOfStudents(); i++) {
      schoolObj.getStudents()[i].writeToFile();
    }
  }

  public static void main(String[] args) throws IOException {
    //creating instance/object of class
    School schoolObj = new School(10, 50);

    //reading data from file, if exists
    schoolObj.readFromFile();
    if (
      schoolObj.getStudentsCapacity() == 0 ||
      schoolObj.getTeachersCapacity() == 0
    ) {
      schoolObj.setTeachersCapacity(10);
      schoolObj.setStudentsCapacity(50);
    }

    int choice = -1;
    do {
      schoolObj.menu();
      System.out.print("Select from Menu (1 - 10) : ");
      choice = input.nextInt();

      /* Following Code Segment is used to Clear screen */
      System.out.print("\033[H\033[2J");
      System.out.flush();
      /**
       * Program will be driven as per respective menu's choice
       * with the hel of following switch statement
       */
      switch (choice) {
        case 1:
          schoolObj.printData();
          break;
        case 2:
          schoolObj.showTeacherData();
          break;
        case 3:
          schoolObj.showStudentData();
          break;
        case 4:
          schoolObj.ourStatistics();
          break;
        case 5:
          if (schoolObj.getNoOfTeachers() == 0) {
            System.out.println("No Teacher in the School's Faculty Yet -- ");
          } else {
            int id_;
            int max = schoolObj.getTeachersCapacity() + 100;
            do {
              System.out.println("Available IDs...");
              for (int i = 0; i < schoolObj.getNoOfTeachers(); i++) {
                System.out.print("\t" + (i + 1) + ". " + 10 + (i + 1) + "   ");
              }
              System.out.print("\nEnter Teacher's ID ( i-e 101) : ");

              id_ = input.nextInt();
              if (id_ < 101 || id_ > max) {
                System.out.print("Invalid, ID range is 101-" + max + " ");
              } else {
                break;
              }
            } while (true);
            if (id_ <= schoolObj.getNoOfTeachers() + 100) {
              dealWithTeacher(schoolObj, id_);
            } else {
              System.out.println("No Record Found!");
            }
          }
          break;
        case 6:
          if (schoolObj.getNoOfStudents() == 0) {
            System.out.println("No student admitted yet -- EMPTY!!!");
          } else {
            int ID_;
            int max = schoolObj.getStudentsCapacity() + 1000;
            do {

              System.out.println("Available IDs...");
              for (int i = 0; i < schoolObj.getNoOfStudents(); i++) {
                System.out.print("\t" + (i + 1) + ". " + 100 + (i + 1) + " : ");
              }
              System.out.print("\nEnter Student's ID ( i-e 1001) : ");
              ID_ = input.nextInt();
              if (ID_ < 1001 || ID_ > max) {
                System.out.print("Invalid, ID range is 1001-" + max + " ");
              } else {
                break;
              }
            } while (true);
            if (ID_ <= schoolObj.getNoOfStudents() + 1000) {
              dealWithStudent(schoolObj, ID_);
            } else {
              System.out.println("No Record Found!");
            }
          }
          break;
        case 7:
          schoolObj.addTeacher();
          break;
        case 8:
          schoolObj.addStudent();
          break;
        case 9:
          char save = 'n';
          System.out.println("--------------------------------");
          System.out.println("   ---> Save Data to file       ");
          System.out.println("--------------------------------");
          System.out.print(" ---> (y/n) ? ");
          save = input.next().charAt(0);
          if (save == 'y' || save == 'Y') {
            removeFiles();
            saveToFile(schoolObj);
            System.out.println("\n**** Data Saved -- Successfully! ****");
          }
          break;
        case 10:
          char saved = 'n';
          System.out.println("--------------------------------");
          System.out.println("   ---> Save Data to file       ");
          System.out.println("--------------------------------");
          System.out.print(" ---> (y/n) ? ");
          save = input.next().charAt(0);
          if (saved == 'y' || saved == 'Y') {
            removeFiles();
            saveToFile(schoolObj);
            System.out.println("\n**** Data Saved -- Successfully! ****");
          }
          System.out.println("\n**** Thanks For Having Us! Good Bye ****");
          System.exit(0);
        default:
          System.out.println("INVALID Choice :/");
          break;
      }
    } while (choice != 0);
    input.close();
  }
}
