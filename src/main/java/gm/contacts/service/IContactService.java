package gm.contacts.service;

import gm.contacts.model.Contact;

import java.util.List;

public interface IContactService {
    public List<Contact> listContacts();

    public Contact searchContact(Integer idContact);

    public void saveContact(Contact contact);

    public void deleteContact(Contact contact);
}
