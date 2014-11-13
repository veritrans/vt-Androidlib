package id.co.veritrans.android.api.VTInterface;

import id.co.veritrans.android.api.VTModel.VTToken;

/**
 * Created by Anis on 11/13/2014.
 */
public interface ITokenCallback {

    public void onSuccess(VTToken token);
    public void onError(Exception error);
}
