
package main;

import models.Book;
import models.Library;
import services.BookReader;
import services.BookWriter;
import utils.BookValidator;
import views.LibraryView;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        BookReader bookReader = new BookReader();
        BookWriter bookWriter = new BookWriter();
        LibraryView libraryView = new LibraryView();

        Scanner scanner = new Scanner(System.in);

        library.addBook(new models.Book("1", "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new models.Book("2", "1984", "George Orwell"));
        library.addBook(new models.Book("3", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new models.Book("4", "The Picture of Dorian Gray", "Oscar Wilde "));
        library.addBook(new models.Book("5", "Harry Potter and the Philosopher's Stone", "J. K. Rowling"));
        library.addBook(new models.Book("6", "Harry Potter and the Chamber of Secrets", "J. K. Rowling"));
        library.addBook(new models.Book("7", "Harry Potter and the Prisoner of Azkaban", "J. K. Rowling"));
        library.addBook(new models.Book("8", "Harry Potter and the Goblet of Fire", "J. K. Rowling"));
        library.addBook(new models.Book("9", "Harry Potter and the Order of the Phoenix", "J. K. Rowling"));
        library.addBook(new models.Book("10", "Harry Potter and the Half-Blood Prince", "J. K. Rowling"));
        library.addBook(new models.Book("11", "Harry Potter and the Deathly Hallows", "J. K. Rowling"));
        library.addBook(new models.Book("12", "Harry Potter and the Deathly Hallows 2", "J. K. Rowling"));

        String command = "";

        while (!command.equals("Exit")) {
            System.out.println("""
                    Add books     Remove book      Display books
                    ID search     Title search     Author search
                    Save to file  Load from file   Exit
                    """);
            System.out.println("Enter the command: ");
            command = scanner.nextLine();

            switch (command) {
                case "Add books":
                    System.out.println("Enter the number of books:");
                    int numBooks = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < numBooks; i++) {
                        Book book = bookReader.readBookFromConsole(library.getBooks());
                        library.addBook(book);
                        bookReader.displayBookToConsole(book);
                    }
                    break;

                case "Remove book":
                    BookValidator bookValidator = new BookValidator();
                    System.out.println("Enter the ID of book: ");
                    String idToRemove = scanner.nextLine();

                    while (!bookValidator.validateIdForRemoving(idToRemove) ||
                            !bookValidator.validateIdForPresent(idToRemove, library.getBooks())) {
                        System.out.println("Enter the ID of book: ");
                        idToRemove = scanner.nextLine();
                    }

                    library.removeBook(idToRemove);
                    System.out.println("Book with ID: " + idToRemove + " has been removed\n");
                    break;

                case "ID search":
                    BookValidator bookValidatorId = new BookValidator();
                    System.out.println("Enter the ID of book: ");
                    String idSearch = scanner.nextLine();

                    while (!bookValidatorId.validateIdForRemoving(idSearch) ||
                            !bookValidatorId.validateIdForPresent(idSearch, library.getBooks())) {
                        System.out.println("Enter the ID of book: ");
                        idSearch = scanner.nextLine();
                    }
                    library.getBookById(idSearch);
                    break;

                case "Title search":
                    BookValidator bookValidatorTitle = new BookValidator();
                    System.out.println("Enter the title of book: ");
                    String titleSearch = scanner.nextLine();

                    while (!bookValidatorTitle.validateTitle(titleSearch)) {
                        System.out.println("Enter the title of book: ");
                        titleSearch = scanner.nextLine();
                    }

                    library.getBookByTitle(titleSearch);
                    break;

                case "Author search":
                    BookValidator bookValidatorAuthor = new BookValidator();
                    System.out.println("Enter the author of book: ");
                    String authorSearch = scanner.nextLine();

                    while (!bookValidatorAuthor.validateAuthor(authorSearch)) {
                        System.out.println("Enter the author of books: ");
                        authorSearch = scanner.nextLine();
                    }
                    library.getBookByAuthor(authorSearch);
                    break;

                case "Display books":
                    libraryView.displayBooks(library.getBooks());
                    break;

                case "Save to file":
                    System.out.println("Enter the file name:");
                    String fileName = scanner.nextLine();
                    bookWriter.saveBooksToFile(library.getBooks(), fileName);
                    System.out.println();
                    break;

                case "Load from file":
                    System.out.println("Enter the file name:");
                    String loadFileName = scanner.nextLine();
                    List<Book> loadedBooks = bookWriter.loadBooksFromFile(loadFileName);
                    if (loadedBooks != null) {
                        library.setBooks(loadedBooks);
                        libraryView.displayBooks(library.getBooks());
                    } else {
                        System.out.println("Failed to load books from file " + loadFileName);
                    }
                    break;
                case "Exit":
                    break;

                default:
                    System.out.println("Unknown command");
            }
        }
    }
}
