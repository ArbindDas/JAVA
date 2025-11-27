package CollectionFramework.List.Projects.BookNest;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer id;
    private String name;
    private List <Book> issuedBooks = new ArrayList <>();

    public User(Integer id , String name , List < Book > issuedBooks){
        this.id=id;
        this.name=name;
        this.issuedBooks=issuedBooks;
    }



    public List < Book > getIssuedBooks(){
        return issuedBooks;
    }

    public void setIssuedBooks(List < Book > issuedBooks){
        this.issuedBooks=issuedBooks;
    }

    public User(Integer id , String name){
        this.id=id;
        this.name=name;
    }

    public User(){}

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }


    public void issuedBook(Book book){
        issuedBooks.add(book);
    }

    public void removedBook(Book book){
        issuedBooks.remove(book);
    }

   
    @Override
    public String toString(){
        return "User{id="+ id + ", name  = '" + name + "issuedBook=" + issuedBooks+"}";
    }


}
