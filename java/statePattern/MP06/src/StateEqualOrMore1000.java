public class StateEqualOrMore1000 implements StateInterface {
    private MainWindow mainWindow;

    public StateEqualOrMore1000(MainWindow main) {
        mainWindow = main;
    }

    @Override
    public void addHundred() {
        mainWindow.setBalance(mainWindow.balance += 100);
    }

    @Override
    public void addFiveHundred() {
        mainWindow.setBalance(mainWindow.balance += 500);
    }

    @Override
    public void addThousand() {
        mainWindow.setBalance(mainWindow.balance += 1000);
        mainWindow.setMsgText("이미 충분한 돈이 투입되었습니다. 음료를 선택하세요");
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
        String msg = "음료를 내보냅니다. 배출구를 확인하세요.";
        mainWindow.setBalance(mainWindow.balance -= 1000);
        if (mainWindow.balance > 0) {
            msg = msg + " 거스름돈 " + mainWindow.balance + "원을 반환합니다.";
            mainWindow.setBalance(0);
        }
        mainWindow.setBalanceText();
        mainWindow.setMsgText(msg);
        mainWindow.setState(mainWindow.state0);
    }
}
