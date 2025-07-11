package CollectionFramework.List.Projects.BookNest;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map <Integer , Book> books; // map book ID to book
    private Map<Integer , User>users; // map user ID to user



    public Library(){
       books =new HashMap <>();
       users = new HashMap <>();
    }

    // add book to library
    public void addBook(Book book){
        books.put(book.getId() , book);
    }

    // Register a new user
    public void RegisterUser(User user){
       users.put(user.getId() , user);
    }

    // Check if a book is available
    public boolean isBookAvailable(Integer bookID){
        Book  book = books.get(bookID);
        return book!=null && !book.isIssued();
    }

    // Issue book to user
    public boolean issuedBook(Integer bookID , Integer userID){
        Book book = books.get(bookID);
        User user = users.get(userID);

        if (book==null){
            System.out.println("Book not found.");
            return false;
        }

        if (user==null){
            System.out.println("User not found");
            return  false;
        }

        if (book.isIssued()){
            System.out.println("book is already issued");
            return false;
        }

        book.setIssued(true);
        user.issuedBook(book);
        System.out.println("Book issued successfully.");
        return true;
    }

    // Return book from user
    public boolean returnBook(Integer bookID , int userID){
        Book book = books.get(bookID);
        User user =  users.get(userID);

        if (book == null || user == null){
            System.out.println("Book or User not found.");
            return false;
        }
        if (!book.isIssued()){
            System.out.println("Book was not issued.");
            return false;
        }

        book.setIssued(false);
        user.removedBook(book);
        System.out.println("Book returned successfully.");
        return true;
    }

    // Display all books
    public void displayBook(){
        for(Book book  : books.values()){
            String status = book.isIssued() ? "issued" : "Available";
            System.out.println(STR."\{book.getId()}: \{book.getTitle()} by \{book.getAuthor()} - \{status}");
        }
    }



}
