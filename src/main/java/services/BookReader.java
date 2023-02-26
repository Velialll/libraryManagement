package services;

import models.Book;
import utils.BookValidator;

import java.util.List;
import java.util.Scanner;

public class BookReader {
    private Scanner scanner;

    public BookReader() {
        scanner = new Scanner(System.in);
    }

    public Book readBookFromConsole(List<Book> books) {
        BookValidator validator = new BookValidator();
        String id;
        do {
            System.out.print("Enter the book ID: ");
            id = scanner.nextLine();
        } while (!validator.validateId(id, books));

        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        while (!validator.validateTitle(title)) {
            System.out.print("Invalid input. Enter the book title: ");
            title = scanner.nextLine();
        }

        System.out.print("Enter the book author: ");
        String author = scanner.nextLine();
        while (!validator.validateAuthor(author)) {
            System.out.print("Invalid input. Enter the book author: ");
            author = scanner.nextLine();
        }

        return new Book(id, title, author);
    }

    public void displayBookToConsole(Book book) {
        System.out.println("ID: " + book.getId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor() + "\n");
    }
}
