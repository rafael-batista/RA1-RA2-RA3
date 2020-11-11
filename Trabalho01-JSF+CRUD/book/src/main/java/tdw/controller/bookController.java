package tdw.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import tdw.entities.Book;
import tdw.sessionbean.BookFacadeLocal;

@Named(value = "bookController")
@SessionScoped
public class bookController implements Serializable {

    @EJB
    private BookFacadeLocal booksFacade;
    private Book selectedBook;
    private final Book book = new Book();
    private String name;
    private String author;
    private String coAuthor;
    private String isbn;
    private Integer year;
    private String category;
    private float price;

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
    
    public String getCoAuthor() {
        return coAuthor;
    }

    public void setCoAuthor(String coAuthor) {
        this.coAuthor = coAuthor;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
        this.coAuthor = "";
        this.isbn = "";
        this.category = "";
        this.name = "";
        this.price = 0;
        this.year = 0;
    }

    public String createBook() {
        this.book.setAuthor(this.author);
        this.book.setCoAuthor(this.coAuthor);
        this.book.setIsbn(this.isbn);
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
