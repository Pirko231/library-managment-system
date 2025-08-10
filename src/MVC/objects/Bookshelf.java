package MVC.objects;

import java.util.ArrayList;

public class Bookshelf {

    private ArrayList<Book> books;

    public Bookshelf(String fileName) {
        books = new ArrayList<>();
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
                    title = line.substring(0, line.indexOf(','));
                    author = line.substring(line.indexOf(',') + 1, line.length());
                    books.add(new Book(title, author));
                }
                fileScanner.close();
            } catch (Exception e) {
                System.out.println("File didn't open: " + fileName);
                e.printStackTrace();
            }
            System.out.println(books);
        }
    }
}
