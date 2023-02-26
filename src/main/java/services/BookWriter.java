package services;

import models.Book;

import java.io.*;
import java.util.List;

public class BookWriter {

    public void saveBooksToFile(List<Book> books, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(books);
            System.out.println("Books have been saved to file " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> loadBooksFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Book> books = (List<Book>) ois.readObject();
            System.out.println("Books have been loaded from file " + filename);
            return books;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}