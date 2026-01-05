import java.sql.*;
import java.util.Scanner;

public class BookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/bookingdb";
        String root = "root";
        String password = "18@Ka21rt";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, root, password);
            Statement stmt = conn.createStatement();

            while (true) {
                System.out.println("\n=== Train Online Booking System ===");
                System.out.println("1. Book Train Ticket");
                System.out.println("2. Update Booking Slot");
                System.out.println("3. Cancel Booking");
                System.out.println("4. View All Bookings");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter passenger name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter travel date (YYYY-MM-DD): ");
                        String date = sc.nextLine();
                        System.out.print("Enter train slot (e.g. Morning, Evening): ");
                        String slot = sc.nextLine();

                        String insertQuery = "INSERT INTO bookings (name, date, slot) VALUES (?, ?, ?)";
                        PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                        insertStmt.setString(1, name);
                        insertStmt.setString(2, date);
                        insertStmt.setString(3, slot);
                        insertStmt.executeUpdate();
                        System.out.println("Train ticket booked successfully.");
                        break;

                    case 2:
                        System.out.print("Enter booking ID to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new train slot: ");
                        String newSlot = sc.nextLine();

                        String updateQuery = "UPDATE bookings SET slot = ? WHERE id = ?";
                        PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                        updateStmt.setString(1, newSlot);
                        updateStmt.setInt(2, updateId);
                        int updated = updateStmt.executeUpdate();
                        if (updated > 0)
                            System.out.println("Booking updated successfully.");
                        else
                            System.out.println("Booking ID not found.");
                        break;

                    case 3:
                        System.out.print("Enter booking ID to cancel: ");
                        int deleteId = sc.nextInt();
                        sc.nextLine();

                        String deleteQuery = "DELETE FROM bookings WHERE id = ?";
                        PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
                        deleteStmt.setInt(1, deleteId);
                        int deleted = deleteStmt.executeUpdate();
                        if (deleted > 0)
                            System.out.println("Booking cancelled successfully.");
                        else
                            System.out.println("Booking ID not found.");
                        break;

                    case 4:
                        ResultSet rs = stmt.executeQuery("SELECT * FROM bookings");
                        System.out.println("\n--- All Train Bookings ---");
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id") +
                                               ", Name: " + rs.getString("name") +
                                               ", Travel Date: " + rs.getString("date") +
                                               ", Slot: " + rs.getString("slot"));
                        }
                        break;

                    case 5:
                        System.out.println("Exiting Train Booking System...");
                        conn.close();
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
