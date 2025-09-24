package Main.BillTypes;

public class EnergyGas implements IGas {
    @Override
    public double CalcBill(String ID)
    {
        return 2.7*77;
    }
}
