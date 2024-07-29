public class Patient extends  Person {


    private   String patientId;


    private   String name;

    private String contactNumber;


    public  Patient(String patientId,String name,  String contactNumber){
        super(name,contactNumber);
        this.patientId =patientId;

    }
    protected String getPatientId(){

        return this.patientId;
    }




    public  char getPaientType(){
        char firstLetter = this.patientId.charAt(0);
        return  firstLetter;  //get the first character of the patient Id
    }

}

