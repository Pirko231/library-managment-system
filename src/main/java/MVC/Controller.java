package MVC;

import java.util.concurrent.atomic.AtomicBoolean;

public class Controller {

    private View view;
    private Model model;
    private AtomicBoolean isActive;

    public Controller(Model model, AtomicBoolean isActive) {
        view = new GUIView();
        this.model = model;
        this.isActive = isActive;
    }

    public boolean running() {
        return isActive.get();
    }

    public void addBook(String title, String author) {
        runChain(("add book " + title + " : " + author).split(" "));
    }

    public void addPerson(String name, String surname) {
        runChain(("add person " + name + ":" + surname).split(" "));
    }

    public void runChain(String[] args) {
        model.sendCommand(args);
    }

    public void writeToFiles() {
        model.writeToFiles();
    }
}
