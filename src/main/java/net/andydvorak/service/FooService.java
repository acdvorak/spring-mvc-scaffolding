package net.andydvorak.service;

import net.andydvorak.model.Foo;

import java.util.List;

/**
 * @author Andrew C. Dvorak
 * @since 3/2/13
 */
public interface FooService {
    public List<Foo> getAll();

    public boolean exists(final Long id);

    public Foo getById(final Long id) throws NotFoundException;

    public Long create(final Foo entity) throws AlreadyExistsException;

    public Foo deleteById(final Long id) throws NotFoundException;

    public Foo update(final Foo entity);
}

