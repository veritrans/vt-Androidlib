package id.co.veritrans.android.api;

import id.co.veritrans.android.api.VTModel.VTBaseTransaction;

/**
 * Created by Anis on 11/12/2014.
 */
public abstract class VTBaseTransactionMethod {
    protected VTBaseTransaction transaction;

    public abstract void preAuthorize();
    public abstract void capture();
    public abstract void charge();

    public VTBaseTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(VTBaseTransaction transaction) {
        this.transaction = transaction;
    }
}
