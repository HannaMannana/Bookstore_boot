package com.belhard.bookstoreBoot.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "bookstore_bh")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    @Column(name = "year_of_publication")
    private Integer yearOfPublication;

    @Column(name = "bookname")
    private String bookName;

    @Column(name = "cover_id")
    @Convert(converter = CoverConverter.class)
    private Cover coverType;

    public enum Cover {
        SOFT, HARD, SPECIAL
    }


    @Converter
    public static class CoverConverter implements AttributeConverter<Cover, Short>{


        @Override
        public Short convertToDatabaseColumn(Cover cover) {
            Cover[] values = Cover.values();
            for (short i = 0; i < values.length; i++) {
               if(values [i].equals(cover)){
                   return (short) (i + 1);
               }

            }
            return 1;
        }

        @Override
        public Cover convertToEntityAttribute(Short integer) {
            Cover[] values = Cover.values();
            return values [integer-1];
        }
    }

    @Override
    public String toString() {
        return " \n Book" +
                "id= " + id +
                ", isbn= '" + isbn + '\'' +
                ", author= '" + author + '\'' +
                ", price= " + price +
                ", numberOfPages= " + numberOfPages +
                ", yearOfPublication= " + yearOfPublication + " г." +
                ", bookName= '" + bookName + '\'' +
                ", coverType= " + coverType ;
    }
}

