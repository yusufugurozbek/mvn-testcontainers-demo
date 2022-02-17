package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository repository;

    @Override
    public List<BookEntity> retrieveBooks() {
        var book = new BookEntity(null, "Nonviolent Communication: A Langue of Life", "Marshall B. Rosenberg");
        repository.save(book);

        var bookList = new ArrayList<BookEntity>();
        repository.findAll().forEach(bookList::add);
        return bookList;
    }
}
