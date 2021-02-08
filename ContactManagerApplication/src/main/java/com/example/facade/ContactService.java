package com.example.facade;

import java.sql.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.beans.Contact;
import com.example.beans.LogData;
import com.example.reposetories.ContactReposetory;
import com.example.reposetories.LogReposetory;

@Service
@Scope("prototype")
public class ContactService {

	private ContactReposetory contactReposetory;
	private LogReposetory logReposetory;


	
	public ContactService(ContactReposetory contactReposetory, LogReposetory logReposetory) {
		super();
		this.contactReposetory = contactReposetory;
		this.logReposetory = logReposetory;
	}

	public void addContact(Contact contact) {
		contactReposetory.save(contact);
	}
	
	public Contact updateContact(Contact contact) {
		contactReposetory.save(contact);
		return contact;
	}
	
	public Contact deleteContact(int id) throws ContactNotFoundExeption {
			Contact c=getOneById(id);
			contactReposetory.deleteById(id);
			return c;
	}
	
	public List<Contact> getAllContacts(){
		return contactReposetory.findAll();
	}
	
	public Contact getOneById(int id) throws ContactNotFoundExeption {
		return contactReposetory.findById(id).orElseThrow(ContactNotFoundExeption::new);
	}
	
	public int numOfUpdates(int id) {
		List<LogData> logs=logReposetory.getContactLogs(id);
		return logs.size();
	}
	
	public Date lastUpdate(int id) {
		List<LogData> logs=logReposetory.getContactLogs(id);
		return logs.get(logs.size()-1).getActionTime();
	}
}
