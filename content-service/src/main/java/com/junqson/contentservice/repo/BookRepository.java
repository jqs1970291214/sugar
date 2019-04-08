package com.junqson.contentservice.repo;

import com.junqson.contentservice.data.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTag(String tag);
    /**
     * 分页按tag查询
     * @param tag
     * @param page
     * @return
     */
    Page<Book> findByTag(String tag, Pageable page);

    @Query(value = "SELECT * FROM book WHERE book_id >= ((SELECT MAX(book_id) FROM book)-(SELECT MIN(book_id) FROM book)) * RAND() + (SELECT MIN(book_id) FROM book)  LIMIT ?1",
            nativeQuery = true)
    List<Book> randomFind(Integer num);


}
