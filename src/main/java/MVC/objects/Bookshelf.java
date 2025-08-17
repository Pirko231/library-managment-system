package MVC.objects;

import java.util.ArrayList;

public class Bookshelf {

    private ArrayList<Book> books;
    private PersonManager personManager;

    public Bookshelf(String fileName, PersonManager personManager) {
        books = new ArrayList<>();
        this.personManager = personManager;
        loadBooks(fileName);
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

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public int getSize() {
        return books.size();
    }

    private void loadBooks(String fileName) {
        java.io.File file = new java.io.File(fileName);
        file.setReadable(true);
        if (file.canRead()) {
            try {
                java.util.Scanner fileScanner = new java.util.Scanner(file);
                String title = new String();
                String author = new String();
                while (fileScanner.hasNext()) {
                    String line = fileScanner.nextLine();
                    title = line.substring(1, line.indexOf(','));
                    author = line.substring(line.indexOf(',') + 1, line.indexOf('}'));
                    String owner = line.substring(line.indexOf("Owner = ") + 8, line.length());
                    Book b = new Book(title, author);
                    var o = personManager.findPerson(owner);
                    b.setOwner(o);
                    o.addBook(b);
                    books.add(b);
                }
                fileScanner.close();
            } catch (Exception e) {
                System.out.println("File didn't open: " + fileName);
            }
        }
    }

    public void saveBooks(String filename) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter(filename);
            for (Book book : books) {
                try {
                    writer.write(book.toString() + "\n");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            writer.close();
        } catch (Exception e) {
        }

    }
}
