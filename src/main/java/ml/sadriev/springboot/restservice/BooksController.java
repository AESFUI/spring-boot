package ml.sadriev.springboot.restservice;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import ml.sadriev.springboot.model.Book;
import ml.sadriev.springboot.repository.BooksRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

    @Resource
    BooksRepository booksRepository;

    @PostMapping("/create")
    public String create(@RequestBody UsersUI book) {
        booksRepository.save(new Book(book.getLogin(), book.getRealName()));
        return "Book is created";
    }

    @GetMapping("/findallbooks")
    public List<UsersUI> findAll() {
        List<Book> books = (List<Book>) booksRepository.findAll();
        List<UsersUI> booksUI = new ArrayList<>();
        for (Book book : books) {
            booksUI.add(new UsersUI(book.getLogin(), book.getRealName()));
        }
        return booksUI;
    }

    @RequestMapping("/search/{id}")
    public String search(@PathVariable String id) {
        String book = "";
        book = booksRepository.findById(id).toString();
        return book;
    }

    @RequestMapping("/searchbyrealname/{firstname}")
    public List<UsersUI> fetchDataByFirstName(@PathVariable String firstname) {
        List<Book> books = booksRepository.findBooksByAuthor(firstname);
        List<UsersUI> booksUI = new ArrayList<>();
        for (Book book : books) {
            booksUI.add(new UsersUI(book.getLogin(), book.getRealName()));
        }
        return booksUI;
    }
}