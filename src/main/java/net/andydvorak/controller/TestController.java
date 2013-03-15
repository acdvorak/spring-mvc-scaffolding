package net.andydvorak.controller;

import net.andydvorak.model.Foo;
import net.andydvorak.service.AlreadyExistsException;
import net.andydvorak.service.FooService;
import net.andydvorak.service.NotFoundException;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

/**
 * @author Andrew C. Dvorak
 * @since 3/2/13
 */
@Controller
@RequestMapping("/test")
final class FooController{
    @Autowired
    FooService fooService;

    final Logger logger = LoggerFactory.getLogger(FooController.class);

    @RequestMapping( method = RequestMethod.GET )
    @ResponseBody
    public final List<Foo> getAll(){
        return fooService.getAll();
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    @ResponseBody
    public final Foo get( @PathVariable( "id" ) final Long id ){
        checkNotNull(fooService.getById(id));
        return fooService.getById(id);
    }

    @RequestMapping( method = RequestMethod.POST )
    @ResponseStatus( HttpStatus.CREATED )
    @ResponseBody
    public final Long create( @RequestBody final Foo entity ){
        checkNotNull(entity);
        return fooService.create(entity);
    }

    @RequestMapping( method = RequestMethod.PUT )
    @ResponseStatus( HttpStatus.OK )
    public final void update( @RequestBody final Foo entity ){
        checkNotNull(entity);
        if (fooService.exists(entity.getId())) {
            fooService.update(entity);
        } else {
            fooService.create(entity);
        }
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PUT )
    @ResponseStatus( HttpStatus.OK )
    public final void update( @PathVariable( "id" ) final Long id, @RequestBody final Foo entity ){
        checkNotNull(entity);
        checkState(ObjectUtils.equals(id, entity.getId()));
        if (fooService.getById(id) == null) {
            fooService.create(entity);
        } else {
            fooService.update(entity);
        }
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    @ResponseStatus( HttpStatus.OK )
    public final void delete( @PathVariable( "id" ) final Long id ){
        fooService.deleteById(id);
    }

    @ExceptionHandler( NotFoundException.class )
    @ResponseStatus( value = HttpStatus.NOT_FOUND )
    public void handleNotFoundException(NotFoundException ex,
                                        HttpServletResponse response) {
        logger.info("Handlng NotFoundException - Catching: "
                + ex.getClass().getSimpleName());
    }

    @ExceptionHandler( AlreadyExistsException.class )
    @ResponseStatus( value = HttpStatus.CONFLICT )
    public void handleAlreadyExistsException(AlreadyExistsException ex,
                                             HttpServletResponse response) {
        logger.info("Handlng AlreadyExistsException - Catching: "
                + ex.getClass().getSimpleName());
    }
}
