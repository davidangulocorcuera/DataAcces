import javax.naming.ldap.Control;
import java.util.HashMap;
import java.util.Scanner;

public class Controller extends BbddModel {
    public Controller(DataManager acces, BbddModel bbddModel, FileManagerModel fileManagerModel) {
        this.acces = acces;
        this.bbddModel = bbddModel;
        this.fileManagerModel = fileManagerModel;
    }
    DataManager acces;
    BbddModel bbddModel= new BbddModel();
    FileManagerModel fileManagerModel = new FileManagerModel();

    public Controller() {

    }

    public DataManager getAcces() {
        return acces;
    }

    public BbddModel getBbddModel() {
        return bbddModel;
    }

    public FileManagerModel getFileManagerModel() {
        return fileManagerModel;
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