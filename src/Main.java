import java.io.File;

public class Main {

    public static void main(String[] args) {

        // Создаём произвольные массивы воспроизводящих устройств
        // и носителей музыки
        MusicPlayer[] musicPlayers = new MusicPlayer[3];
        MusicStorage[] musicStorages = new MusicStorage[5];

        // Инициализируем каждый элемент массива

        musicPlayers[0] = new VinylPlayer();
        musicPlayers[1] = new MP3Player();
        musicPlayers[2] = new CassettePlayer();

        musicStorages[0] = new Cassette("AC/DC","Highway to Hell", new File("resources/sounds/HighwayToHell.wav"));
        musicStorages[1] = new VinylRecord("AC/DC","Back in Black", new File("resources/sounds/BackInBlack.wav"));
        musicStorages[2] = new MP3File("Laura Shigihara", "Grasswalk",new File("resources/sounds/Grasswalk.wav"));
        musicStorages[3] = new MP3File("Redbone", "Come and get your love",new File("resources/sounds/ComeAndGetYourLove.wav"));
        musicStorages[4] = new Cassette("George Thorogood", "Bad to the Bone", new File("resources/sounds/BadToTheBone.wav"));

        // Запускаем окно программы
        new Window(musicPlayers, musicStorages);

    }
}
