package Main.WalletProviders;

public class WalletFactory {
    public IWallet createWallet(String providerName) {
        String type=providerName.substring(0,3);
        if (type.equalsIgnoreCase("010")) {
            return new Vodafone();
        } else if (type.equalsIgnoreCase("012")) {
            return new Orange();
        } else {
            throw new IllegalArgumentException("Unknown wallet provider: " + providerName);
        }
    }
}
