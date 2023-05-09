package com.belhard.bookstoreBoot.data.dto;

import com.belhard.bookstoreBoot.data.entity.Book;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDto {
    private Long id;
    private String isbn;
    private String author;
    private BigDecimal price;
    private Integer numberOfPages;
    private Integer yearOfPublication;
    private String bookName;
    private Book.Cover coverType;

    public enum Cover {
        SOFT, HARD, SPECIAL
    }
}