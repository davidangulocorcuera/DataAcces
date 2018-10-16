public class
Entity {
    private String str_mid;
    private String str_mname;
    private String str_mfirst_characteristic;
    private String str_msecond_characteristic;
    private String str_mthird_characteristic;
    private Curse curse;
    private Curse int_idCurse;

    public Curse getInt_idCurse() {
        return int_idCurse;
    }

    public void setInt_idCurse(Curse int_idCurse) {
        this.int_idCurse = int_idCurse;
    }


    public Entity() {
    }
    public Entity(String str_mid, String str_mname, String str_mfirst_characteristic, String str_msecond_characteristic, String str_mthird_characteristic, Curse curse) {
        this.str_mid = str_mid;
        this.str_mname = str_mname;
        this.str_mfirst_characteristic = str_mfirst_characteristic;
        this.str_msecond_characteristic = str_msecond_characteristic;
        this.str_mthird_characteristic = str_mthird_characteristic;
        this.curse = curse;
    }


    public String getStr_mid() {
        return str_mid;
    }

    public void setStr_mid(String str_mid) {
        this.str_mid = str_mid;
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


    public Curse getCurse() {
        return curse;
    }

    public void setCurse(Curse curse) {


        this.curse = curse;
    }

    public String toString() {
        String candidate = str_mid + "\n" + str_mname + "\n" + str_mfirst_characteristic + "\n" + str_msecond_characteristic + "\n" + str_mthird_characteristic;


        return candidate;
    }
}


