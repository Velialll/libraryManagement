package org.example;

class BookReader {
    public static Book readBookFromConsole() {
        int id;
        String title, author;

        System.out.print("Enter book ID: ");
        id = Integer.parseInt(System.console().readLine());

        System.out.print("Enter book title: ");
        title = System.console().readLine();

        System.out.print("Enter book author: ");
        author = System.console().readLine();

        return new Book(id, title, author);
    }

    public static void displayBookToConsole(Book book) {
        System.out.println("ID: " + book.getId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
    }
}