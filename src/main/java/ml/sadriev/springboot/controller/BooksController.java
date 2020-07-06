package ml.sadriev.springboot.controller;

import java.util.List;
import javax.annotation.Resource;
import ml.sadriev.springboot.model.Book;
import ml.sadriev.springboot.repository.BooksRepository;
import ml.sadriev.springboot.service.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BooksController {

    @Resource
    BooksRepository booksRepository;

    @Resource
    BooksService booksService;

    @PostMapping("/create")
    public String create(@RequestBody Book book) {
        booksRepository.save(new Book(book.getName(), book.getAuthor(), book.getPrice()));
        return "Book is saved";
    }

    @GetMapping("/findallbooks")
    public String findAll(ModelMap model) {
        List<Book> books = booksService.findAll();
        model.put("books", books);
        return "bookslist";
    }
}