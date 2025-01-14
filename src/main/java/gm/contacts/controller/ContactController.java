package gm.contacts.controller;

import gm.contacts.model.Contact;
import gm.contacts.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactController {
    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
    private final ContactService contactService;

    // CONSTRUCTOR
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // GET [host]
    @GetMapping("/")
    public String init(ModelMap model) {
        List<Contact> contacts = contactService.listContacts();
        // contacts.forEach(contact -> logger.info(contact.toString()));
        model.put("contacts", contacts);
        return "index";
    }

    // GET [host/add]
    @GetMapping("/add")
    public String showAdd(ModelMap model) {
        return "add"; // to add page
    }

    // POST [host/add]
    @PostMapping("/add")
    public String addContact(@ModelAttribute("contactForm") Contact contact) {
        logger.info("contact to add: {}", contact);
        contactService.saveContact(contact);
        return "redirect:/"; // to Home
    }

    // GET [host/edit/{id}]
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable(value = "id") int idContact, ModelMap model) {
        Contact contact = contactService.searchContact(idContact);
        logger.info("contact to edit: {}", contact);
        model.put("contact", contact);
        return "edit"; // to edit page
    }

    // POST [host/edit]
    @PostMapping("/edit")
    public String editContact(@ModelAttribute("contact") Contact contact) {
        logger.info("contact to update: {}", contact);
        contactService.saveContact(contact);
        return "redirect:/"; // to Home
    }

    // GET [host/remove/{id}]
    @GetMapping("/remove/{id}")
    public String removeContact(@PathVariable(value = "id") int idContact) {
        Contact contact = new Contact();
        contact.setIdContact(idContact);
        logger.info("contact to remove: {}", contact);
        contactService.deleteContact(contact);
        return "redirect:/";
    }


}
















