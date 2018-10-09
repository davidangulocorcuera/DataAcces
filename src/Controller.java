import javax.naming.ldap.Control;
import java.util.HashMap;
import java.util.Scanner;

public class Controller extends BbddModel {
    DataManager acces;


    public DataManager getAcces() {
        return acces;
    }

    public void DataManager(DataManager acces) {
        this.acces = acces;
    }


}