package ml.sadriev.springboot.service;

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

    public Book findUserByLogin(String name) throws Exception {
        return booksRepository.findBookByName(name);
    }

    public List<Book> findAll() throws Exception {
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
}
