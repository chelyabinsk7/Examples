package ru.library.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.library.entity.Book;
import ru.library.repository.CrudRepository;

@Service
public class CrudService {
	@Autowired
	private CrudRepository crudRepository;

	public List<Book> getBookList() {
		return crudRepository.findAll();
	}

	public Book getBookById(Integer id) {
		return crudRepository.findById(id).get();
	}

	public void saveOrUpdateBook(Book book) {
		crudRepository.save(book);
	}
	
	public void deleteBook(Integer id) {
		crudRepository.deleteById(id);
	}
}
