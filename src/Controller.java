import javax.naming.ldap.Control;
import java.util.HashMap;
import java.util.Scanner;

public class Controller extends BbddModel {
    DataManager acces;

    public BbddModel getBbddModel() {
        return bbddModel;
    }

    BbddModel bbddModel= new BbddModel();

    public DataManager getAcces() {
        return acces;
    }
    public void BbddModel(BbddModel bbddModel) {
        this.bbddModel = bbddModel;
    }
    public void DataManager(DataManager acces) {
        this.acces = acces;
    }


}