package system.pos.command;

import org.springframework.stereotype.Component;

@Component
public class PrinterBillSender implements BillSender {

    @Override
    public void send(String bill) {
        System.out.println("BILL PRINTED");
        System.out.println(bill);
    }

    @Override
    public SendBillType getType() {
        return SendBillType.PRINT;
    }
}
