package system.pos.command;

import org.springframework.stereotype.Component;

@Component
public class EmailBillSender implements BillSender {
    @Override
    public void send(String bill) {
        System.out.println("BILL SEND BY EMAIL");
        System.out.println(bill);
    }

    @Override
    public SendBillType getType() {
        return SendBillType.EMAIL;
    }
}
