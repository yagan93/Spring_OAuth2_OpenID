package com.example.identity.core.generic;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public interface ExtendedService<T extends ExtendedEntity> {

    T save(T entity);

    Void deleteById(UUID id) throws NoSuchElementException;

    T updateById(UUID id, T entity) throws NoSuchElementException;

    List<T> findAll();

    List<T> findAll(Pageable pageable);

    T findById(UUID id);

    boolean existsById(UUID id);

    T findOrThrow(Optional<T> optional) throws NoSuchElementException;
}
