package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.model.Author;
import exercise.model.Book;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements CrudService<BookDTO, BookCreateDTO, BookUpdateDTO> {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;


    @Override
    public List<BookDTO> getAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::map)
                .toList();
    }

    @Override
    public BookDTO create(BookCreateDTO createDTO) {
        var book = bookMapper.map(createDTO);
        var authorId = createDTO.getAuthorId();

        if (!authorRepository.existsById(authorId)) {
            throw new ConstraintViolationException(null);
        }

        bookRepository.save(book);

        return bookMapper.map(book);
    }

    @Override
    public BookDTO findById(Long id) {
        var book = findBookById(id);

        return bookMapper.map(book);
    }

    @Override
    public BookDTO update(BookUpdateDTO bookUpdateDTO, Long id) {
        var book = findBookById(id);

        if (!authorRepository.existsById(book.getAuthor().getId())) {
            throw new ConstraintViolationException(null);
        }

        bookMapper.update(bookUpdateDTO, book);
        bookRepository.save(book);

        return bookMapper.map(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    private Book findBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
    }
}
