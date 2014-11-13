package id.co.veritrans.android.api.VTUtil;

import android.test.InstrumentationTestCase;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import id.co.veritrans.android.api.VTModel.VTAddress;
import id.co.veritrans.android.api.VTModel.VTCustomerDetails;
import id.co.veritrans.android.api.VTModel.VTItemDetails;
import id.co.veritrans.android.api.VTModel.VTTransactionDetails;
import id.co.veritrans.android.api.VTModel.VTWebTransaction;

/**
 * Created by Anis on 11/12/2014.
 */
public class VTJsonGeneratorTest extends InstrumentationTestCase {
    public void testGenerateVTWebJson(){
        VTWebTransaction transaction = new VTWebTransaction();
        //set transaction details
        VTTransactionDetails transactionDetails = new VTTransactionDetails();
        transactionDetails.setOrder_id("909090");
        transactionDetails.setGross_amount(50000);
        //set transaction details
        transaction.setTransaction_details(transactionDetails);

        //set customer details
        VTCustomerDetails customerDetails = new VTCustomerDetails();
        customerDetails.setEmail("test@test.com");
        customerDetails.setFirst_name("TestFirstName");
        customerDetails.setLast_name("TestLastName");
        customerDetails.setPhone("0909090900");

        //set billing and shipping address
        VTAddress billingAndShippingAddress = new VTAddress();
        billingAndShippingAddress.setPhone("0909090");
        billingAndShippingAddress.setLast_name("lastname");
        billingAndShippingAddress.setFirst_name("firstname");
        billingAndShippingAddress.setAddress("address");
        billingAndShippingAddress.setCity("city");
        billingAndShippingAddress.setCountry_code("90909");
        billingAndShippingAddress.setPostal_code("8878");

        customerDetails.setBilling_address(billingAndShippingAddress);
        customerDetails.setShipping_address(billingAndShippingAddress);

        transaction.setCustomer_details(customerDetails);

        //set items
        List<VTItemDetails> itemDetails = new ArrayList<VTItemDetails>();
        for(int i=0;i<2;i++){
            VTItemDetails item = new VTItemDetails();
            item.setId("i90jiji"+i);
            item.setName("item-"+i);
            item.setPrice(10*i + 90);
            item.setQuantity(10*(i+1));
            itemDetails.add(item);
        }
        transaction.setItem_details(itemDetails);

        Gson gson = new Gson();
        String json = gson.toJson(transaction);


        assertNotNull(json);

    }
}
