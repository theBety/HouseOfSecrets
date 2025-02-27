package Commands;

public class EndGame implements Command{
    @Override
    public String execute() {
        return "Ending game";
    }

    @Override
    public Boolean exit() {
        return true;
    }
}
