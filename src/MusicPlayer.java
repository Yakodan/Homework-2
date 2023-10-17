/**
 * Родительский абстрактный класс музыкальных проигрывателей
 */

public abstract class MusicPlayer {

    // Ссылки на файлы иконок для пользовательского интерфейса
    private String defaultIcon;
    private String pressedIcon;

    public String getDefaultIcon() {
        return defaultIcon;
    }

    public String getPressedIcon() {
        return pressedIcon;
    }

    // Метод, определяющий совместимость проигрывающего
    // устройства и носителя музыки
    // Для каждого дочернего класса переопределяется
    // под соответсвующий носитель
    public abstract boolean isCompatible(MusicStorage musicStorage);

    // Метод, проигрывающий музыку, хранимую
    // в переданном носителе
    public abstract void playMusic(MusicStorage musicStorage);

}
