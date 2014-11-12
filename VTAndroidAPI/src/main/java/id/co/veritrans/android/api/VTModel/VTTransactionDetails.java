package id.co.veritrans.android.api.VTModel;

import java.util.List;

/**
 * Created by Anis on 11/11/2014.
 */
public class VTTransactionDetails {
    private String order_id;
    private int gross_amount;


    /**
     * Default Constructor
     * If you use this, never forget to set order_id and gross_amount manually
     * Better use constructor with specified order_id and gross_amount
     */
    public VTTransactionDetails(){
        order_id = null;
        gross_amount = 0;
    }

    /**
     * Create a new VTTransactionDetails with specified order_id and gross_amount
     * @param orderId Id of Ordered items
     * @param gross_amount Total Price of items
     */
    public VTTransactionDetails(String orderId, int gross_amount) {
        this.order_id = orderId;
        this.gross_amount = gross_amount;
    }

    /**
     * Get Order Id
     * @return Order Id
     */
    public String getOrder_id() {
        return order_id;
    }

    /**
     * Set Order Id
     * @param order_id
     */
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    /**
     * Get Price
     * @return Total Price
     */
    public int getGross_amount() {
        return gross_amount;
    }

    /**
     * Set total gross_amount
     * @param gross_amount gross_amount
     */
    public void setGross_amount(int gross_amount) {
        this.gross_amount = gross_amount;
    }


}