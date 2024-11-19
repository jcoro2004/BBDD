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
            System.out.println("Client afegit correctament");
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

    public void updateClient(int id, String nom, String cognom, String correu) {
        String sql = "UPDATE clients SET nom = ?, cognom = ?, correu = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            pstmt.setString(2, cognom);
            pstmt.setString(3, correu);
            pstmt.setInt(4, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Client actualitzat");
            } else {
                System.out.println("Client existent");
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void deleteClient(int id) {
        String sql = "DELETE FROM clients WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Client eliminat");
            } else {
                System.out.println("Error eliminar client");
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
