package com.learning.readinglistapp.controller;

import com.learning.readinglistapp.config.AppCustomProps;
import com.learning.readinglistapp.entity.Book;
import com.learning.readinglistapp.repository.ReadingListrepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController("/")
@Log4j2
public class ReadingListController {
    private final ReadingListrepository readingListrepository;
    private AppCustomProps appCustomProps;

    @Autowired
    public ReadingListController(final ReadingListrepository readingListrepository, final AppCustomProps appCustomProps){
        this.readingListrepository = readingListrepository;
        this.appCustomProps = appCustomProps;
    }

    @GetMapping(value = "/{reader}")
    public List<Book> getBooksByReaderName(@PathVariable("reader") final String readerName){
        log.info("App Custom Props: {}", appCustomProps.getAppName());
        return readingListrepository.findByReader(readerName);
    }

    @PostMapping(value = "/{reader}")
    public Book addReaderToBook(@PathVariable("reader") final String readerName, @RequestBody Book book){
        book.setReader(readerName);
        return readingListrepository.save(book);
    }

    @GetMapping(value = "/poplulateData")
    public String populateData(){
        List<Book> listOfBooks;
        for(int i = 0; i < 10; i++){
            Book book = new Book();
            book.setReader("Ajay Gupta " + i);
            book.setIsbn("true");
            book.setTitle("Spring in Action " + i);
            book.setAuthor("VP AJAY " + i);
            book.setDescription("Great Book for reading " + i);
            readingListrepository.save(book);
        }

        return "Data population of book is done successfully.";
    }

}
