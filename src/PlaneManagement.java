import java.util.InputMismatchException;
import java.util.Scanner;

public class PlaneManagement {
    private static int[][] seats = new int[4][];   //2D array to represent plane seats
    private static Ticket[] soldTickets = new Ticket[52]; //Array to hold references of Ticket objects

    public static void main(String[] args) {
        System.out.println();  //Display welcome message
        System.out.println("*  Welcome to the Plane Management application  *");

        allAvailable(); //Initializing all seats as available (0)

        int option = -1;    //Initialize option before entering the loop
        while (option != 0) {  //Handle user input till user chose to quit(0)
            try{
                displayMenu(); //Display menu option
                option = menuOption();  //Get user input for menu option
                switch (option) {
                    case 1:
                        System.out.println();
                        System.out.println("*** 1) Buy a seat ***");
                        buy_seat();
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("*** 2) Cancel a seat ***");
                        cancel_seat();
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("*** 3) Find first available seat ***");
                        find_first_available ();
                        break;
                    case 4:
                        System.out.println();
                        System.out.println("*** 4) Show seating plan ***");
                        show_seating_plan();
                        break;
                    case 5:
                        System.out.println();
                        System.out.println("*** 5) Print tickets information and total sales ***");
                        print_tickets_info();
                        break;
                    case 6:
                        System.out.println();
                        System.out.println("*** 6) Search ticket ***");
                        search_ticket();
                        break;
                    case 0:
                        System.out.println();
                        System.out.println("Thank you for using the Plane Management application.");
                        System.out.println("Have a nice day.");
                        System.out.println("**** Quit ****");
                        break;
                    default:
                        System.out.println();
                        System.out.println("Invalid option.");
                        break;
                }
            }
            catch(InputMismatchException e){   //Handle if user input is not an integer
                System.out.println("Need an integer.");
                option = -1; //Reset option
            }
        }
    }

    /**
    * Initializing all seats as available (0).
    * Seats represented by a 2D array.
    */
    private static void allAvailable(){

        //Initializing seat array for each section
        seats[0] = new int[14];
        seats[1] = new int[12];
        seats[2] = new int[12];
        seats[3] = new int[14];

        for (int i = 0; i < 4; i++){
            for (int j = 0; j< seats[i].length; j++){
                seats[i][j] = 0;
            }
        }
    }

    /**
    * Display the menu option for the Plane Management Application.
    */
    private static void displayMenu(){
        System.out.println();
        System.out.println("**************************************************");
        System.out.println("*                  MENU OPTIONS                  *");
        System.out.println("**************************************************");
        System.out.println("     1) Buy a seat ");
        System.out.println("     2) Cancel a seat ");
        System.out.println("     3) Find first available seat ");
        System.out.println("     4) Show seating plan ");
        System.out.println("     5) Print ticket information and total sales ");
        System.out.println("     6) Search ticket ");
        System.out.println("     0) Quit ");
        System.out.println("**************************************************");
    }

    /**
     * Prompts the user to select an option from the menu and returns that option.
     *
     * @return The selected menu option.
     */
    private static int menuOption(){
        System.out.println();
        Scanner obj1 = new Scanner(System.in);
        System.out.print("Please select an option: ");
        int option = obj1.nextInt();
        return option;
    }

    /**
     * Prompt the user to enter a valid seat by entering a row letter and a seat number.
     * Validate the input row and seat number, considering the valid range.
     * If input is invalid, prompts the user to try again using recursion.
     *
     * @return validSeat array containing rowNum(row number) and seatNum(seat number)
     */
    private static int[] seatValidCheck(){
        int[] validSeat = new int[2];

        Scanner obj2 = new Scanner(System.in);
        System.out.print("Enter the row letter (A, B, C, D): ");
        String row = obj2.nextLine().toUpperCase();

        //Getting the row number
        int rowNum = -1;   //Initialize
        switch (row) {
            case "A":
                rowNum = 0;
                validSeat[0]=0;
                break;
            case "B":
                rowNum = 1;
                validSeat[0]=1;
                break;
            case "C":
                rowNum = 2;
                validSeat[0]=2;
                break;
            case "D":
                rowNum = 3;
                validSeat[0]=3;
                break;
            default:
                System.out.println("Invalid row letter. Please try again.");
                return seatValidCheck();    //Recursion to check the seat validation again
        }

        int seatNum = -1;
        boolean validInput = true;
        while (validInput){
            System.out.print("Enter the seat number: ");
            if (obj2.hasNextInt()){
                seatNum = obj2.nextInt();
                if (seatNum < 1 || seatNum > seats[rowNum].length ){   //Validating the range of the seat number
                    System.out.println("Invalid seat number. Please try again.");
                }
                else {
                    validInput = false;
                }
            }
            else {
                System.out.println("Invalid input. Please enter an integer.");
                obj2.next();   //Consume invalid input
            }
        }
        validSeat[1] = seatNum;
        return validSeat;   //Return validSeat=[rowNum,seatNum]
    }

    /**
     * Converts the integer representation of the row number into its corresponding letter representation.
     *
     * @param rowNum The integer representation of the row number
     * @return row The corresponding letter of the row number
     * */
    private static String gettingRow (int rowNum){
        String row;
        switch (rowNum) {
            case 0:
                row = "A";
                break;
            case 1:
                row = "B";
                break;
            case 2:
                row = "C";
                break;
            default:
                row = "D";
                break;
        } return row;
    }

    /**
     * Return the corresponding price based on the seat number.
     *
     * @param seatNum The seat number for which the price to be determined
     * @return price The corresponding seat price
     */
    private static double returnSeatPrice(int seatNum){
        double price;
        if (seatNum >= 1 && seatNum <= 5){
            price = 200;
        }
        else if (seatNum >=6 && seatNum <=9) {
            price = 150;
        }
        else if (seatNum >= 10 && seatNum <= 14) {
            price = 180;
        }
        else {
            price = 0;
        }
        return price;
    }

    /**
     * Allow the user to buy a seat on the plane using rowNum and seatNum.
     * Prompts and validate the user inputs: name, surname, email.
     * Get the price of the seat and create Ticket object and save it in soldTickets array.
     * Save all the information in a text file and update the seating plan.
     */
    private static void buy_seat(){
        int[] validSeat = seatValidCheck();   //check seat validation
        int rowNum = validSeat[0];
        int seatNum = validSeat[1];
        String row = gettingRow(rowNum); //getting the row letter

        if (seats[rowNum][seatNum-1] ==1 ) {   //check the entered seat is available
            System.out.println("Seat " + row + seatNum + " is already sold. Please try another seat.");
            buy_seat();
            return;
        }                                          //seatNum is the real seat num. so -1
        else{
            Scanner obj1 = new Scanner(System.in);
            String name = "";
            String surname = "";
            String email = "";

            while (name.isEmpty()){
                System.out.print("Enter your Name: ");
                name = obj1.nextLine();
                if (name.isEmpty()){
                    System.out.println("Name field cannot be empty.");
                }
            }
            while (surname.isEmpty()){
                System.out.print("Enter your Surname: ");
                surname = obj1.nextLine();
                if (surname.isEmpty()){
                    System.out.println("Surname field cannot be empty.");
                }
            }
            while (!email.contains("@") || !email.contains(".")){
                System.out.print("Enter your Email address: ");
                email = obj1.nextLine();
                if (!email.contains("@") || !email.contains(".")){
                    System.out.println("Invalid Email address.");
                }
            }

            Person person = new Person(name, surname, email);

            double price = returnSeatPrice(seatNum); //getting the seat price
            Ticket ticket = new Ticket(row, seatNum, price, person);
            soldTickets[seatNum-1] = ticket; //saving the sold ticket in the array

            ticket.save(); //save ticket info in to a text file

            seats[rowNum][seatNum-1] = 1;   //marking the seat as not available
            System.out.println("Seat " + row + seatNum + " has been successfully sold.");
        }
    }

    /**
     * Allows a user to cancel a previously purchased seat.
     * Get the validated row and seat number and check the seat is currently occupied.
     * If it is occupied, mark the seat as available and delete the ticket file.
     */
    private static void cancel_seat(){
        int[] validSeat = seatValidCheck();
        int rowNum = validSeat[0];
        int seatNum = validSeat[1];
        String row = gettingRow(rowNum);

        if (seats[rowNum][seatNum-1] == 0) {
            System.out.println("Seat " + row + seatNum + " is already available.");
        } else {
            soldTickets[seatNum-1] = null;  //Make the stored ticket a null
            seats[rowNum][seatNum-1] = 0;   //Mark the seat as available
            Ticket.deleteFile(row, seatNum);  //Delete the saved ticket file
            System.out.println("Seat " + row + seatNum + " has been successfully cancelled.");
        }
    }

    /**
     * Finds and displays the first available seat on the plane.
     * If no available seats are found, display a message indicating no available seats.
     */
    private static void find_first_available () {
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < seats[i].length; j++ ){
                if (seats[i][j] == 0){
                    String row = gettingRow(i);
                    System.out.println(row + (j+1) + " is the first available seat.");
                    return;  //return after printing one seat
                }
            }
        }
        System.out.println("Sorry, no available seats found.");
    }

    /**
     * Display the current seating plan.
     * Mark occupied seats with an 'X' and unoccupied seats with an 'O'.
     */
    private static void show_seating_plan() {
        System.out.println("1  2  3  4  5  6  7  8  9  10 11 12 13 14");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    System.out.print("O  ");
                } else {
                    System.out.print("X  ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints details of all sold tickets.
     * Prints the total price of sold tickets.
     */
    private static void print_tickets_info(){
        double totalPrice = 0;

        for(Ticket ticket : soldTickets){
            if (ticket != null){
                ticket.printTicketInfo();
                System.out.println(" ");
                totalPrice +=ticket.getPrice();
            }
        }
        System.out.println("Total sales: £" + totalPrice);
    }

    /**
     * Searches for a ticket based on the seat chosen by the user.
     * Get the validated rowNum and seatNum and check the seat is sold.
     * If sold, display ticket information.
     * If not, display a message saying the seat is available.
     */
    private static void search_ticket(){
        int[] validSeat = seatValidCheck();
        int rowNum = validSeat[0];
        int seatNum = validSeat[1];
        String row = gettingRow(rowNum);

        if (seats[rowNum][seatNum-1] == 1){
            Ticket ticket = soldTickets[seatNum-1];
            ticket.printTicketInfo();
        }
        else {
            System.out.println("The seat " + row + seatNum + " is available.");
        }
    }
}
