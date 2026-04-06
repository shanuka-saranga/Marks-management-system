import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("Main Menu");
        System.out.println("1. Student Operations");
        System.out.println("2. Marks Operations");
        System.out.println("3. Exit");
        System.out.println("Enter your choice: ");


        choice = sc.nextInt();

        switch (choice){
            case 1:
                StOparation stOparation = new StOparation();
                stOparation.soparation();

            case 2:
                Markoperation markoperation =new Markoperation();
                markoperation.moperation();

            case 3:
                System.exit(0);
                default:
                    break;

        }








    }
}