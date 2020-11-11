/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdw.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import tdw.entities.Book;
import tdw.sessionbean.BookFacadeLocal;

/**
 *
 * @author Cristina
 */
@Named(value = "bookController")
@SessionScoped
public class bookController implements Serializable {

    @EJB
    private BookFacadeLocal booksFacade;

    private Book selectedBook;

    private final Book book = new Book();
    private String name;
    private String author;
    private Integer year;
    private String category;
    private float price;

    /**
     * Creates a new instance of bookController
     */
    public bookController() {
    }

    public Book getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = selectedBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void emptyVariables() {
        this.author = "";
        this.category = "";
        this.name = "";
        this.price = 0;
        this.year = 0;
    }

    public String createBook() {
        this.book.setAuthor(this.author);
        this.book.setCategory(this.category);
        this.book.setName(this.name);
        this.book.setPrice(this.price);
        this.book.setYear(this.year);
        this.booksFacade.create(this.book);
        this.emptyVariables();
        return "index.xhtml?faces-redirect=true";
    }

    public List<Book> getAllBooks() {
        return this.booksFacade.findAll();
    }

    public String updateBook(Book book) {
        this.booksFacade.edit(this.selectedBook);
        return "index.xhtml?faces-redirect=true";
    }

    public String deleteBook(Book book) {
        this.booksFacade.remove(book);
        return "index.xhtml?faces-redirect=true";
    }

}
