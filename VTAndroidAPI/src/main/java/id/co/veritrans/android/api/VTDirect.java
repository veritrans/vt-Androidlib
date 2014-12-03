package id.co.veritrans.android.api;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Objects;

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
            String url = VTConfig.getTokenUrl() + getCard_details().getParamUrl();
            new GetTokenAsync(callback).execute(url);
        }
    }

    class GetTokenAsync extends AsyncTask<String,Void,Object>{

        ITokenCallback callback;
        public  GetTokenAsync(ITokenCallback callback){
            this.callback = callback;
        }

        @Override
        protected Object doInBackground(String... strings) {
            String url = strings[0];
            try {
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
                    return token;
                }else{
                    return new Exception(token.getStatus_message());
                }

            } catch (IOException e) {
                e.printStackTrace();
                return e;
            } catch (IllegalArgumentException e){
                e.printStackTrace();
                return e;
            } catch (Exception e){
                e.printStackTrace();
                return e;
            }
        }

        @Override
        protected void onPostExecute(Object obj) {
            if(obj instanceof VTToken){
                VTToken token = (VTToken)obj;
                callback.onSuccess(token);
            }else if(obj instanceof Exception){
                Exception ex = (Exception)obj;
                callback.onError(ex);
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
