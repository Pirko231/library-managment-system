package MVC;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class Controller {

    private View view;
    private Model model;
    private AtomicBoolean isActive;

    public Controller(Model model, AtomicBoolean isActive) {
        this.model = model;
        this.isActive = isActive;
    }

    public boolean running() {
        return isActive.get();
    }

    public void startGui() {
        view = new GUIView(this, model);
    }

    public void addBook(String title, String author) {
        runChain(("add book " + title + " : " + author).split(" "));
    }

    public void removeBook(String title, String author) {
        runChain(("remove book " + title + " : " + author).split(" "));
    }

    public void addPerson(String name, String surname) {
        runChain(("add person " + name + ":" + surname).split(" "));
    }

    public void runChain(String[] args) {
        model.sendCommand(args);
    }

    public void writeToFiles(File file) {
        model.writeToFiles(file);
    }

    public void readFile(File file) {
        model.readFile(file);
    }
}
