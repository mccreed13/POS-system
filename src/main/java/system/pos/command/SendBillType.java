package system.pos.command;

public enum SendBillType {
    EMAIL, PRINT;

    public SendBillType getByString(String s){
        return switch (s) {
            case "email" -> SendBillType.EMAIL;
            case "print" -> SendBillType.PRINT;
            default -> SendBillType.PRINT;
        };
    }
}
