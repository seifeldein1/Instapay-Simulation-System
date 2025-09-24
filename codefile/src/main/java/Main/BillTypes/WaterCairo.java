package Main.BillTypes;

public class WaterCairo implements IWater {
    @Override
    public double CalcBill(String ID) {
        return 4.4*42;
    }
}
