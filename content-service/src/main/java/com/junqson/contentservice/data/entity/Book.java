package com.junqson.contentservice.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private Integer id;
    private String title;
    private String author;
    private String authorInfo;
    private String imgUrl;
    private String tag;
    private String price;

    private String publisher;
    private String publishTime;

    private String summary;
    private String rating;
    private Integer pages;
    private String isbn;

}