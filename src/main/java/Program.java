
import java.util.concurrent.atomic.AtomicBoolean;

import MVC.Controller;
import MVC.DefaultModel;
import MVC.Model;
import MVC.TerminalView;
import MVC.GUIView;
import MVC.View;

public class Program {

    public static void main(String[] args) {
        AtomicBoolean running = new AtomicBoolean(true);
        View view = new GUIView();
        Model model = new DefaultModel(running);
        Controller controller = new Controller(view, model, running);

        if (args.length > 0) {
            controller.runChain(args);
            return;
        }

        while (controller.running()) {
            controller.update();
        }
        controller.writeToFiles();
    }
}
