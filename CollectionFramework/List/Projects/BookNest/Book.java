package CollectionFramework.List.Projects.BookNest;

import java.util.List;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private boolean isIssued;


    public Book(Integer id , String author , String title , boolean isIssued){
        this.id=id;
        this.author=author;
        this.title=title;
        this.isIssued=isIssued;
    }

    public Book(){}

    public Book(Integer id , String title , String author){
        this.id=id;
        this.title=title;
        this.author=author;
    }




    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author=author;
    }


    public boolean isIssued(){
        return isIssued;
    }

    public void setIssued(boolean issued){
        isIssued=issued;
    }

  @Override
public String toString() {
    return "Book{id=" + id + ", title='" + title + "', author='" + author + "'}";
}



}
