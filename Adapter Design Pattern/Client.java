public class Client {
    public static void main(String[] args) {
        BankApi bankApi = new YesBankAdapter();
        bankApi.sendMoney();
    }
}
