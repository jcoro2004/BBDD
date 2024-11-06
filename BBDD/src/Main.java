public class Main {
    public static void main(String[] args) {
        Connected conn = new Connected("postgres", "1234", "port");
        conn.connect();
    }
}