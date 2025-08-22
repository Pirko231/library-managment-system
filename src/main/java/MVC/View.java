package MVC;
import java.util.Optional;


public interface View extends Observer
{
    public void draw();

    public Optional<String[]> getCommand();
}