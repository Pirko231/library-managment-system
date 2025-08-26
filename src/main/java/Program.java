
import java.util.concurrent.atomic.AtomicBoolean;

import MVC.Controller;
import MVC.DefaultModel;
import MVC.Model;

public class Program {

    public static void main(String[] args) {
        AtomicBoolean running = new AtomicBoolean(true);
        Model model = new DefaultModel(running);
        Controller controller = new Controller(model, running);

        if (args.length > 0) {
            controller.runChain(args);
            return;
        }
    }
}
