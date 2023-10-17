import java.io.File;

public class Cassette extends MusicStorage {

    private String defaultIcon;
    private String pressedIcon;

    public Cassette(String author, String song, File file){
        super(author,song,file);
        defaultIcon = "resources/images/cassette.png";
        pressedIcon = "resources/images/cassettePressed.png";
    }

    public String getDefaultIcon() {
        return defaultIcon;
    }

    public String getPressedIcon() {
        return pressedIcon;
    }

}
