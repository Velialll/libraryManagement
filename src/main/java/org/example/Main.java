package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        BookReader reader = new BookReader();
        BookWriter writer = new BookWriter();
        BookValidator validator = new BookValidator();

        library.addBook(new Book(1, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(2, "1984", "George Orwell"));
        library.addBook(new Book(3, "The Great Gatsby", "F. Scott Fitzgerald"));

        // Завантаження списку книг з файлу
        List<Book> books = BookWriter.loadBooksFromFile("books.txt");
        library.setBooks(books);

        // Виконання команд користувача
        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!command.equals("exit")) {
            System.out.println("Введіть команду: ");
            command = scanner.nextLine();

            switch (command) {
                case "add":
                    Book newBook = reader.readBookFromConsole();
                    if (validator.validateId(newBook.getId(), library.getBooks())) {
                        library.addBook(newBook);
                        writer.saveBooksToFile(library.getBooks(), "books.txt");
                    } else {
                        System.out.println("Книга з таким ID вже існує!");
                    }
                    break;
                case "remove":
                    System.out.println("Введіть ID книги: ");
                    int idToRemove = scanner.nextInt();
                    scanner.nextLine();
                    library.removeBook(idToRemove);
                    writer.saveBooksToFile(library.getBooks(), "books.txt");
                    break;
                case "list":
                    List<Book> allBooks = library.getBooks();
                    for (Book book : allBooks) {
                        reader.displayBookToConsole(book);
                    }
                    break;
                case "get":
                    System.out.println("Введіть ID книги: ");
                    int idToGet = scanner.nextInt();
                    scanner.nextLine();
                    Book bookById = library.getBookById(idToGet);
                    reader.displayBookToConsole(bookById);
                    break;
                case "search_title":
                    System.out.println("Введіть назву книги: ");
                    String titleToSearch = scanner.nextLine();
                    List<Book> booksByTitle = library.getBooksByTitle(titleToSearch);
                    for (Book book : booksByTitle) {
                        reader.displayBookToConsole(book);
                    }
                    break;
                case "search_author":
                    System.out.println("Введіть ім'я автора: ");
                    String authorToSearch = scanner.nextLine();
                    List<Book> booksByAuthor = library.getBooksByAuthor(authorToSearch);
                    for (Book book : booksByAuthor) {
                        reader.displayBookToConsole(book);
                    }
                    break;
                case "exit":
                    System.out.println("Програма завершила свою роботу!");
                    break;
                default:
                    System.out.println("Невідома команда!");
            }
        }
    }
}


