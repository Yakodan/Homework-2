public class VinylPlayer extends MusicPlayer{

    private String defaultIcon = "resources/images/vinylPlayer.png";
    private String pressedIcon = "resources/images/vinylPlayerPressed.png";

    public String getDefaultIcon() {
        return defaultIcon;
    }

    public String getPressedIcon() {
        return pressedIcon;
    }

    @Override
    public boolean isCompatible(MusicStorage musicStorage) {
        if(musicStorage instanceof VinylRecord){
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
