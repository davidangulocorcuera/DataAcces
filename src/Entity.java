import java.util.HashMap;

public class
Entity {
    private String str_mid;
    private String str_mname;
    private String str_mfirst_characteristic;
    private String str_msecond_characteristic;
    private String Str_mthird_characteristic;


    public Entity(String str_mid, String str_mname, String str_mfirst_characteristic, String str_msecond_characteristic, String str_mthird_characteristic) {
        this.str_mid = str_mid;
        this.str_mname = str_mname;
        this.str_mfirst_characteristic = str_mfirst_characteristic;
        this.str_msecond_characteristic = str_msecond_characteristic;
        this.Str_mthird_characteristic = str_mthird_characteristic;
    }


    public String getFirstCharacteristic() {
        return str_mfirst_characteristic;
    }

    public void setFirstCharacteristic(String str_mfirst_characteristic) {
        this.str_mfirst_characteristic = str_mfirst_characteristic;
    }

    public String getSecondCharacteristic() {
        return str_msecond_characteristic;
    }

    public void setSecondCharacteristic(String str_second_characteristic) {
        this.str_msecond_characteristic = str_msecond_characteristic;
    }

    public String getThirdCharacteristic() {
        return Str_mthird_characteristic;
    }

    public void setThirdCharacteristic(String str_third_characteristic) {
        this.Str_mthird_characteristic = Str_mthird_characteristic;
    }

    public String getName() {
        return str_mname;
    }

    public void setName(String str_mname) {
        this.str_mname = str_mname;
    }

    public String getId() {
        return str_mid;
    }

    public void setId(String str_mid) {
        this.str_mid = str_mid;
    }
}


