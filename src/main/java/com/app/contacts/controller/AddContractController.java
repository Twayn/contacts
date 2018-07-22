package com.app.contacts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.contacts.repository.Contact;
import com.app.contacts.repository.ContactsRepository;

@RestController
@RequestMapping("/api")
public class AddContractController {

	private final ContactsRepository contactsRepository;

	public AddContractController(ContactsRepository contactsRepository) {
		this.contactsRepository = contactsRepository;
	}

	@GetMapping("/addcontact")
	public String addContact(@RequestParam(name="first_name") String firstName,
							 @RequestParam(name="last_name") String lastName,
							 @RequestParam(name="age") int age,
							 @RequestParam(name="phone", required=false, defaultValue="0") String phone
						   ) {

		var contact = new Contact();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setAge(age);
		contact.setPhone(phone);

		contactsRepository.save(contact);
		return "success";
	}
}