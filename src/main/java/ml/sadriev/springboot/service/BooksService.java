package ml.sadriev.springboot.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import lombok.AllArgsConstructor;
import ml.sadriev.springboot.model.Book;
import ml.sadriev.springboot.repository.BooksRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BooksService {

    @Resource
    private final BooksRepository booksRepository;

    public Book findBookByName(String name) {
        return booksRepository.findBookByName(name);
    }

    public List<Book> findAll() {
        return (List<Book>) booksRepository.findAll();
    }

    @Transactional
    public void createBook(final String name, final String author, final double price) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        booksRepository.save(book);
    }

    @Transactional
    public void deleteBookByName(final String name) {
        booksRepository.deleteBookByName(name);
    }
}
