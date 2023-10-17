public class MP3Player extends MusicPlayer{

    private String defaultIcon = "resources/images/mp3Player.png";
    private String pressedIcon = "resources/images/mp3PlayerPressed.png";

    public String getDefaultIcon() {
        return defaultIcon;
    }

    public String getPressedIcon() {
        return pressedIcon;
    }

    @Override
    public boolean isCompatible(MusicStorage musicStorage) {
        if(musicStorage instanceof MP3File){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void playMusic(MusicStorage musicStorage) {
        if(isCompatible(musicStorage)) {
            new Sound(musicStorage.getFile()).play();
        }
    }

}
