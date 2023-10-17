public class CassettePlayer extends MusicPlayer {

    private String defaultIcon = "resources/images/cassettePlayer.png";
    private String pressedIcon = "resources/images/cassettePlayerPressed.png";

    public String getDefaultIcon() {
        return defaultIcon;
    }

    public String getPressedIcon() {
        return pressedIcon;
    }

    @Override
    public boolean isCompatible(MusicStorage musicStorage) {
        if(musicStorage instanceof Cassette){
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
