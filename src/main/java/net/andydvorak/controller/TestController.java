package net.andydvorak.controller;

import net.andydvorak.model.Foo;
import net.andydvorak.service.IFooService;
import net.andydvorak.service.LocalFooService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Andrew C. Dvorak
 * @since 3/2/13
 */
@Controller
@RequestMapping( value = "/test" )
final class FooController{
//    @Autowired
//    IFooService fooService;
    IFooService fooService = new LocalFooService();

    @RequestMapping( method = RequestMethod.GET )
    @ResponseBody
    public final List<Foo> getAll(){
        return fooService.getAll();
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    @ResponseBody
    public final Foo get( @PathVariable( "id" ) final Long id ){
//        return RestPreconditions.checkNotNull(fooService.getById(id));
        return fooService.getById(id);
    }

    @RequestMapping( method = RequestMethod.POST )
    @ResponseStatus( HttpStatus.CREATED )
    @ResponseBody
    public final Long create( @RequestBody final Foo entity ){
//        RestPreconditions.checkNotNullFromRequest( entity );
        return fooService.create( entity );
    }

    @RequestMapping( method = RequestMethod.PUT )
    @ResponseStatus( HttpStatus.OK )
    public final void update( @RequestBody final Foo entity ){
//        RestPreconditions.checkNotNullFromRequest( entity );
//        RestPreconditions.checkNotNull( fooService.getById( entity.getId() ) );
        fooService.update(entity);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    @ResponseStatus( HttpStatus.OK )
    public final void delete( @PathVariable( "id" ) final Long id ){
        fooService.deleteById(id);
    }
}
