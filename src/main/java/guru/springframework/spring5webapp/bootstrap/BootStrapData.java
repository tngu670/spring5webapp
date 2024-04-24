package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author taylor = new Author("Taylor", "Nguyen");
        Book helloWorld = new Book("Hello World", "123123");
        taylor.getBooks().add(helloWorld);
        helloWorld.getAuthors().add(taylor);

        authorRepository.save(taylor);
        bookRepository.save(helloWorld);

        Author grayson = new Author("Grayson", "Nguyen");
        Book hiToMom = new Book("HiToMom", "456456");
        hiToMom.getAuthors().add(grayson);
        grayson.getBooks().add(hiToMom);

        authorRepository.save(grayson);
        bookRepository.save(hiToMom);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

    }
}
