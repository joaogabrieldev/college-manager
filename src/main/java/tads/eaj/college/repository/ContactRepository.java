package tads.eaj.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.college.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
