package com.belhard.bookstoreBoot.web.controller;


import com.belhard.bookstoreBoot.service.BookService;
import com.belhard.bookstoreBoot.service.dto.BookDto;
import com.belhard.bookstoreBoot.web.exeption.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model) throws AppException {
        BookDto book = bookService.getById(id);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/getAll")
    public String getAll (Model model, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size){
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        page = page == null ? 0 : page;
        size = size == null ? 5 : size;
        PageRequest pageable = PageRequest.of(page, size, sort);
        Page<BookDto> books = bookService.getAll(pageable);
        model.addAttribute("books", books.toList());
        model.addAttribute("current", books.getNumber());
        model.addAttribute("total", books.getTotalPages());
        model.addAttribute("size", books.getSize());
        return "books";
    }

    @GetMapping("/create")
    public String createBookForm(){
        return "bookAddForm";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute BookDto book){
        bookService.create(book);
        return "finishAddBook";
    }

    @GetMapping("/update/{id}")
    public String updateBookForm(@PathVariable Long id, Model model) throws AppException{
        BookDto book = bookService.getById(id);
        model.addAttribute("book",book);
        return "bookUpdateForm";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@ModelAttribute BookDto book){
        bookService.update(book);
        return "books";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        bookService.delete(id);
        return "deleteMessage";
    }



}


