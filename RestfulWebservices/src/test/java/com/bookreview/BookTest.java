package com.bookreview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookreview.entity.Books;
import com.bookreview.repo.BooksRepository;

import java.util.Optional;

@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class BookTest {

    @Autowired
    BooksRepository brepo;

    @Test
    @Order(2)
    public void getAndUpdateBookTest() {
        // Fetch the book with ID 2
        Optional<Books> optionalBook = brepo.findById(2); // Assuming the ID type is Long

        // Check if the book with ID 2 exists
        assertTrue(optionalBook.isPresent());

        Books book = optionalBook.get();
        assertEquals(2, book.getId());

        // Update the book
        book.setPrice(999);
        book.setName("Fiction movie");
        book.setCategory("Horror");
        book.setAuthor("Cames bond");
        brepo.save(book);

        // Fetch the updated book
        Optional<Books> updatedOptionalBook = brepo.findById(2);
        assertTrue(updatedOptionalBook.isPresent());

        Books updatedBook = updatedOptionalBook.get();
        assertEquals(999, updatedBook.getPrice());
        assertEquals("Cames bond", updatedBook.getAuthor());
        assertEquals("Fiction movie",updatedBook.getName());
        assertEquals("Horror",updatedBook.getCategory());
    }
}
