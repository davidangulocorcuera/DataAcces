public class Curse {
    private int int_id;
    private String str_mname;
    private String str_mfirst_characteristic;
    private String str_msecond_characteristic;
    private String str_mthird_characteristic;

    public Curse() {
    }// creamos otro constructor para instanciar el objeto sin necesidad
    // de pasarle los parametros

    public Curse(int int_id, String str_mname, String str_mfirst_characteristic, String str_msecond_characteristic, String str_mthird_characteristic) {
        this.int_id = int_id;
        this.str_mname = str_mname;
        this.str_mfirst_characteristic = str_mfirst_characteristic;
        this.str_msecond_characteristic = str_msecond_characteristic;
        this.str_mthird_characteristic = str_mthird_characteristic;
    }

    public int getInt_id() {
        return int_id;
    }

    public void setInt_id(int int_id) {
        this.int_id = int_id;
    }


    public String getStr_mname() {
        return str_mname;
    }

    public void setStr_mname(String str_mname) {
        this.str_mname = str_mname;
    }


    public String getStr_mfirst_characteristic() {
        return str_mfirst_characteristic;
    }

    public void setStr_mfirst_characteristic(String str_mfirst_characteristic) {
        this.str_mfirst_characteristic = str_mfirst_characteristic;
    }


    public String getStr_msecond_characteristic() {
        return str_msecond_characteristic;
    }

    public void setStr_msecond_characteristic(String str_msecond_characteristic) {
        this.str_msecond_characteristic = str_msecond_characteristic;
    }


    public String getStr_mthird_characteristic() {
        return str_mthird_characteristic;
    }

    public void setStr_mthird_characteristic(String str_mthird_characteristic) {
        this.str_mthird_characteristic = str_mthird_characteristic;
    }


    public String toString() {
        String curse = int_id + "\n" + str_mname + "\n" + str_mfirst_characteristic + "\n" + str_msecond_characteristic + "\n" + str_mthird_characteristic;


        return curse;
    }
}
