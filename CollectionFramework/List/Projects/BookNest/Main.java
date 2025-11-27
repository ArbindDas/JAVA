package CollectionFramework.List.Projects.BookNest;

public class Main {
    public static void main(String[] args){


        Library library = new Library();

        library.addBook(new Book(1 , "JAVA", "James Gosling" ,false));
        library.addBook(new Book(2  , "C++" , "Bjarne Stroustrup" , true));
        library.addBook(new Book(3 , "javascript", "Brendan Eich" , true));

        library.RegisterUser(new User(1 , "Arvind Das"));
        library.RegisterUser(new User(2 , "Suraj Gupta"));


        library.displayBook();


        library.issuedBook(1 , 1);

        // Check availability
       System.out.println("Is Book 2 available? " + library.isBookAvailable(1));


        library.displayBook();


        library.returnBook(1 , 1);

        library.displayBook();



    }
}
