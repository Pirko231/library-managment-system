package MVC.commandChain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicBoolean;


public class QuitMiddlewareTest {
    
    @Test
    public void testCheck() {
        AtomicBoolean running = new AtomicBoolean(true);
        QuitMiddleware qMiddleware = new QuitMiddleware(running);
        qMiddleware.check("q".split(""));
        assertEquals(running.get(), false);
        running.set(true);
        qMiddleware.check("quit".split(""));
        assertEquals(running.get(), false);
    }
}
