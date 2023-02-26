package models;

import services.BookReader;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    BookReader bookReader = new BookReader();

    public Library() {
        this.books = new ArrayList<>();
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(String id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(id)) {
                books.remove(i);
                return;
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }


    public void getBookById(String id) {
        boolean bookFound = false;
        for (Book book : books) {
            if (book.getId().equals(id)) {
                bookReader.displayBookToConsole(book);
                bookFound = true;
            }
        }
        if (!bookFound) {
            System.out.println("Book with ID " + id + " not found");
        }
    }

    public void getBookByTitle(String title) {
        boolean bookFound = false;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                bookReader.displayBookToConsole(book);
                bookFound = true;
            }
        }
        if (!bookFound) {
            System.out.println("Book with title " + title + " not found");
        }
    }

    public void getBookByAuthor(String author) {
        boolean bookFound = false;
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                bookReader.displayBookToConsole(book);
                bookFound = true;
            }
        }
        if (!bookFound) {
            System.out.println("Book with author " + author + " not found");
        }
    }
}