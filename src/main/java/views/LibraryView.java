package views;

import models.Book;

import java.util.List;

public class LibraryView {

    public void displayBooks(List<Book> bookList){
        if (bookList.isEmpty()){
            System.out.println("The library is empty.");
        }
        else {
            System.out.println("Here are the books in the library:\n");
            for (Book book:bookList){
                System.out.println(book.toString() + "\n");
            }
        }
    }
}
