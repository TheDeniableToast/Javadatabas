import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class DatabasImport {

    public static void main(String[] args) {
        try {
            // Set up connection to database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://" + DatabaseLoginData.DBURL + ":" + DatabaseLoginData.DBPORT + "/" +
                    DatabaseLoginData.DBNAME + "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    DatabaseLoginData.DBUSER, DatabaseLoginData.DBPASSWORD);

        // Setup statement
        Statement stmt = conn.createStatement();
        Scanner tgb = new Scanner(System.in);
        int currentRoom = 1;

        while (currentRoom != 0) {
            // Create query and execute
            String strSelect = "select body from story where id = " + currentRoom;

            ResultSet rset = stmt.executeQuery(strSelect);

            // Loop through the result set and print
            while (rset.next()) {
                String body = rset.getString("body");
                System.out.println(body);
            }

            strSelect = "select description, targetId from links where storyId = " + currentRoom;

            rset = stmt.executeQuery(strSelect);
            ArrayList<Integer> storyLinks = new ArrayList();

            // Loop through the result set and print
            int rowCount = 0;
            while (rset.next()) {
                String description = rset.getString("description");
                int storyLink = rset.getInt("targetId");
                storyLinks.add(storyLink);
                System.out.println(++rowCount + " " + description);
            }

            if (rowCount == 0) {
                System.out.println("Thanks for playing...");
                currentRoom = 0;
            } else {
                System.out.println("Make your choice: ");
                int input = tgb.nextInt();
                while (input < 1 || input > storyLinks.size()) {
                    System.out.println("Illegal choice, try again");
                    input = tgb.nextInt();
                }
                currentRoom = storyLinks.get(input - 1);
            }
        }
        // Close conn and stmt
        conn.close();
        stmt.close();
    } catch(SQLException ex) {
        ex.printStackTrace();
    }
}
}
