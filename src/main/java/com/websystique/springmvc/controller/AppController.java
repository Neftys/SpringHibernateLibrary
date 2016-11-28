package com.websystique.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import com.websystique.springmvc.model.Author;
import com.websystique.springmvc.model.Book;
import com.websystique.springmvc.service.ServiceInterface.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.service.ServiceInterface.EmployeeService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AppController {


	@Autowired
	EmployeeService service;

	@Autowired
	BookService bookService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	 Book currentBook;



	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String listBook(ModelMap model) {

		List<Book> books = bookService.findAllBook();

		model.addAttribute("books", books);

		return "index" ;
	}

	@RequestMapping(value = { "/newBook" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "registration";
	}

	/*
	@RequestMapping(value = { "/newBook" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Book book,
			ModelMap model) {
		Author author =new Author();
		model.addAttribute("book",book);
		model.addAttribute("author",author);

		return "addBookSuc";
	}
*/
	@RequestMapping(value = { "/newBook" }, method = RequestMethod.POST)
	public String saveBook(@Valid Book book,
							   ModelMap model) {
		Author author =new Author();
		currentBook=new Book();
		currentBook.setName(book.getName());
		currentBook.setDescription(book.getDescription());
		model.addAttribute("book", book);
		model.addAttribute("author",author);
		System.out.println(currentBook);

		return "addBookSuc";
	}

	@RequestMapping(value = { "/newAuthor-{book}" }, method = RequestMethod.GET)
	public String newAuthor(@PathVariable Book book,
							   ModelMap model) {
		Author author =new Author();
		model.addAttribute("book",book);
		model.addAttribute("author",author);

		return "index";
	}


	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String index(ModelMap model) {

		return "registration";
	}



	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable String ssn, ModelMap model) {
		Employee employee = service.findEmployeeBySsn(ssn);
		model.addAttribute("employee", employee);
		model.addAttribute("edit", true);
		return "registration";
	}
	

	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
	public String updateEmployee(@Valid Employee employee, BindingResult result,
			ModelMap model, @PathVariable String ssn) {

		if (result.hasErrors()) {
			return "registration";
		}

		if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
			FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
		    result.addError(ssnError);
			return "registration";
		}

		service.updateEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getName()	+ " updated successfully");
		return "success";
	}

	@RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String ssn) {
		service.deleteEmployeeBySsn(ssn);
		return "redirect:/list";
	}


	@ModelAttribute("currentBook")
	public Book currentBook() {
		return currentBook;
	}


}
