public class Curse implements ProfileManager {
    private String str_mid;
    private String str_mname;
    private String str_mfirst_characteristic;
    private String str_msecond_characteristic;
    private String str_mthird_characteristic;

    public Curse() {}// creamos otro constructor para instanciar el objeto sin necesidad
    // de pasarle los parametros

    public Curse(String str_mid, String str_mname, String str_mfirst_characteristic, String str_msecond_characteristic, String str_mthird_characteristic) {
        this.str_mid = str_mid;
        this.str_mname = str_mname;
        this.str_mfirst_characteristic = str_mfirst_characteristic;
        this.str_msecond_characteristic = str_msecond_characteristic;
        this.str_mthird_characteristic = str_mthird_characteristic;
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

    public void setSecondCharacteristic(String str_msecond_characteristic) {
        this.str_msecond_characteristic = str_msecond_characteristic;
    }

    public String getThirdCharacteristic() {
        return str_mthird_characteristic;
    }

    public void setThirdCharacteristic(String str_mthird_characteristic) {
        this.str_mthird_characteristic = str_mthird_characteristic;
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


    public String toString(){
        String curse = str_mid + "\n" + str_mname + "\n" + str_mfirst_characteristic + "\n" + str_msecond_characteristic + "\n" + str_mthird_characteristic;


        return curse;
    }
}
