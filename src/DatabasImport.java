import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class DatabasImport {

    public static void main(String[] args) {
        try {
            // Set up connection to database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://" + DatabaseLoginData.localhost + ":" + DatabaseLoginData.1234 + "/" +
                    DatabaseLoginData.te18 + "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    DatabaseLoginData.iamtoast, DatabaseLoginData.bananpurre);
        }
    }
}
