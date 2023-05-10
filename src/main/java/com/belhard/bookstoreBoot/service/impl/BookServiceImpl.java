package com.belhard.bookstoreBoot.service.impl;

import com.belhard.bookstoreBoot.data.entity.Book;
import com.belhard.bookstoreBoot.data.repository.BookRepository;
import com.belhard.bookstoreBoot.service.BookService;
import com.belhard.bookstoreBoot.service.dto.BookDto;
import com.belhard.bookstoreBoot.web.exeption.AppException;
import com.belhard.bookstoreBoot.web.exeption.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setBookName(book.getBookName());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setPrice(book.getPrice());
        bookDto.setNumberOfPages(book.getNumberOfPages());
        bookDto.setYearOfPublication(book.getYearOfPublication());
        bookDto.setCoverType(book.getCoverType());
        return bookDto;
    }

    public Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setBookName(bookDto.getBookName());
        book.setIsbn(bookDto.getIsbn());
        book.setAuthor(bookDto.getAuthor());
        book.setPrice(bookDto.getPrice());
        book.setNumberOfPages(bookDto.getNumberOfPages());
        book.setYearOfPublication(bookDto.getYearOfPublication());
        book.setCoverType(bookDto.getCoverType());
        return book;
    }

    @Override
    public BookDto getById(Long id) throws AppException {
        log.debug("Get by id: id ={}",id);
        return toDto(bookRepository.findById(id).orElseThrow(()-> new AppException("None book with id" + id)));
    }

    @Override
    public List<BookDto> getAll() {
        log.debug("Find all books");
        List<Book> books = bookRepository.findAll();

        List<BookDto> dtos = new ArrayList<>();
        for (Book book : books) {
            BookDto dto = toDto(book);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public BookDto create(BookDto dto) {
        dto.setCoverType(Book.Cover.SOFT);
        BigDecimal num = new BigDecimal(String.valueOf(dto.getPrice()));
        BigDecimal num2 = new BigDecimal(0);

        if (dto.getIsbn() == null ||dto.getIsbn().isBlank()) {
            throw new BadRequestException("Isbn is required");
        }
        if (dto.getAuthor() == null ||dto.getAuthor().isBlank()) {
            throw new BadRequestException("Autor is required");
        }
        if (dto.getBookName() == null ||dto.getBookName().isBlank()) {
            throw new BadRequestException("Bookname is required");
        }
        if (num.compareTo(num2) <=0) {
            throw new BadRequestException("Price is required");
        } else {
            Book book = bookRepository.save(toEntity(dto));
            log.debug("create: new BookDto ={}",dto);
            return toDto(book);
        }
    }

    @Override
    public BookDto update(BookDto dto) {
        Book book = bookRepository.save(toEntity(dto));
        log.debug("update id ={}",dto.getId());
        return toDto(book);
    }

    @Override
    public void delete(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("No book with id:" + id);
        }
        bookRepository.deleteById(id);
    }

//    public BigDecimal getSumBooksByAuthor(String author) {
//        log.debug("Try get sum by author");
//        List <Book> books = bookRepository.findByAuthor(author);
//        BigDecimal sum = BigDecimal.valueOf(0);
//        for (Book book: books) {
//            sum = sum.add(book.getPrice());
//        } if (books.size() == 0){
//            log.error("No such books");
//            throw new RuntimeException("No such books");
//        }
//        return sum;
//    }



}


