package gm.contacts.controller;

import gm.contacts.model.Contact;
import gm.contacts.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContactController {
    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
    private final ContactService contactService;

    // CONSTRUCTOR
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String init(ModelMap model) {
        List<Contact> contacts = contactService.listContacts();
        contacts.forEach(contact -> logger.info(contact.toString()));
        model.put("contacts", contacts);
        return "index";
    }
}
















