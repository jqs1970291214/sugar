package com.junqson.contentservice.service;

import com.junqson.contentservice.data.entity.Book;
import com.junqson.contentservice.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Descriptions
 * @Company
 * @Author Junqson
 * @Date 2018/12/13 0:17
 * @Version 1.0
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Cacheable(value = "bookpage")
    public Page<Book> pageBookByTag(String tag, Pageable pageable) {
        return bookRepository.findByTag(tag,pageable);
    }

    /**
     * 今日推荐
     * @return
     */
    @Cacheable(value = "todayrecommand")
    public List<Book> todayRecommand() {
        // 推荐10条
        return bookRepository.randomFind(10);
    }

    @Cacheable(value = "book")
    public Book getById(Integer id) {
        return bookRepository.findById(id).get();
    }

}
