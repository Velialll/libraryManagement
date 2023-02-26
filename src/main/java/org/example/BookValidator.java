package org.example;

import java.util.*;

public class BookValidator {
    private Set<Integer> idSet;

    public BookValidator() {
        this.idSet = new HashSet<Integer>();
    }

    public boolean validateId(int id, List<Book> books) {
        if (idSet.contains(id)) {
            System.out.println("Error: Book with ID " + id + " already exists.");
            return false;
        }
        idSet.add(id);
        return true;
    }

    public boolean validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Error: Title cannot be empty.");
            return false;
        }
        return true;
    }

    public boolean validateAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            System.out.println("Error: Author cannot be empty.");
            return false;
        }
        return true;
    }
}
