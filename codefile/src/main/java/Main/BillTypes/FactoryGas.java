package Main.BillTypes;

public class FactoryGas implements IFactoryBills {

    public IGas CreateObj(String CName){

        if(CName.equals("NatGas") )
        {
            return new NatGas();

        }
        else {
            return  new EnergyGas();

        }


    }



}
