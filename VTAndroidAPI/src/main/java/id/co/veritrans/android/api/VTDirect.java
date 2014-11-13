package id.co.veritrans.android.api;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

import id.co.veritrans.android.api.VTInterface.ITokenCallback;
import id.co.veritrans.android.api.VTModel.VTCardDetails;
import id.co.veritrans.android.api.VTModel.VTToken;
import id.co.veritrans.android.api.VTUtil.VTConfig;

/**
 * Created by Anis on 11/13/2014.
 */
public class VTDirect extends VTBaseTransactionMethod {

    private VTCardDetails card_details;

    @Override
    public void preAuthorize() {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    @Override
    public void capture() {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    @Override
    public void charge() {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    @Override
    public void getToken(ITokenCallback callback) {
        if(callback != null && getCard_details() != null){
            try {
                String url = VTConfig.getTokenUrl() + getCard_details().getParamUrl();
                URI uri = URI.create(url);
                HttpGet httpRequest = new HttpGet(uri);
                HttpClient httpClient = new DefaultHttpClient();
                HttpResponse response = httpClient.execute(httpRequest);
                BufferedReader reader = new BufferedReader(
                  new InputStreamReader(response.getEntity().getContent(),"UTF-8")
                );
                String line = null;
                StringBuilder sb = new StringBuilder();
                // Read Server Response
                while ((line = reader.readLine()) != null) {
                    // Append server response in string
                    sb.append(line + "");
                }
                String json = sb.toString();
                Gson gson = new Gson();
                VTToken token = gson.fromJson(json,VTToken.class);
                if(token.getStatus_code() == 200){
                    callback.onSuccess(token);
                }else{
                    throw new Exception(token.getStatus_message());
                }

            } catch (IOException e) {
                e.printStackTrace();
                callback.onError(e);
            } catch (IllegalArgumentException e){
                e.printStackTrace();
                callback.onError(e);
            } catch (Exception e){
                e.printStackTrace();
                callback.onError(e);
            }
        }
    }

    public VTCardDetails getCard_details() {
        return card_details;
    }

    public void setCard_details(VTCardDetails card_details) {
        this.card_details = card_details;
    }
}
