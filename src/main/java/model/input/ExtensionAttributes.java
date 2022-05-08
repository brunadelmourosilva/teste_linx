package model.input;

public class ExtensionAttributes {

    private boolean acceptGiftcard;
    private String giftcardCurrency;
    private String giftcardType;

    public ExtensionAttributes() {
    }

    public ExtensionAttributes(boolean acceptGiftcard, String giftcardCurrency, String giftcardType) {
        this.acceptGiftcard = acceptGiftcard;
        this.giftcardCurrency = giftcardCurrency;
        this.giftcardType = giftcardType;
    }

    public boolean isAcceptGiftcard() {
        return acceptGiftcard;
    }

    public void setAcceptGiftcard(boolean acceptGiftcard) {
        this.acceptGiftcard = acceptGiftcard;
    }

    public String getGiftcardCurrency() {
        return giftcardCurrency;
    }

    public void setGiftcardCurrency(String giftcardCurrency) {
        this.giftcardCurrency = giftcardCurrency;
    }

    public String getGiftcardType() {
        return giftcardType;
    }

    public void setGiftcardType(String giftcardType) {
        this.giftcardType = giftcardType;
    }

    @Override
    public String toString() {
        return "ExtensionAttributes{" +
                "\nacceptGiftcard=" + acceptGiftcard +
                "\n, giftcardCurrency='" + giftcardCurrency + '\'' +
                "\n, giftcardType='" + giftcardType + '\'' +
                '}';
    }
}
