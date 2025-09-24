package Main.BillTypes;

public class FactoryWater implements IFactoryBills {
    public IWater CreateObj(String CName){

        if(CName.equals("WaterAlex") ) {
            return new WaterAlex();
        }else {
            return  new WaterCairo();

        }


    }
}
