import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager dbManager = new DatabaseManager("postgres", "1234", "Clients");

        int option;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Afegir Client");
            System.out.println("2. Llistar Clients");
            System.out.println("3. Actualitzar Client");
            System.out.println("4. Eliminar Client");
            System.out.println("0. Sortir");
            System.out.print("Escull una opció: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nom del client: ");
                    String nom = scanner.nextLine();
                    System.out.print("Cognom del client: ");
                    String cognom = scanner.nextLine();
                    System.out.print("Correu del client: ");
                    String correu = scanner.nextLine();
                    dbManager.addClient(nom, cognom, correu);
                    break;
                case 2:
                    dbManager.listClients();
                    break;
                case 3:
                    System.out.print("ID del client: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nou nom del client: ");
                    String newNom = scanner.nextLine();
                    System.out.print("Nou cognom del client: ");
                    String newCognom = scanner.nextLine();
                    System.out.print("Nou correu del client: ");
                    String newCorreu = scanner.nextLine();
                    dbManager.updateClient(idUpdate, newNom, newCognom, newCorreu);
                    break;
                case 4:
                    System.out.print("ID del client a eliminar: ");
                    int idDelete = scanner.nextInt();
                    dbManager.deleteClient(idDelete);
                    break;
                case 0:
                    System.out.println("Sortint del programa.");
                    break;
                default:
                    System.out.println("Opció no vàlida. Intenta-ho de nou.");
            }
        } while (option != 0);

        scanner.close();
    }
}