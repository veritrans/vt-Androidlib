package id.co.veritrans.android.api.VTUtil;

/**
 * Created by Anis on 11/12/2014.
 */
public class VTConfig {
    public static String CLIENT_KEY;

    private static String VT_Token_URL = "https://api.veritrans.co.id/v2/token";
    private static String VT_Token_Sandbox_URL = "https://api.sandbox.veritrans.co.id/v2/token";

    public static boolean VT_IsProduction = false;


    public static String getTokenUrl(){
        if(VT_IsProduction){
            return VT_Token_URL;
        }
        return VT_Token_Sandbox_URL;
    }


}
