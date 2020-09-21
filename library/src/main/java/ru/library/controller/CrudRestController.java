package ru.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.library.entity.Book;
import ru.library.service.CrudService;

@RestController
public class CrudRestController {
	@Autowired
	private CrudService crudService;

	@GetMapping("/bookList")
	public List<Book> getCompanyList() {
		return crudService.getBookList();
	}

	@GetMapping("/book/{id}")
	public Book getCompany(@PathVariable Integer id) {
		return crudService.getBookById(id);
	}

	@PostMapping("/book/save")
	public void saveOrUpdateCompany(@RequestBody Book book) {
		crudService.saveOrUpdateBook(book);
	}

	@DeleteMapping("/book/delete/{id}")
	public void deleteBook(@PathVariable Integer id) {
		crudService.deleteBook(id);
	}
}
