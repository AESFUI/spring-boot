package ml.sadriev.springboot;

import javax.annotation.Resource;
import ml.sadriev.springboot.model.Book;
import ml.sadriev.springboot.service.BooksService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Application {

	@Resource
	private BooksService booksService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void testJpaMethods() throws Exception {
		init();

		booksService.findAll().forEach(System.out::println);

/*		booksService.findAll().forEach(it-> System.out.println(it));

		booksService.findAllByName("Smith").forEach(it-> System.out.println(it));

		booksService.findWhereNameStartsFromSmith().forEach(it-> System.out.println(it));*/
	}

	private void initBook(final String name, final String author, final double price) throws Exception {
		final Book book = booksService.findBookByName(name);
		if (book != null) {
			return;
		}
		booksService.createBook(name, author, price);
	}

	private void init() throws Exception {
		initBook("Как управлять Вселенной", "Степан Разин", 123.45);
		initBook("Кот, который нюхал клей", "Иоанн Васильевич Грозный", 34.56);
		initBook("Синяя книга белорусского алкоголика", "Васиссуалий Лоханкин", 200);
		initBook("Чапаев и пустота", "Фрося Бурлакова", 99.99);
	}
}