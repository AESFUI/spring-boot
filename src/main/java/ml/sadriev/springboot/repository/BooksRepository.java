package ml.sadriev.springboot.repository;

import java.util.List;
import ml.sadriev.springboot.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<Book, String> {

    Book findBookByName(String name);

    List<Book> findBooksByAuthor(String author);
}
