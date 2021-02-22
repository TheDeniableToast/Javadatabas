import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class DatabasImport {
    Connection conn;
    Statement stmt;

    public DatabasImport() {
        try {
            // Set up connection to database
            conn = DriverManager.getConnection(
                    "jdbc:mysql://" + DatabaseLoginData.DBURL + ":" + DatabaseLoginData.DBPORT + "/" +
                            DatabaseLoginData.DBNAME + "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    DatabaseLoginData.DBUSER, DatabaseLoginData.DBPASSWORD);

            // Setup statement
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String getBodyfromID(int scene) {
        String strSelect = "select body from story where id = " + scene;

        ResultSet rset = null;
        try {
            rset = stmt.executeQuery(strSelect);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Loop through the result set and print
        try {
            rset.next();
            return rset.getString("body");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getDescriptionfromStoryId(int choices) {
        String lnkSelect = "select description from links where story_id = " + choices;

        ResultSet rset = null;
        try {
            rset = stmt.executeQuery(lnkSelect);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rset.next();
            return rset.getString("description");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*}
        Scanner tgb = new Scanner(System.in);
            int currentRoom = 1;

            while (currentRoom != 0) {
                // Create query and execute

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
        }
    }*/
}
