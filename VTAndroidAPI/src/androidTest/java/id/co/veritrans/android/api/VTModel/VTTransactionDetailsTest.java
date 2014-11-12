package id.co.veritrans.android.api.VTModel;

import android.test.InstrumentationTestCase;

/**
 * Created by Anis on 11/11/2014.
 */
public class VTTransactionDetailsTest extends InstrumentationTestCase {

    public void testDefaultInstantiate(){
        VTTransactionDetails vtDetails = new VTTransactionDetails();
        assertNotNull(vtDetails);
    }

    public  void testGetOrderId(){
        VTTransactionDetails vtDetails = new VTTransactionDetails();
        assertNull(vtDetails.getOrder_id());
    }

    public  void testSetOrderId(){
        VTTransactionDetails vtDetails = new VTTransactionDetails();
        vtDetails.setOrder_id("productId");
    }


    public void testInstantiateWithParameter(){
        VTTransactionDetails vtDetails = new VTTransactionDetails("product-id",9393993);
        assertEquals(vtDetails.getOrder_id(),"product-id");

    }
}
