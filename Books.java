import java.sql.*;
import java.util.Scanner;

public class Books {

    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        try {
        	// Use username "root", password "Phumuboi1996".
        	// We will be connecting with the database.
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/ebookstore",
                    "root",
                    "Phumuboi1996");
            
            // Create a direct line to the database for running our queries.
            Statement statement = connection.createStatement();
            ResultSet results;
            int rowsAffected;
            
            // We are welcoming the user and asking them to choose from the given option.
            System.out.println(
                    "Welcome. Choose a number for the following\n 1.Enter book\n 2.Update book\n 3.Delete book\n" +
                            " 4.Search book\n 0.Exit");
            int choice = scanner.nextInt();

            // When  one of these option is selected, the following will happen
            if (choice == 1) {
            	// adding a new book
                System.out.println("Please enter the book id: ");
				int id1 = scanner.nextInt();
				Scanner scanner1 = new Scanner(System.in);
				System.out.println("Please eneter the name of the book: ");
				String title1 = scanner1.nextLine();
				Scanner scanner2 = new Scanner(System.in);
				System.out.println("Please eneter the book's author: ");
				String author1 = scanner2.nextLine();
				Scanner scanner3 = new Scanner(System.in);
				System.out.println("Please enter the qty of the books");
				int qty1 = scanner3.nextInt();

                String sql = "INSERT INTO books" + "(id, title, author, qty)" + "VALUES (?, ?, ?, ?)";
                PreparedStatement myStmt = connection.prepareStatement(sql);
                myStmt.setInt(1, id1);
                myStmt.setString(2, title1);
                myStmt.setString(3, author1);
                myStmt.setInt(4, qty1);
                myStmt.executeUpdate();
                printAllFromTable(myStmt);

            } else if (choice == 2) {
            	// updating the books
            	Scanner scanner4 = new Scanner(System.in);
                System.out.println("Please enter the book id: ");
				int id1 = scanner4.nextInt();
				Scanner scanner5 = new Scanner(System.in);
				System.out.println("Please enter the qty of the books");
				int qty1 = scanner5.nextInt();

                String sql = "UPDATE books SET qty=? WHERE id=?";
                PreparedStatement myStmt = connection.prepareStatement(sql);
                myStmt.setInt(1, id1);
                myStmt.setInt(2, qty1);
                myStmt.executeUpdate();
                printAllFromTable(myStmt);

            } else if (choice == 3) {
            	// deleting the a book
            	Scanner scanner6 = new Scanner(System.in);
                System.out.println("Please enter the book id: ");
				int id1 = scanner6.nextInt();

                String sql = "DELETE FROM books WHERE id= ?";
                PreparedStatement myStmt = connection.prepareStatement(sql);
                myStmt.setInt(1, id1);
                myStmt.executeUpdate();
                printAllFromTable(myStmt);

            } else if (choice == 4) {
            	// searching for the books
            	results = statement.executeQuery("SELECT title, qty FROM books");
            			// Loop over the results, printing them all.
            	while (results.next()) {
            		System.out.println(results.getString("title") + ", " +results.getInt("qty"));
            		}

            } else if (choice == 0) {
            	// existing the program
                System.out.println("Goodbye!!");
            }
            // closing all our connections
            statement.close();
            connection.close();
              
        } catch (SQLException e) {
        	// We want to catch a SQLException 
            e.printStackTrace();
        
        }
        
    }

    // this will print out the database table created in SQL
    public static void printAllFromTable(Statement statement) throws SQLException {
        ResultSet results = statement.executeQuery("SELECT id, title,author, qty FROM books");
        while (results.next()) {
            System.out.println(results.getInt("id") + ", " + results.getString("title") + ", "
                    + results.getString("author") + ", " + results.getInt("qty"));
        }
    }
}

