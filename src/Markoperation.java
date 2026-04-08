import java.util.Scanner;

public class Markoperation {
    public  void moperation(){
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("Marks Operation");
        System.out.println("1. Add Marks");
        System.out.println("2. Display All Students Marks");
        System.out.println("3. Display Individual Student Marks");
        System.out.println("4. Main Menu");
        System.out.println("0. Exit");

        choice = Integer.parseInt(sc.nextLine());
        System.out.println("Enter your choice");


        switch (choice) {
            case 1:
                MarksManager.addMarks(sc);
                break;

                case 2:
                    MarksManager.displayAllMarks();
                    break;

                    case 3:
                        MarksManager.displayIndividualMarks();
                        break;
                        case 4:
                            Main.main(null);
                            break;
                            case 0:
                                System.exit(0);
                                default:
                                    break;



        }







    }

}
