import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        Scanner input = new Scanner(System.in);

        while(true){
            showOperations();
            System.out.println("#Enter the number of the operation:");
            String operation = input.next();

            if(operation.equals("6")){
                System.out.println(">Terminating the program...");
                break;
            }

            if(operation.equals("1")){
                System.out.println("Enter name:");
                String name = input.next();
                System.out.println("Enter domain:");
                String domain = input.next();
                System.out.println("Enter address:");
                String address = input.next();
                studentDAO.addStudentProfile(name,domain,address);
                System.out.println(">Adding operation successful");
            }else if(operation.equals("2")){

                studentDAO.displayStudentProfiles();

            }else if(operation.equals("3")){

                System.out.println("Enter the ID of the student you searching:");
                int id = input.nextInt();
                studentDAO.displayStudentProfilesByID(id);

            }else if(operation.equals("4")){

                System.out.println("Enter ID for deleting operation:");
                int id = input.nextInt();
                studentDAO.deleteStudentProfile(id);
                System.out.println(">Deletion successful.");

            }else if(operation.equals("5")){

                System.out.println("Press 1 --> Update Domain\nPress 2 --> Update Address");
                String choice = input.next();

                if(choice.equals("1")){
                    System.out.println("Enter ID:");
                    int id = input.nextInt();
                    System.out.println("Enter new Domain:");
                    String domain = input.next();
                    studentDAO.updateStudentDomain(domain,id);
                    System.out.println(">Domain updated.");

                }else if(choice.equals("2")){
                    System.out.println("Enter ID:");
                    int id = input.nextInt();
                    System.out.println("Enter new Address:");
                    String address = input.next();
                    studentDAO.updateStudentAddress(address,id);
                    System.out.println(">Address updated.");
                }

            }

        }
    }
    public static void showOperations(){
        System.out.println("-------------OPERATIONS-----------");
        System.out.println("-Press 1 for Adding Student Profile");
        System.out.println("-Press 2 for Displaying Student Profiles");
        System.out.println("-Press 3 for Displaying Student Profile by ID");
        System.out.println("-Press 4 for Deleting Student Profile");
        System.out.println("-Press 5 for Updating Student Profile");
        System.out.println("-Press 6 for Exiting the Portal");
    }
}
