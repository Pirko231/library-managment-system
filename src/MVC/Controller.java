package MVC;

import java.util.concurrent.atomic.AtomicBoolean;

public class Controller {

    private View view;
    private Model model;
    private AtomicBoolean isActive;

    public Controller(View view, Model model, AtomicBoolean isActive) {
        this.view = view;
        this.model = model;
        this.isActive = isActive;
    }

    public boolean running() {
        return isActive.get();
    }

    public void update() {
        var command = view.getCommand();
        if (command.isPresent()) {
            model.sendCommand(command.get());

        }
    }

    public void runChain(String[] args) {
        model.sendCommand(args);
    }
}
