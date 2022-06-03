package org.agoncal.quarkus.starting;


import io.smallrye.config.ConfigMapping;
import org.eclipse.microprofile.config.inject.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {
    @ConfigProperty(name ="books.genre", defaultValue = "Sci-Fi")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Understanding quarkus", "Antonio", 2020, "IT"),
                new Book(2, "Practising quarkus", "Antonio", 2020, "IT"),
                new Book(3, "Efective Java", "Josh Blocj", 2001, "IT"),
                new Book(4, "Thinking in Java", "Bruce Eckel", 1998, "IT"));
    }




    public Optional<Book> getBook(int id){
        return getAllBooks().stream().filter(book -> book.id== id).findFirst();
    }
}