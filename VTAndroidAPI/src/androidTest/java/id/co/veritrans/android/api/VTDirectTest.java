package id.co.veritrans.android.api;

import android.test.InstrumentationTestCase;
import android.util.Log;

import com.google.gson.Gson;

import id.co.veritrans.android.api.VTInterface.ITokenCallback;
import id.co.veritrans.android.api.VTModel.VTCardDetails;
import id.co.veritrans.android.api.VTModel.VTCardDetailsTest;
import id.co.veritrans.android.api.VTModel.VTToken;
import id.co.veritrans.android.api.VTUtil.VTConfig;

/**
 * Created by Anis on 11/13/2014.
 */
public class VTDirectTest extends InstrumentationTestCase {

    public void testGetTokenSecure(){
        VTConfig.VT_IsProduction = false;
        VTConfig.CLIENT_KEY = "VT-client-3YUXFj6X0XBpeDgf";

        VTDirect vtDirect = new VTDirect();
        VTCardDetails cardDetails = VTCardDetailsTest.CardFactory(true);
        vtDirect.setCard_details(cardDetails);
        vtDirect.getToken(new ITokenCallback() {
            @Override
            public void onSuccess(VTToken token) {
                assertNotNull(token.toString(), token);
                assertNotNull(token.getRedirect_url(),token.getRedirect_url());
                assertNotNull(token.getToken_id(),token.getToken_id());

            }

            @Override
            public void onError(Exception error) {

                assertTrue(error.getMessage(),false);

            }


        });
    }

    public void testGetTokenNotSecure(){

        VTConfig.VT_IsProduction = false;
        VTConfig.CLIENT_KEY = "VT-client-3YUXFj6X0XBpeDgf";

        VTDirect vtDirect = new VTDirect();

        VTCardDetails cardDetails = VTCardDetailsTest.CardFactory(false);
        vtDirect.setCard_details(cardDetails);

        vtDirect.getToken(new ITokenCallback() {
            @Override
            public void onSuccess(VTToken token) {
                assertNotNull(token.toString(),token);
                assertNull(token.getRedirect_url(),token.getRedirect_url());
                assertNotNull(token.getToken_id(),token.getToken_id());
            }

            @Override
            public void onError(Exception error) {

                assertTrue(error.getMessage(),false);

            }


        });
    }
}
