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

    Map<Long, Foo> foos = new HashMap<Long, Foo>();

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
