package system.pos.command;

public interface BillSender {
    void send(String bill);
    SendBillType getType();
}
