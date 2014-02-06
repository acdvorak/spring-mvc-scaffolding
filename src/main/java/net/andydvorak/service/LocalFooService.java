package net.andydvorak.service;

import net.andydvorak.model.Foo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Andrew C. Dvorak
 * @since 3/2/13
 */
@Service
public class LocalFooService implements FooService {

    final Map<Long, Foo> foos = new HashMap<Long, Foo>();

    public LocalFooService() {
        foos.put(1L, new Foo(1L));
        foos.put(2L, new Foo(2L));
        foos.put(3L, new Foo(3L));
        foos.put(4L, new Foo(4L));
    }

    @Override
    public List<Foo> getAll() {
        return new ArrayList<Foo>(foos.values());
    }

    @Override
    public boolean exists(final Long id) {
        return foos.containsKey(id);
    }

    @Override
    public Foo getById(final Long id) throws NotFoundException {
        if (!foos.containsKey(id)) {
            throw new NotFoundException();
        }
        return foos.get(id);
    }

    @Override
    public Long create(final Foo entity) throws AlreadyExistsException {
        if (foos.containsKey(entity.getId())) {
            throw new AlreadyExistsException();
        }
        foos.put(entity.getId(), entity);
        return entity.getId();
    }


    @Override
    public Foo deleteById(Long id) throws NotFoundException {
        if (!foos.containsKey(id)) {
            throw new NotFoundException();
        }
        return foos.remove(id);
    }

    @Override
    public Foo update(final Foo entity) {
        foos.put(entity.getId(), entity);
        return entity;
    }

}
