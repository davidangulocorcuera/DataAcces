import javax.naming.ldap.Control;
import java.util.HashMap;
import java.util.Scanner;

public class Controller extends BbddModel {
    public Controller(DataManager acces, BbddModel bbddModel, FileManagerModel fileManagerModel,JsonModel jsonModel) {
        this.acces = acces;

    }
    DataManager acces;


    public Controller() {

    }

    public DataManager getAcces() {
        return acces;
    }







    /*public FileManagerModel getFileManagerModel() {return fileManagerModel;}
    public DataManager getAcces() {
        return acces;
    }
    public void BbddModel(BbddModel bbddModel) {
        this.bbddModel = bbddModel;
    }
    public void DataManager(DataManager acces) {
        this.acces = acces;
    }
    public Controller(FileManagerModel fileManagerModel) {this.fileManagerModel = fileManagerModel;}
    public BbddModel getBbddModel() {
        return bbddModel;
    }*/


}