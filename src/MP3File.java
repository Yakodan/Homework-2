import java.io.File;

public class MP3File extends MusicStorage {

    private String defaultIcon;
    private String pressedIcon;

    public MP3File(String author, String song, File file){
        super(author,song,file);
        defaultIcon = "resources/images/mp3File.png";
        pressedIcon = "resources/images/mp3FilePressed.png";
    }

    public String getDefaultIcon() {
        return defaultIcon;
    }

    public String getPressedIcon() {
        return pressedIcon;
    }


}
