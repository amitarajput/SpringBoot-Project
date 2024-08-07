package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // private static List<Book> list = new ArrayList<>();

    // static {
    // list.add(new Book(1, "c++", "abc"));
    // list.add(new Book(2, "c", "kkkc"));
    // list.add(new Book(3, "Java", "llll"));
    // }

    // get all books

    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get single book by id

    public Book getBookById(int id) {

        Book book = null;
        try {
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book = this.bookRepository.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }

    // create new book
    public Book addBook(Book b) {
        Book result = bookRepository.save(b);
        return result;

    }

    // delete book

    public void deleteBook(int bid) {
        // list =
        // list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }

    // update book
    public void updateBook(Book book, int bookId) {
        // list = list.stream().map(b->{
        // if(b.getId()==bookId){
        // b.setAuthorName(book.getAuthorName());
        // b.setBookName(book.getBookName());
        // }
        // return b;

        // }).collect(Collectors.toList());
        book.setId(bookId);
        bookRepository.save(book);

    }

}
