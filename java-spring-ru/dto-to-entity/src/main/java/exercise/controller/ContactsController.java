package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    private ContactDTO create(@RequestBody ContactCreateDTO data) {
        var contact = toEntity(data);
        contactRepository.save(contact);
        var contactDto = toDTO(contact);
        return contactDto;
    }

    private ContactDTO toDTO(Contact contact) {
        var dto = new ContactDTO();
        dto.setFirstName(contact.getFirstName());
        dto.setLastName(contact.getLastName());
        dto.setPhone(contact.getPhone());
        dto.setId(contact.getId());
        dto.setCreatedAt(contact.getCreatedAt());
        dto.setUpdatedAt(contact.getUpdatedAt());

        return dto;
    }

    private Contact toEntity(ContactCreateDTO contactDTO) {
        var contact = new Contact();
        contact.setPhone(contactDTO.getPhone());
        contact.setFirstName(contactDTO.getFirstName());
        contact.setLastName(contactDTO.getLastName());

        return contact;
    }
}
