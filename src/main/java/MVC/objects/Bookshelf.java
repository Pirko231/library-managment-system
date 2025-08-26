package MVC.objects;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bookshelf implements Serializable {

    private ArrayList<Book> books;
    private PersonManager personManager;

    public Bookshelf(PersonManager personManager) {
        books = new ArrayList<>();
        this.personManager = personManager;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void display() {
        System.out.println(books);
    }

    // kiedy znajdzie ksiazke zwroci ja. kiedy nie zwroci null
    public Book findBook(String name) {
        for (Book book : books) {
            if (book.getTitle().equals(name)) {
                return book;
            }
        }
        return null;
    }

    // znajduje ksiazke o takiej samej nazwie i autorze
    public Book findBook(Book book) {
        Book result = null;
        for (Book b : books) {
            if (b.equals(book)) {
                result = b;
            }
        }
        return result;
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public int getSize() {
        return books.size();
    }

    public List<Book> getBooks() {
        return books;
    }
}
