package id.co.veritrans.android.api.VTModel;

import android.test.InstrumentationTestCase;

import id.co.veritrans.android.api.VTUtil.VTConfig;

/**
 * Created by Anis on 11/13/2014.
 */
public class VTCardDetailsTest extends InstrumentationTestCase {
    public void testGenerateJsonSecure(){

        VTConfig.VT_IsProduction = false;
        VTConfig.CLIENT_KEY = "VT-client-3YUXFj6X0XBpeDgf";

        VTCardDetails cardDetails = VTCardDetailsTest.CardFactory(true);
        String url = VTConfig.getTokenUrl()+cardDetails.getParamUrl();
        String testUrl = VTConfig.getTokenUrl()+
                "?card_number=4811111111111114" +
                "&card_exp_month=1" +
                "&card_exp_year=2020" +
                "&card_cvv=123" +
                "&client_key="+VTConfig.CLIENT_KEY +
                "&secure=true" +
                "&gross_amount=1000000";
        assertNotNull(url);
        assertEquals(testUrl,url);

        cardDetails.setBank("bni");
        //test with bank
        String urlWithBank = VTConfig.getTokenUrl() + cardDetails.getParamUrl();
        String testUrlWithBank = VTConfig.getTokenUrl()+
                "?card_number=4811111111111114" +
                "&card_exp_month=1" +
                "&card_exp_year=2020" +
                "&card_cvv=123" +
                "&client_key="+VTConfig.CLIENT_KEY +
                "&secure=true" +
                "&bank=bni" +
                "&gross_amount=1000000";
        assertEquals(urlWithBank,testUrlWithBank);
    }

    public static VTCardDetails CardFactory(boolean secure){
        VTCardDetails cardDetails = new VTCardDetails();
        cardDetails.setCard_number("4811111111111114");
        cardDetails.setCard_cvv("123");
        cardDetails.setCard_exp_month(1);
        cardDetails.setCard_exp_year(2020);
        cardDetails.setSecure(secure);
        cardDetails.setGross_amount("1000000");
        return cardDetails;
    }
}
