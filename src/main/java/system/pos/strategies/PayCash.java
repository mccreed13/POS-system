package system.pos.strategies;

public class PayCash implements PayStrategy{

    @Override
    public boolean pay(double paymentAmount) {
        return true;
    }
}
