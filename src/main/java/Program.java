
import java.awt.EventQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import MVC.Controller;
import MVC.DefaultModel;
import MVC.Model;

public class Program {

    public static void main(String[] args) {
        AtomicBoolean running = new AtomicBoolean(true);
        Model model = new DefaultModel(running);
    
        if (args.length > 0) {
            new Controller(model, running).runChain(args);
            return;
        }
    
        EventQueue.invokeLater(() -> {
            Controller controller = new Controller(model, running);
            controller.startGui();   // whatever opens your first window
        });
    }
}
