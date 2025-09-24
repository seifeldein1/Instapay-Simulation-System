package Main.BillTypes;

public class FactoryElectric implements  IFactoryBills
{
    public IElectric CreateObj(String CName){

        if(CName.equals("NorthCairo") )
        {
            return new Elec_NorthCairo();

        }
        else {
            return  new Elec_SouthCairo();

        }


    }



}
