package ru.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.library.entity.Book;

public interface CrudRepository extends JpaRepository<Book, Integer> {

}
