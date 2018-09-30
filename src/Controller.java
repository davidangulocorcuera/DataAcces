import java.util.HashMap;

public class Controller extends BbddModel {
    BbddModel bbddModel = new BbddModel();
    FileManagerModel fileManagerModel = new FileManagerModel();

    public FileManagerModel getFileManagerModel() {
        return fileManagerModel;
    }

    public void setFileManagerModel(FileManagerModel fileManagerModel) {
        this.fileManagerModel = fileManagerModel;
    }

    public BbddModel getBbddModel() {
        return bbddModel;
    }

    public void setBbddModel(BbddModel bbddModel) {
        this.bbddModel = bbddModel;
    }
}
