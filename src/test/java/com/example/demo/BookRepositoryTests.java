package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({BookServiceImpl.class})
class BookRepositoryTests {

    @Autowired
    private BookRepository repository;

    @Test
    void repository_test() {
        BookEntity mobyDick = new BookEntity(null, "Moby Dick", "Herman Melville");

        repository.save(mobyDick);

        Assertions.assertEquals(2L, repository.count());
    }
}