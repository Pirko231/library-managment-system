package MVC.objects;

public class Book
{
    private String title;
    private String author;

    public Book() {this("empty", "empty");}

    public Book(String title, String author)
    {
        this.title = title; this.author = author;
    }
    @Override
    public String toString() {return "{" + title + "," + author + "}";}

    public final String getTitle() {return title;}
    public final String getAuthor() {return author;}

    public void setTitle(String title) {this.title = title;}
    public void setAuthor(String author) {this.author = author;}
}