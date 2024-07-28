import thirdpartyApi.YesBank;

public class YesBankAdapter implements BankApi{
    YesBank yesBank = new YesBank();
    @Override
    public void sendMoney() {
        yesBank.transferMoney();
    }
}
