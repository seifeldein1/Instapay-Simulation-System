package Main.BillTypes;

public class Elec_SouthCairo implements IElectric{
    @Override
    public double CalcBill(String ID) {
        return 17*70;
    }
}
