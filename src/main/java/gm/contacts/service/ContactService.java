package gm.contacts.service;

import gm.contacts.model.Contact;
import gm.contacts.repository.IContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IContactService {
    private final IContactRepository contactRepository;

    // CONSTRUCTOR
    public ContactService(IContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> listContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact searchContact(Integer idContact) {
        return contactRepository.findById(idContact).orElse(null);
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }
}
