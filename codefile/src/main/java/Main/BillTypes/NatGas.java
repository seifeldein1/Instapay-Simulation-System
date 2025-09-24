package Main.BillTypes;

public class NatGas implements IGas {


    @Override
    public double CalcBill(String ID) {

        return (1.5)*77;
    }
}
