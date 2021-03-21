package by.azmd.mapper;

import org.springframework.stereotype.Component;

@Component
public interface DtoMapper<D, E> {
    D toDTO(E entity);

    E toEntity(D dto);
}