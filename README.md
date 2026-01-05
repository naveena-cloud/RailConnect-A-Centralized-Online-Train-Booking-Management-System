# RailConnect: A Centralized Online Train Booking Management System

## Overview
RailConnect is a centralized online train booking management system designed to automate the process of booking, updating, viewing, and canceling train reservations. The system replaces manual booking procedures with a reliable, database-driven solution.

## Objectives
- Automate train ticket booking operations  
- Reduce manual paperwork and queue-based booking  
- Enable booking creation, update, cancellation, and viewing  
- Maintain booking records securely using a database  

## Technologies Used
- Programming Language: Java  
- Database: MySQL  
- Database Connectivity: JDBC  
- IDE: Eclipse / NetBeans / IntelliJ IDEA  

## Database
- Database Name: bookingdb  
- Table: bookings

## Application Workflow
1. User selects an option from the menu
2. System performs database operation using JDBC
3. Data is stored/retrieved from MySQL
4. Result is displayed in console

## Features
- Book train tickets  
- Update booking slot  
- Cancel booking  
- View all bookings  
- Auto-generated Booking ID  

## How to Run
1. Create database using `Database_Schema.sql`
2. Update database credentials in `BookingApp.java`
3. Compile and run the Java application
4. Use the menu-driven interface to manage bookings

## Data Integrity & Security
- Uses prepared statements to prevent SQL injection
- Auto-increment booking IDs ensure uniqueness
- Centralized database for consistency

## Future Enhancements
- Online payment integration  
- Seat allocation system  
- Train route management  
- User authentication (Admin / Passenger)
- Web-based or GUI version

## Author
Developed as an academic mini-project using Java and MySQL.
