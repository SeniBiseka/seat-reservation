# Plane Seat Management Application

## Description

The Plane Management application allows users to manage plane seat reservations. The application provides various functionalities such as purchasing seats, canceling bookings, viewing seating plans, searching for tickets, and printing ticket information. 

The seating is organized in rows, with each row having a specific number of seats. The application provides an interactive interface for users to perform these operations.

## Features

- **Buy a Seat**: Users can purchase available seats by entering their personal details and choosing a seat. The seat gets marked as sold.
- **Cancel a Seat**: Users can cancel a previously purchased seat, marking it as available.
- **Find First Available Seat**: The application allows users to find the first available seat in the plane.
- **Show Seating Plan**: Displays the seating arrangement, where available seats are represented by 'O' and sold seats are represented by 'X'.
- **Print Tickets Information and Total Sales**: Prints details of all sold tickets and the total sales value.
- **Search Ticket**: Allows users to search for a ticket by seat number and displays the ticket details if sold.

## Classes

- **PlaneManagement**: The main class for handling the seat management logic, including buying, canceling, and searching tickets, and displaying the seating plan.
- **Person**: Represents the person who purchases the ticket, storing their name, surname, and email address.
- **Ticket**: Represents a ticket with seat information (row, seat number), the associated price, and the person who purchased it. It includes methods to save ticket data to a text file and print ticket details.

## How It Works

1. **Main Menu**: On running the application, a menu is displayed with several options. The user can select an option to perform actions like buying a seat, canceling a seat, or printing ticket details.
2. **Seat Validation**: When a user selects to buy or cancel a seat, the application prompts the user to enter a valid seat number. The seat selection is validated to ensure the seat exists and is available for booking.
3. **Ticket Information**: When a seat is bought or canceled, the application updates the seat availability and stores the relevant information in the system, including saving ticket details to a text file.
4. **Seating Plan**: The current seating plan can be displayed at any time, showing the status of all seats.

## How to Run

1. **Compile the Program**: 
   To compile the program, navigate to the directory containing the files and run the following command in the terminal:
   ```bash
   javac PlaneManagement.java Person.java Ticket.java
2. **Run the Application**: 
   To run the application, execute the compiled PlaneManagement class:
   ```bash
   java PlaneManagement
