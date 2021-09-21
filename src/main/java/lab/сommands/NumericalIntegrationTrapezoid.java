package lab.сommands;

import lab.interfaces.ICommand;
import lab.interfaces.IFunc;
import lab.modules.MenuModule;
import lab.modules.TrapezoidIntegral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NumericalIntegrationTrapezoid implements ICommand {
    @Override
    public String getMessage() {
        return "Нахождение интегралов методом Трапеций";
    }

    @Override
    public void execute() {
        ArrayList<ICommand> commands = new ArrayList<>();
        HashMap<String, IFunc> funcHashMap = new HashMap<>();
        funcHashMap.put("2x", x -> 2 * x);
        funcHashMap.put("1/x", x -> 1/x);
        funcHashMap.put("sin(x)/x", x -> Math.sin(x)/x);
        funcHashMap.put("x^2", x -> Math.pow(x, 2));

        for(Map.Entry<String, IFunc> entry : funcHashMap.entrySet()) {
            commands.add(new ICommand() {
                @Override
                public String getMessage() {
                    return entry.getKey();
                }
                @Override
                public void execute() {
                    TrapezoidIntegral.execute(entry.getValue());
                }
            });
        }
        MenuModule menu = new MenuModule(commands);
        menu.execute();
    }
}
