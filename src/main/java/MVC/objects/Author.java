package MVC.objects;

import java.util.Objects;

import MVC.gui.AuthorContent;
import MVC.gui.CategoryObject;
import MVC.gui.PersonContent;

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

    @Override
    public CategoryObject asCategoryObject() {
        return new CategoryObject(getName(), new AuthorContent(this));
    }
}
