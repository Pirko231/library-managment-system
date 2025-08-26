package MVC.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import MVC.gui.Categorizable;
import MVC.gui.CategoryObject;
import MVC.gui.Content;

public class Person implements Categorizable, Serializable {

    int code = 0;
    private String name;
    private String surname;
    private final List<Book> books = new ArrayList<>();

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public CategoryObject asCategoryObject() {
        return new CategoryObject(name, null);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "{" + name + "," + surname + "}";
    }

    @Override
    public boolean equals(Object o) {
        var compare = (Person)o;
        return name.equals(compare.name) && surname.equals(compare.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public String getHash() {
        return toString() + "_" + String.valueOf(code);
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public void removeAll() {
        for (Book book : books) {
            book.removeOwner();
        }
        books.clear();
    }

    public List<Book> getBooks() {
        return books;
    }
}
