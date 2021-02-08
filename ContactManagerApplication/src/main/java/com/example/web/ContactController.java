package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Contact;
import com.example.facade.ContactNotFoundExeption;
import com.example.facade.ContactService;

@RestController
@RequestMapping("contact")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

	@Autowired
	private ContactService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> addContact(@RequestBody Contact contact){
		service.addContact(contact);
		return ResponseEntity.ok(contact);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateContact(@RequestBody Contact contact){
		service.updateContact(contact);
		return ResponseEntity.ok(contact);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteContact(@PathVariable int id){
		try {
			Contact c=service.deleteContact(id);
			return ResponseEntity.ok(c);
		} catch (ContactNotFoundExeption e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		List <Contact>contacts=service.getAllContacts();
		return ResponseEntity.ok(contacts);
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOne(@PathVariable int id){
		try {
		Contact contact=service.getOneById(id);
		return ResponseEntity.ok(contact);
		} catch (ContactNotFoundExeption e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/count/{id}")
	public ResponseEntity<?> getCount(@PathVariable int id){
		return ResponseEntity.ok(service.numOfUpdates(id));
	}
	
	@GetMapping("/lastUpdate/{id}")
	public ResponseEntity<?> getLastUpdate(@PathVariable int id){
		return ResponseEntity.ok(service.lastUpdate(id));
	}
	
}

