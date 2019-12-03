public class State500 implements StateInterface {
    private MainWindow mainWindow;

    public State500(MainWindow main) {
        mainWindow = main;
    }

    @Override
    public void addHundred() {
        mainWindow.setBalance(mainWindow.balance += 100);
        mainWindow.setState(mainWindow.stateLess1000);
    }

    @Override
    public void addFiveHundred() {
        mainWindow.setBalance(mainWindow.balance += 500);
        mainWindow.setState(mainWindow.stateEqualOrMore1000);
    }

    @Override
    public void addThousand() {
        mainWindow.setBalance(mainWindow.balance += 1000);
        mainWindow.setState(mainWindow.stateEqualOrMore1000);
        mainWindow.setMsgText("");
    }

    @Override
    public void returnChanges() {
        mainWindow.setState(mainWindow.state0);
        mainWindow.setMsgText("" + mainWindow.balance + "원을 반환합니다");
        mainWindow.setBalance(0);
        mainWindow.setBalanceText();
    }

    @Override
    public void selectBeverage() {
        mainWindow.setMsgText("1000원 이상을 넣은 후에 눌러주세요");
    }
}
