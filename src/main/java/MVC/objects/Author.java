package MVC.objects;

import java.util.Objects;

public class Author extends Person {

    public Author(String name, String surname) {
        super(name,surname);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
