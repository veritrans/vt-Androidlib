package id.co.veritrans.android.api;

import java.util.List;

import id.co.veritrans.android.api.VTModel.VTCustomerDetails;
import id.co.veritrans.android.api.VTModel.VTItemDetails;
import id.co.veritrans.android.api.VTModel.VTTransactionDetails;

/**
 * Created by Anis on 11/11/2014.
 */
public class VTWeb extends VTBaseTransactionMethod{


    @Override
    public void preAuthorize() {
        //do nothing, no pre authorize
        throw new UnsupportedOperationException("Don't use pre authorize with VtWeb");
    }

    @Override
    public void capture() {
        throw new UnsupportedOperationException("Don't use capture with VtWeb");
    }

    @Override
    public void charge() {

    }
}
