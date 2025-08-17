package MVC.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

    int code = 0;
    private String name;
    private String surname;
    private List<Book> books = new ArrayList<>();

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
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
            book.setOwner(null);
            books.remove(book);
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
