package net.andydvorak.service;

import net.andydvorak.model.Foo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.mysema.query.alias.Alias.$;
import static com.mysema.query.alias.Alias.alias;
import static com.mysema.query.collections.MiniApi.from;

/**
 * @author Andrew C. Dvorak
 * @since 3/2/13
 */
@Service
public class LocalFooService implements IFooService {

    List<Foo> foos = new ArrayList<Foo>();
    Foo fooAlias = alias(Foo.class, "foo");

    @Override
    public List<Foo> getAll() {
        return foos;
    }

    @Override
    public Foo getById(final Long id) {
        return from($(fooAlias), foos)
              .where($(fooAlias.getId()).eq(id))
              .singleResult($(fooAlias));
    }

    @Override
    public Long create(final Foo entity) {
        foos.add(entity);
        return entity.getId();
    }

    @Override
    @Nullable
    public Foo deleteById(final Long id) {
        final Iterator<Foo> iterator = foos.iterator();
        while (iterator.hasNext()) {
            final Foo foo = iterator.next();
            if (ObjectUtils.equals(foo.getId(), id)) {
                iterator.remove();
                return foo;
            }
        }
        return null;
    }

    @Override
    public Foo update(final Foo entity) {
        return entity;
    }
}
