package MVC.objects;

public class Book {

    private String title;
    private String author;
    Person owner = null;

    public Book() {
        this("empty", "empty");
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        String result = "{" + title + "," + author + "} Owner = ";
        result += owner != null ? owner.getHash() : owner;
        return result;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void removeOwner() {
        owner = null;
    }

    public final String getTitle() {
        return title;
    }

    public final String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
