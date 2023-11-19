package exercise.service;

import java.util.List;

public interface CrudService <EntityDto, EntityCreateDto, EntityUpdateDto> {

    List<EntityDto> getAll();

    EntityDto create(EntityCreateDto entityCreateDto);

    EntityDto findById(Long id);

    EntityDto update(EntityUpdateDto updateDto, Long id);

    void delete(Long id);

}
