public class State0 implements StateInterface {
    private MainWindow mainWindow;

    public State0(MainWindow main) {
        mainWindow = main;
    }

    @Override
    public void addHundred() {
        mainWindow.setBalance(mainWindow.balance += 100);
        mainWindow.setState(mainWindow.stateLess500);
    }

    @Override
    public void addFiveHundred() {
        mainWindow.setBalance(mainWindow.balance += 500);
        mainWindow.setState(mainWindow.state500);
    }

    @Override
    public void addThousand() {
        mainWindow.setBalance(mainWindow.balance += 1000);
        mainWindow.setState(mainWindow.stateEqualOrMore1000);
    }

    @Override
    public void returnChanges() {
        mainWindow.setMsgText("");
    }

    @Override
    public void selectBeverage() {

        mainWindow.setMsgText("돈을 넣은 후에 눌러주세요");

    }
}
