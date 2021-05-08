import java.io.IOException;
import java.util.Scanner;

abstract class mySchoolManagementSystem {

  public Scanner input = new Scanner(System.in);

  abstract void menu();

  abstract void writeToFile() throws IOException;

  abstract void printData();
}
