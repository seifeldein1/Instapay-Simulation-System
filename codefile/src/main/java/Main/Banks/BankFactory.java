package Main.Banks;

public class BankFactory {

    public  IBank createBank(String providerName) {

        if ("123456".equalsIgnoreCase(providerName)||"alahly".equals(providerName)) {
            return new Alahly();
        } else if ("777777".equalsIgnoreCase(providerName)||"cib".equals(providerName)) {
            return new CIB();
        } else {
            throw new IllegalArgumentException("Unknown bank : " + providerName);
        }
    }
}
