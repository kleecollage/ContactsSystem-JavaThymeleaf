package gm.contacts.repository;

import gm.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContactRepository extends JpaRepository<Contact, Integer> {
}
