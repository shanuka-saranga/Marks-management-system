import java.util.Scanner;

public class StOparation {
    public static void soparation(){
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


        choice = sc.nextInt();
        System.out.println("Enter your choice: ");

        switch(choice) {
            case 1:
                addStudent();
                break;

                case 2:
                    viewStudent();
                    break;

                    case 3:
                        updateStudent();
                        break;

                        case 4:
                            deleteStudent();
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
