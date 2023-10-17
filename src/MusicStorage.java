/**
 * Родительский абстрактный класс хранящих музыку устройств
 */

import java.io.File;

public abstract class MusicStorage {

    // Иконки для пользовательского интерфейса
    private String defaultIcon;
    private String pressedIcon;

    // Автор, название песни и файл с записанным отрывком песни
    private String author;
    private String song;
    private File file;

    public MusicStorage (String author, String song, File file){
        this.author = author;
        this.song = song;
        this.file = file;
    }

    public String getAuthor() {
        return author;
    }

    public String getSong() {
        return song;
    }

    public File getFile() {
        return file;
    }

    public String getDefaultIcon() {
        return defaultIcon;
    }

    public String getPressedIcon() {
        return pressedIcon;
    }
}
