import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
public class Ticket {
    private String row;
    private int seat;
    private double price;
    private Person person;

    /**
     * Constructs a new Ticket object with the specified row, seat, price, and person.
     *
     * @param row The seat row letter
     * @param seat The seat number
     * @param price The price of the seat
     * @param person The person associated with the ticket
     */
    public Ticket(String row, int seat, double price, Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public String getRow() {
        return row;             //Return the seat row letter.
    }
    public void setRow(String row) {
        this.row = row;         //Sets the seat row letter.
    }

    public int getSeat() {
        return seat;            //Return the seat number.
    }
    public void setSeat(int seat) {
        this.seat = seat;       //Sets the seat number.
    }

    public double getPrice() {
        return price;           //Return the price of the ticket.
    }
    public void setPrice(double price) {
        this.price = price;     //Sets the price of the ticket.
    }

    public Person getPerson() {
        return person;          //Return the person associated with the ticket.
    }
    public void setPerson(Person person) {
        this.person = person;   //Sets the person associated with the ticket.
    }

    /**
     * Display the ticket information with the person information.
     */
    public void printTicketInfo(){
        System.out.println();
        System.out.println("*** Person Information ***");
        person.printPersonInfo();
        System.out.println("*** Ticket Information ***");
        System.out.println("Seat number: "+ row + seat);
        System.out.println("Price      : £" + price);
    }

    /**
     * Saves the ticket information to a file.
     */
    public void save(){
        String fileName = row + seat + ".txt" ;  //Constructed the file name
        try {
            FileWriter file = new FileWriter(fileName);
            file.write("*** Person Information ***\n");
            file.write("Name         : " + person.getName() + "\n");
            file.write("Surname      : " + person.getSurname() + "\n");
            file.write("Email address: " + person.getEmail() + "\n");
            file.write("*** Ticket Information ***\n");
            file.write("Seat number  : "+ row + seat + "\n");
            file.write("Price        : £" + price+ "\n");
            file.close();
        }
        catch (IOException e){
            System.out.println("Error while writing in the file.");
        }
    }

    /**
     * Delete the file associated with the ticket.
     *
     * @param row The seat row letter
     * @param seat The seat number
     */
    public static void deleteFile(String row, int seat){
        String fileName = row + seat + ".txt" ;
        File fileToDelete = new File(fileName);
        if (fileToDelete.exists()){
            fileToDelete.delete();
        }
        else {
            System.out.println(fileName + "File failed to delete");
        }
    }

}
