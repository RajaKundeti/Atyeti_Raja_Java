package library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {

    public static List<User> readUsers(String filePath) throws FileNotFoundException {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine())!= null){
                String[] userData = line.split(",");
                User user = new User();
                user.setUserId(Integer.parseInt(userData[0]));
                user.setUserName(userData[1]);
                user.setPassword(userData[2]);
                user.setNoOfBooksBorrowed(Integer.parseInt(userData[3]));
                users.add(user);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public static List<Book> readBooks(String filePath) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine())!= null){
                String[] userData = line.split(",");
                Book book = new Book();
                book.setId(Integer.parseInt(userData[0]));
                book.setName(userData[1]);
                book.setAuthor(userData[2]);
                book.setPrice(Double.parseDouble(userData[3]));
                book.setStock(Integer.parseInt(userData[4]));
                books.add(book);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public static void saveUser(User user, String usersData) throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(usersData,true))){
            String userdata = "\n"+user.getUserId()+", "+user.getUserName()+", "+user.getPassword()+", "+user.getNoOfBooksBorrowed();
            bw.write(userdata);
        }
    }
}
