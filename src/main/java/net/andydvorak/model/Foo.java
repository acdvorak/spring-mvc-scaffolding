package net.andydvorak.model;

/**
 * @author Andrew C. Dvorak
 * @since 3/2/13
 */
@SuppressWarnings("UnusedDeclaration")
public class Foo {

    private Long id;

    public Foo() {
    }

    public Foo(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

}
