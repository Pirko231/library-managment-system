package MVC;
import java.util.Optional;


public interface View extends Observer
{
    public void update(Model model);

    public Optional<String[]> getCommand();
}