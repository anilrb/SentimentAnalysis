package component;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Address {


    private int galiNo;

    private String address;

    public int getGaliNo() {
        return galiNo;
    }

    public void setGaliNo(int galiNo) {
        this.galiNo = galiNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "galiNo=" + galiNo +
                ", address='" + address + '\'' +
                '}';
    }
}
