package com.example.facade;

public class ContactNotFoundExeption extends Exception {

	public ContactNotFoundExeption() {
		super("contact not found!");
	}
}
