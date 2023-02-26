/*
package main;

import models.Book;
import models.Library;
import services.BookReader;
import services.BookWriter;
import utils.BookValidator;
import views.LibraryView;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        BookReader bookReader = new BookReader();
        BookWriter bookWriter = new BookWriter();
        LibraryView libraryView = new LibraryView();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of books:");
        int numBooks = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < numBooks; i++) {
            System.out.println("Enter details for book " + (i + 1) + ":");


            System.out.println("Enter the book title:");
            String title = scanner.nextLine();

            System.out.println("Enter the book author:");
            String author = scanner.nextLine();

            System.out.println("Enter the book ID:");
            String id = scanner.nextLine();


            BookValidator bookValidator = new BookValidator();

            if (bookValidator.validateTitle(title) &&
                    bookValidator.validateAuthor(author) &&
                    bookValidator.validateId(id, library.getBooks())) {
                Book book = new Book(id, title, author);
                library.addBook(book);
            } else {
                System.out.println("Invalid book details. Book not added to library.");
            }
            List<Book> bookList = library.getBooks();


            //bookWriter.saveBooksToFile(library.getBooks(), "books.dat");
            // bookWriter.loadBooksFromFile("books.dat");

        }

    }
}


*/
