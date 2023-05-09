package com.belhard.bookstoreBoot.service.dto;

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



    @Override
    public String toString() {
        return "  \n BookDto " +
                "id= " + id +
                ", isbn= '" + isbn + '\'' +
                ", author= '" + author + '\'' +
                ", price= " + price +
                ", numberOfPages= " + numberOfPages +
                ", yearOfPublication= " + yearOfPublication + " г." +
                ", bookName= '" + bookName + '\'' +
                ", coverType= " + coverType;
    }
}