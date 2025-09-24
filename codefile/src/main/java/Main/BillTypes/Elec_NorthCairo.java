package Main.BillTypes;

public class Elec_NorthCairo implements IElectric{
    @Override
    public double CalcBill(String ID) {
        return 10*200;
    }
}
