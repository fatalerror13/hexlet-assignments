package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.model.Author;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements CrudService<AuthorDTO, AuthorCreateDTO, AuthorUpdateDTO> {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public List<AuthorDTO> getAll() {
        return authorRepository.findAll().stream()
                .map(authorMapper::map)
                .toList();
    }

    @Override
    public AuthorDTO create(AuthorCreateDTO dto) {
        var author = authorMapper.map(dto);
        authorRepository.save(author);

        return authorMapper.map(author);
    }

    @Override
    public AuthorDTO findById(Long id) {
        var author = findAuthorById(id);

        return authorMapper.map(author);
    }

    @Override
    public AuthorDTO update(AuthorUpdateDTO authorUpdateDTO, Long id) {
        var author = findAuthorById(id);
        authorMapper.update(authorUpdateDTO, author);
        authorRepository.save(author);

        return authorMapper.map(author);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    private Author findAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));
    }
}
