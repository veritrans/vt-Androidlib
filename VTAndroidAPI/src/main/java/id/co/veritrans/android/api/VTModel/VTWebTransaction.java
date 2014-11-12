package id.co.veritrans.android.api.VTModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anis on 11/12/2014.
 */

public class VTWebTransaction extends VTBaseTransaction {

    public static String VTWeb_PAYMENT_TYPE = "vtweb";
    public static String VT_3D_Secure_Key = "credit_card_3d_secure";

    private Map<String,String> vtweb;

    /**
     * Default Constructor for VTWebTransaction
     * Default Value for 3d Secure is true
     */
    public VTWebTransaction(){
        super();
        this.setPayment_type(VTWeb_PAYMENT_TYPE);
        vtweb = new HashMap<String, String>();
        vtweb.put(VT_3D_Secure_Key, "true");
    }

    /**
     * Manually put 3d secure value to options
     * @param is3DSecured indicates if transaction is 3dsecured or not
     */
    public void set3DSecureValue(boolean is3DSecured){
        vtweb.put(VT_3D_Secure_Key, String.valueOf(is3DSecured));
    }

    /**
     * Get current value of 3d secure
     * @return Whether 3d secure is enabled or not
     */
    public boolean get3DSecureValue(){
        return Boolean.valueOf((String)vtweb.get(VT_3D_Secure_Key));
    }
}
