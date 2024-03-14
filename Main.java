import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Book[] bookList;
    private List<Student> userStudent;
    private Scanner scanner;

    public Main() {
        scanner = new Scanner(System.in);

        // Inisialisasi daftar buku
        bookList = new Book[]{
                new Book("388c-e681-9152", "Foxit eSign", "Accessibility", "Author1", 1),
                new Book("d95e-8c4-9523", "Nana Buku", "Category", "Author2", 2),
                new Book("Sejarah1", "Sejarah", "Sejarah", "Author3", 8),
                new Book("Sejarah2", "Sejarah", "Sejarah", "Author3", 8)
        };

        // Inisialisasi daftar user student
        userStudent = new ArrayList<>();
        userStudent.add(new Student("Taufiq Ramadhan", "282210378311288", "Teknik", "Informatika"));
        userStudent.add(new Student("Who", "200510370310521", "Teknik", "Informatika"));
        userStudent.add(new Student("Sutrisno Adit Pratama", "282210378311283", "Teknik", "Informatika"));
    }

    public void menu() {
        int choice;
        do {
            System.out.println("Library System");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit");
            System.out.println("Choose option: ");
            choice = readIntegerInput();

            switch (choice) {
                case 1:
                    menuAdmin();
                    break;
                case 2:
                    inputNim();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 3);
    }

    public int readIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // consume the invalid input
        }
        return scanner.nextInt();
    }

    public void inputNim() {
        System.out.println("Enter your NIM: ");
        scanner.nextLine(); // consume the newline character
        String nim = scanner.nextLine();
        checkNim(nim);
    }

    public void checkNim(String nim) {
        boolean found = false;
        for (Student student : userStudent) {
            if (student.getNim().equals(nim)) {
                found = true;
                student.menuStudent();
                break;
            }
        }
        if (!found) {
            System.out.println("Student with NIM " + nim + " not found.");
        }
    }

    public void menuAdmin() {
        int choice;
        do {
            System.out.println("Admin Menu");
            System.out.println("1. Add Student");
            System.out.println("2. Display Registered Students");
            System.out.println("3. Logout");
            System.out.println("Choose option: ");
            choice = readIntegerInput();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    System.out.println("Logging out from admin account...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 3);
    }

    public void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter NIM: ");
        String nim;
        do {
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("Invalid NIM format. NIM should have 15 characters.");
                System.out.print("Enter NIM again: ");
            }
        } while (nim.length() != 15);

        System.out.print("Enter faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter study program: ");
        String studyProgram = scanner.nextLine();

        userStudent.add(new Student(name, nim, faculty, studyProgram));
    }

    public void displayStudent() {
        System.out.println("Registered Students:");
        for (Student student : userStudent) {
            System.out.println(student.getName() + " (" + student.getNim() + ")");
        }
    }

    public static void main(String[] args) {
        Main library = new Main();
        library.menu();
    }
}
