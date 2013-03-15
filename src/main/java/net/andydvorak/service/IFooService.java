package net.andydvorak.service;

import net.andydvorak.model.Foo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Andrew C. Dvorak
 * @since 3/2/13
 */
@Service
public interface IFooService {
    public List<Foo> getAll();
    public Foo getById(final Long id);
    public Long create(final Foo entity);
    public Foo deleteById(final Long id);
    public Foo update(final Foo entity);
}
