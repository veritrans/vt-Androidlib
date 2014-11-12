package id.co.veritrans.android.api.VTUtil;

import android.test.InstrumentationTestCase;

import id.co.veritrans.android.api.VTModel.VTTransactionDetails;
import id.co.veritrans.android.api.VTModel.VTWebTransaction;

/**
 * Created by Anis on 11/12/2014.
 */
public class VTJsonGeneratorTest extends InstrumentationTestCase {
    public void testGenerateVTWebJson(){
        VTWebTransaction transaction = new VTWebTransaction();
        VTTransactionDetails transactionDetails = new VTTransactionDetails();
        transactionDetails.setOrder_id("909090");
        transactionDetails.setGross_amount(50000);


    }
}
