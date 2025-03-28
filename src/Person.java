public class Person {
    private String name;
    private String surname;
    private String email;

    /**
     * Constructs a new Person object with the specified name, surname, and email.
     *
     * @param name The name of the person
     * @param surname The surname of the person
     * @param email The email address of the person
     */
    public Person(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName(){
        return name;              //Return the name of the person.
    }
    public void setName(String name){
        this.name = name;         //Sets the name of the person.
    }

    public String getSurname(){
        return surname;           //Returns the surname of the person.
    }
    public void setSurname(String surname) {
        this.surname = surname;   //Sets the surname of the person.
    }

    public String getEmail() {
        return email;             //Returns the email address of the person.
    }
    public void setEmail(String email) {
        this.email = email;       //Sets the email address of the person.
    }

    /**
     * Display the person's information.
     */
    public void printPersonInfo(){
        System.out.println("Name       : "+ name);
        System.out.println("Surname    : "+ surname);
        System.out.println("Email      : "+ email);
    }
}
