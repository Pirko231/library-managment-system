package MVC.objects;

import java.util.Objects;

import MVC.gui.Categorizable;
import MVC.gui.CategoryObject;
import MVC.gui.Content;

public class Book implements Categorizable {

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
    public CategoryObject asCategoryObject() {
        return new CategoryObject(title, null);
    }

    @Override
    public String toString() {
        String result = "{" + title + "," + author + "} Owner = ";
        result += owner != null ? owner.getHash() : owner;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        var compare = (Book)o;
        return title.equals(compare.getTitle()) && author.equals(compare.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        if (this.owner != null) {
            this.owner.removeBook(this);
        }
        this.owner = owner;
        if (this.owner != null) {
            this.owner.addBook(this);
        }
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
