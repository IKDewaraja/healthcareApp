import java.util.*;

public class Controller {


        public static ArrayList<Doctor> allDoctors = new ArrayList<>();
        public static ArrayList<Patient> allpatients = new ArrayList<>();

        public static int NUMBER_OF_SLOTS =5;



        public static void addDoctor() {
            Scanner sc = new Scanner((System.in));
            System.out.println("Enter your Name:");
            String name = sc.nextLine();

            System.out.println("Enter your birthday:");
            String birthday = sc.nextLine();
            System.out.println("Enter your Specialization:");
            String specialization = sc.nextLine();
            System.out.println("Enter your Contact:");
            String contact = sc.nextLine();

            Random random = new Random();
            Doctor tempDoctor = new Doctor(random.nextInt(), name, birthday, specialization, contact);

            allDoctors.add(tempDoctor);

        }

        public static void addAvailabilityForDoctor() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the doctor Id you want to add availability");
            int docId = scanner.nextInt();
            Doctor selectedDoctor = null;


            //    fetch the relevant doctor from the array list
            for (Doctor doc : allDoctors) {

                if (doc.getDoctorId() == docId) {
                    selectedDoctor = doc;


                }
            }
            //     if the entered doctor is not existing we need to print a message "Doctor not found"
            if (selectedDoctor == null) {
                System.out.println("No Doctor found");
                return;

            }

            //     if the doctor is existing take the date
            System.out.println("Enter the Day you want to add availability");
            int day = scanner.nextInt();
            System.out.println("Enter the Month you want to add availability");
            int month = scanner.nextInt();
            System.out.println("Enter the Year you want to add availability");
            int year = scanner.nextInt();

            Date bookingDate = new Date(year, month, day);

            //    add the availability for the doctor
            selectedDoctor.setAvailability(bookingDate);


        }

        public static void viewAllDoctors() {
            for (Doctor doc : allDoctors) {
                System.out.println(doc.getName() + " has a specialization of " + doc.getSpecialization() + " has a id of " + doc.getDoctorId() + " and has a availability of " + doc.getAvailabilities().toString());
                System.out.println(doc.getDoctorId());
            }
        }

        public static void createNewPatient() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Patient Name:");
            String name = scanner.nextLine();
            System.out.println("Enter Patient's Id:");
            String id = scanner.nextLine();
            System.out.println("Enter Patient's Contact Information:");
            String contact = scanner.nextLine();

            Patient temppatient = new Patient(id, name, contact);

            allpatients.add(temppatient);
            System.out.println("Patient is added successfully");
            System.out.println(allpatients.toString());


        }

        public static void bookAppointment() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the doctor Id you want to make an appointment");
            int docId = scanner.nextInt();
            System.out.println("Enter your patient's Id");
            String patientId = scanner.next();

            System.out.println("Enter the Day you want to add appointment");
            String day = scanner.next();
            System.out.println("Enter the Month you want to add appointment");
            String month = scanner.next();
            System.out.println("Enter the Year you want to add appointment");
            String year = scanner.next();

            //get patient and doctor
            Patient selectedPatient = getPatientById(patientId);
            Doctor selectedDoc = getDoctorById(docId);
            if (selectedDoc == null || selectedPatient== null){
                System.out.println("Invalid docId or Invalid patientId ");
                return;
            }

            Date appointmentDate = new Date(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));

            // check the availability of doctor
            Boolean isAvailable = checkAvailability(selectedDoc,appointmentDate);
            if(isAvailable) {

                //check the time for booking
                String appTime = getTimeForBooking(selectedDoc, appointmentDate);
                if (appTime != null) {
                    Appointment appointment = new Appointment(selectedDoc, selectedPatient, "No notes", appointmentDate, "");
                    selectedDoc.setAppointment(appointment, appointmentDate);
                    System.out.println(selectedDoc.allAppointments.toString());
                } else {
                    System.out.println("All the slots are filled.");
                }


                //calculate appointment time and slot availability
                //make the appointment

            }
            else {
                System.out.println("Doctor is not available on the selected date");
            }
        }


        //get the time - first we need to check whether the number of slots are lower than 5
        private  static  String getTimeForBooking(Doctor selectedDoctor, Date dateOfBooking) {
            for (Map.Entry<Date, ArrayList<Appointment>> appointment : selectedDoctor.allAppointments.entrySet()) {
                if (appointment.getKey().equals(dateOfBooking)){
                    int numberOfSlots = appointment.getValue().size();
                    if (numberOfSlots>NUMBER_OF_SLOTS-1){
                        return  null;
                    }

                    // when there are available slots
                    System.out.println("We can make a booking");

                    //print the time
                    int time = 17 + appointment.getValue().size();
                    String strTime = time +  ":00";
                    return strTime;
                }
            }
            return  "17:00";
        }

        private static Boolean checkAvailability(Doctor selectedDoctor, Date dateOfBooking){
            for (Date day: selectedDoctor.getAvailabilities()){
                if(day.equals(dateOfBooking)){
                    return  true;
                }
            }
            return  false;
        }




        public static Doctor getDoctorById(int id) {
            for (Doctor doc :allDoctors) {
                if (doc.getDoctorId()== id) {
                    return doc;
                }
            }

            return  null;
        }


        public static Patient getPatientById(String id) {
            for (Patient patient :allpatients) {
                if (patient.getPatientId().equals(id)) {
                    return patient;
                }
            }

            return  null;
        }

}
