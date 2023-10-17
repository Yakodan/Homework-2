import java.io.File;

public class VinylRecord extends MusicStorage {

    private String defaultIcon;
    private String pressedIcon;

    public VinylRecord(String author, String song, File file){
        super(author,song,file);
        defaultIcon = "resources/images/vinylRecord.png";
        pressedIcon = "resources/images/vinylRecordPressed.png";
    }

    public String getDefaultIcon() {
        return defaultIcon;
    }

    public String getPressedIcon() {
        return pressedIcon;
    }

}
