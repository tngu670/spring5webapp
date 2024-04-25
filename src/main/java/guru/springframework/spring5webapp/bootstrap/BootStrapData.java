package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher(
                "Nguyen Publishing", "31415", "Pi Lane", "CA", "90210");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

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
