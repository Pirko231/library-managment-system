
import java.util.concurrent.atomic.AtomicBoolean;

import MVC.*;

public class Program {

    public static void main(String[] args) {
        AtomicBoolean running = new AtomicBoolean(true);
        View view = new TerminalView();
        Model model = new DefaultModel(running);
        Controller controller = new Controller(view, model, running);

        while (controller.running()) {
            controller.update();
        }
    }
}
