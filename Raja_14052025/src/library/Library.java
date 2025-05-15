package library;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    static Scanner sc = new Scanner(System.in);
    static List<User> users = new ArrayList<>();
    static List<Book> books = new ArrayList<>();
    static final String usersData = "C:\\Users\\RajaNarasimhanKundet\\OneDrive - Atyeti Inc\\Desktop\\Self\\JavaPOC\\Raja_14052025\\src\\library\\userdata.txt";
    static final String booksData = "C:\\Users\\RajaNarasimhanKundet\\OneDrive - Atyeti Inc\\Desktop\\Self\\JavaPOC\\Raja_14052025\\src\\library\\bookdata.txt";

    public static void main(String[] args) throws IOException {

        //  GET USERS FROM FILE
        users = FileUtility.readUsers(usersData);

        //  GET BOOKS FROM FILE
        books = FileUtility.readBooks(booksData);

        //  SHOW HOME
        showHome();

    }

    private static void showHome() throws IOException {
        while(true){
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your option: ");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    User user;
                    if((user = userLogin())!=null) showMenu(user);
                    else System.out.println("Invalid credentials!");
                    break;
                case 2:
                    registerUser();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void showMenu(User user) {

        while(true){
            System.out.println("1. Show Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your option: ");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    showBooks();
                    break;
                case 2:
                    borrowBook(user);
                    break;
                case 3:
                    returnBook(user);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void returnBook(User user) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        Book book = getBookById(id);
        user.setNoOfBooksBorrowed(user.getNoOfBooksBorrowed()+1);
        book.setStock(book.getStock()+1);
        updateUsers(user);
        updateBooks(book);
        System.out.println("Returned Successfully");
    }

    private static void borrowBook(User user) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        Book book = getBookById(id);
        if(user.getNoOfBooksBorrowed() < 3 && book.getStock()>0){
            user.setNoOfBooksBorrowed(user.getNoOfBooksBorrowed()+1);
            book.setStock(book.getStock()-1);
            updateUsers(user);
            updateBooks(book);
            System.out.println("Borrowed Successfully");
        }
    }

    private static void updateBooks(Book book) {
        for(Book b: books){
            if(b.getId()==book.getId()){
                b = book;
                break;
            }
        }
    }

    private static void updateUsers(User user) {
        for(User u: users){
            if(u.getUserId()==user.getUserId()){
                u = user;
                break;
            }
        }
    }

    private static Book getBookById(int id) {
        Book book = null;
        for(Book b: books){
            if(b.getId()==id){
                book = b;
                break;
            }
        }
        return book;
    }

    private static void showBooks() {
        for (Book book: books){
            System.out.println(book);
        }
    }

    private static void registerUser() throws IOException {
        System.out.print("Enter your Name: ");
        String name = sc.nextLine();
        name = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        if(checkUser(name, password)!= null){
            System.out.println("User already exist!");
        }
        else{
            users.add(new User(users.getLast().getUserId()+1, name,password,0));
            FileUtility.saveUser(users.getLast(),usersData);
            System.out.println("Registration Success");
        }
    }

    private static User userLogin() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        name = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        User user;
        if((user = checkUser(name,password)) != null) return user;
        else return null;
    }

    private static User checkUser(String name, String password) {
        User user = null;
        for(User u: users){
            if(u.getUserName().equals(name) && u.getPassword().equals(password)) {
                user = u;
                break;
            }
        }
        return user;
    }

}
