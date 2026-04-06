import java.util.Scanner;

public class StOparation {
    public  void soparation(){
        Scanner sc = new Scanner(System.in);
        int choice;

do {


        System.out.println("Student Operations");
        System.out.println("1. Add Student");
        System.out.println("2. View Student");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Main Menu");
        System.out.println("0. Exit Program");


    System.out.print("Enter your choice: ");
    choice = Integer.parseInt(sc.nextLine());

        switch(choice) {
            case 1:
                StudentManager.addStudent(sc);
                break;

                case 2:
                    StudentManager.viewStudent(sc);
                    break;

                    case 3:
                        StudentManager.updateStudent(sc);
                        break;

                        case 4:
                            StudentManager.deleteStudent(sc);
                            break;

                            case 5:
                                Main.main(null);
                                return;
                                case 0:
                                    System.exit(0);



        }
} while (true);


    }

    public static void addStudent(){


    }


    public static void viewStudent(){

    }

    public static void updateStudent(){

    }

    public static void deleteStudent(){

    }
}
