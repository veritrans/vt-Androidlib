package id.co.veritrans.android.api.VTModel;

/**
 * Created by Anis on 11/11/2014.
 */
public class VTCustomerDetails {

    private String first_name;
    private String last_name;
    private String email;
    private String phone;

    private VTAddress billing_address;
    private VTAddress shipping_address;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public VTAddress getBilling_address() {
        return billing_address;
    }

    public void setBilling_address(VTAddress billing_address) {
        this.billing_address = billing_address;
    }

    public VTAddress getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(VTAddress shipping_address) {
        this.shipping_address = shipping_address;
    }

}
