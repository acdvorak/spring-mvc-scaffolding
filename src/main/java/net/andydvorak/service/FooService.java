package net.andydvorak.service;

import net.andydvorak.model.Foo;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author Andrew C. Dvorak
 * @since 3/2/13
 */
public interface FooService {
    public List<Foo> getAll();

    @Nullable
    public Foo getById(final Long id);

    public Long create(final Foo entity);

    @Nullable
    public Foo deleteById(final Long id);

    public Foo update(final Foo entity);
}

