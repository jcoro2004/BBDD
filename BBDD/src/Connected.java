import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connected {
    public String name;
    public String password;
    public String database;

    public Connected(String name, String password, String database) {
        this.name = name;
        this.password = password;
        this.database = database;
    }

    public Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/" + this.database;
            conn = DriverManager.getConnection(url, this.name, this.password);
            System.out.println("Conexión exitosa a la base de datos PostgreSQL");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}