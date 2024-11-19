import java.sql.*;
import java.util.Scanner;

public class DatabaseManager extends Connected {

    public DatabaseManager(String name, String password, String database) {
        super(name, password, database);
    }

    public void addClient(String nom, String cognom, String correu) {
        String sql = "INSERT INTO clients (nom, cognom, correu) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            pstmt.setString(2, cognom);
            pstmt.setString(3, correu);
            pstmt.executeUpdate();
            System.out.println("Client afegit correctament: " + nom + " " + cognom);
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }


    public void listClients() {
        String sql = "SELECT * FROM clients";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Nom: " + rs.getString("nom") +
                        ", Cognom: " + rs.getString("cognom") +
                        ", Correu: " + rs.getString("correu"));
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }


}
