import javax.naming.ldap.Control;
import java.util.HashMap;
import java.util.Scanner;

public class Controller {
    DataManager acces;


    ProfileManager profile;

    public ProfileManager getProfile() {
        return profile;
    }


    public DataManager getAcces() {
        return acces;
    }

    public void DataManager(DataManager acces, ProfileManager profile) {
        this.acces = acces;
        this.profile = profile;
    }


}
