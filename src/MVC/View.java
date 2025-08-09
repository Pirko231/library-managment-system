package MVC;
import java.util.Optional;


public interface View
{
    public void draw();

    public Optional<String[]> getCommand();
}