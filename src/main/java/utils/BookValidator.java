package utils;

import models.Book;

import java.util.List;

public class BookValidator {


    public boolean validateId(String id, List<Book> books) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("Error: id cannot be empty.");
            return false;
        }

        for (Book book : books) {
            if (book.getId().equals(id)) {
                System.out.println("Book with ID: " + id + " already exists.");
                return false;
            }
        }
        return true;
    }

    public boolean validateIdForRemoving(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("Error: id cannot be empty.");
            return false;
        }
        return true;
    }

    public boolean validateIdForPresent(String id, List<Book> books) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return true;
            }
        }
        System.out.println("Book with ID: " + id + " does not exist.");
        return false;
    }


    public boolean validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Error: title cannot be empty.");
            return false;
        }
        return true;
    }


    public boolean validateAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            System.out.println("Error: author cannot be empty.");
            return false;
        }
        return true;
    }
}