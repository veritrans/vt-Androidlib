package id.co.veritrans.android.api.VTModel;

import java.util.List;

/**
 * Created by Anis on 11/12/2014.
 */
public abstract class VTBaseTransaction {

    protected String payment_type;
    protected VTTransactionDetails transaction_details;
    protected VTCustomerDetails customer_details;
    protected List<VTItemDetails> item_details;

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public VTTransactionDetails getTransaction_details() {
        return transaction_details;
    }

    public void setTransaction_details(VTTransactionDetails transaction_details) {
        this.transaction_details = transaction_details;
    }

    public VTCustomerDetails getCustomer_details() {
        return customer_details;
    }

    public void setCustomer_details(VTCustomerDetails customer_details) {
        this.customer_details = customer_details;
    }

    public List<VTItemDetails> getItem_details() {
        return item_details;
    }

    public void setItem_details(List<VTItemDetails> item_details) {
        this.item_details = item_details;
    }
}
