package com.belhard.bookstoreBoot.service.impl;

import com.belhard.bookstoreBoot.data.entity.Book;
import com.belhard.bookstoreBoot.data.repository.BookRepository;
import com.belhard.bookstoreBoot.service.BookMapper;
import com.belhard.bookstoreBoot.service.BookService;
import com.belhard.bookstoreBoot.service.dto.BookDto;
import com.belhard.bookstoreBoot.web.exeption.AppException;
import com.belhard.bookstoreBoot.web.exeption.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto getById(Long id) throws AppException {
        log.debug("Get by id: id ={}",id);
        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElseThrow(()-> new AppException("None book with id" + id));
    }

    @Override
    public Page<BookDto> getAll(Pageable pageable) {
        log.debug("Find all books");
        return bookRepository.findAll(pageable).map(bookMapper::toDto);
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
            Book toSave = bookMapper.toEntity(dto);
            Book saved = bookRepository.save(toSave);
            log.debug("create: new BookDto ={}",dto);
            return bookMapper.toDto(saved);
        }
    }

    @Override
    public BookDto update(BookDto dto) {
        Book toSave = bookMapper.toEntity(dto);
        Book saved = bookRepository.save(toSave);
        log.debug("update id ={}",dto.getId());
        return bookMapper.toDto(saved);
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


