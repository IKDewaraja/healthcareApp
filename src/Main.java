
import java.util.*;


public class Main {


    //Admin menu
    public static void adminMenu() {

        boolean runAdminMenu = true;


        while (runAdminMenu) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("press 1 to add a doctor, press 2 to add a doctor availability and press 3 to exit");
            int userObjective = scanner.nextInt();
            if (userObjective == 1) {

                //get the relevant data to add a doctor
                Controller.addDoctor();

                System.out.println("Doctor is added successfully!");




            } else if (userObjective == 2) {
                //    add a doctor availability
                Controller.addAvailabilityForDoctor();


            } else if (userObjective == 3) {
                runAdminMenu = false;
                System.out.println("Exit");
            } else {
                System.out.println("Invalid input");
            }

        }
    }


    //Patient menu
    public static void patientMenu() {
        boolean runPatient = true;
        while (runPatient) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("press 1 to view doctor list press 2 to book an appointment press 3 to view a selected doctor press 4 to exit, press 5 to add a Patient");
            int userObjective = scanner.nextInt();

            if (userObjective == 1) {
                //view all doctors
                Controller.viewAllDoctors();


            } else if (userObjective == 2) {
                System.out.println("Book an appointment");

                Controller.bookAppointment();

            } else if (userObjective == 3) {
                System.out.println("View a selected doctor");

            } else if (userObjective == 4) {
                runPatient = false;
                System.out.println("Exit");

            }
            else if (userObjective==5) {
                Controller.createNewPatient();

            } else {
                System.out.println("Invalid input");
            }
        }
    }




    //Main menu
    public static void run() {

        boolean runMain = true;
        while (runMain) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("if you are a hospital administrator please press 1,if you are a patient please press 2, press 3 to exit");
            int userType = scanner.nextInt();

            if (userType == 1) {
                adminMenu();
            } else if (userType == 2) {
                patientMenu();

            } else if (userType == 3) {

                runMain = false;
                System.out.println("Exit");

            } else {
                System.out.println("Invalid Input");
            }

        }
    }



    public static void main(String[] args) {

        //I have used a sample doctor and a sample patient
        Doctor sampleDoc =new Doctor(22,"sandun","22.2.1988","Cardiologist","0714596896");
        Patient samplePatient = new Patient("T-41","Alice","0178965825");
        Controller.allDoctors.add(sampleDoc);
        Controller.allpatients.add(samplePatient);



        run();


//              //sample doctor objects
//              Doctor doctor1 =  new Doctor(101,"john","1988.2.4","neurophysician","0715467893");
//              Doctor doctor2 =  new Doctor(102,"kamal","1988.2.4","cardiologist","0715456893");
//
//              //teat doctor methods
//              System.out.println("Doctor1:");
//              System.out.println("Is Physician:" +doctor1.isPhysician());
//
//              System.out.println("\nDoctor 2:");
//              System.out.println("Is Physician:" +doctor2.isPhysician());
//
//              //sample patient objects
//              Patient patient1 = new Patient("T-1234","alice","2002.11.29","0715753698");
//              Patient patient2 = new Patient("D-1434","nimali","2014.11.9","0715751588");
//
//              //test patient method
//              System.out.println("\nPatient 1:");
//              System.out.println("Patient type:" +patient1.getPaientType());
//
//              System.out.println("\nPatient 2:");
//              System.out.println("Patient type:" +patient2.getPaientType());
    }
}






