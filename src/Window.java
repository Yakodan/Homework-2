import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

// Реализуем пользовательский интерфейс на Java Swing
public class Window extends JFrame{

    // Переменные, хранящие индекс выбранной кнопки
    // По-умолчанию стоит значение -1, означающее отсутствие выбранной кнопки
    // Переменные вынесены вне конструктор для обхода проблемы видимости переменных в ActionListener
    int currentPlayer = -1;
    int currentStorage = -1;

    // Окно строится на основе переданных в него массивов
    // проигрывающих устройств и хранящих устройств
    public Window(MusicPlayer[] musicPlayers, MusicStorage[] musicStorages){

        super("Music Player");

        // Размечаем основное окно
        setLayout(new GridLayout(4,1));

        // Создаём, настраиваем и добавляем на экран надпись о выборе устройства и носителя музыки
        JLabel label = new JLabel("Please, choose the player and the music storage:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Calibre", Font.PLAIN, 20));
        add(label);


        // Создаём массив радио-кнопок для выбора проигрывающего устройства
        JRadioButton[] playerButtons = new JRadioButton[musicPlayers.length];

        // Подпанель, хранящая  в себе все наши кнопки
        JPanel playersPanel = new JPanel(new GridLayout(1,musicPlayers.length));

        // Создаём группу для радио-кнопок
        ButtonGroup playersGroup = new ButtonGroup();

        for(int i = 0;i< playerButtons.length;i++){
            // Инициализируем каждую радио-кнопку из массива
            playerButtons[i] = new JRadioButton();

            // Присваиваем радио-кнопкам иконки, соответсвующие классу проигрывающего устройства
            playerButtons[i].setIcon(new ImageIcon(musicPlayers[i].getDefaultIcon()));
            playerButtons[i].setSelectedIcon(new ImageIcon(musicPlayers[i].getPressedIcon()));

            // Добавляем радио-кнопки в группу и выносим их в подпанель
            playersGroup.add(playerButtons[i]);
            playersPanel.add(playerButtons[i]);

            // Центрируем каждую радио-кнопку для красоты
            playerButtons[i].setHorizontalAlignment(SwingConstants.CENTER);
        }

        // Добавляем подпанель на основную панель (окно)
        add(playersPanel);


        // Аналогичные действия для радио-кнопок носителей музыки

        JRadioButton[] storageButtons = new JRadioButton[musicStorages.length];

        JPanel storagesPanel = new JPanel(new GridLayout(1,musicStorages.length));

        ButtonGroup storagesGroup = new ButtonGroup();

        for(int i=0;i<storageButtons.length;i++){
            storageButtons[i] = new JRadioButton();
            storageButtons[i].setIcon(new ImageIcon(musicStorages[i].getDefaultIcon()));
            storageButtons[i].setSelectedIcon(new ImageIcon(musicStorages[i].getPressedIcon()));
            storagesGroup.add(storageButtons[i]);
            storagesPanel.add(storageButtons[i]);
            storageButtons[i].setHorizontalAlignment(SwingConstants.CENTER);
        }

        add(storagesPanel);


        // Создаём кнопку, проверяющую наличие и соответствие нажатых кнопок
        // При различных вариантах кнопка будет выполнять соответсвующие действия
        JButton playButton = new JButton("PLAY");
        // Создаём функцию, выполняемую при нажатии кнопки
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Проверяем, какая из радио-кнопок нажата в каждой группе
                for(int i = 0;i<playerButtons.length;i++){
                    if(playerButtons[i].isSelected()){
                        currentPlayer = i;
                        break;
                    }
                }
                for(int i = 0;i<storageButtons.length;i++){
                    if(storageButtons[i].isSelected()){
                        currentStorage = i;
                        break;
                    }
                }

                // Если хотя бы в одной из групп не нажата ни одна кнопка,
                // выводим повторную просьбу выбрать вариант
                if(currentStorage == (-1) || currentPlayer == (-1)){
                    new Sound(new File("resources/sounds/Error.wav")).play();
                    JOptionPane.showMessageDialog(new JFrame(), "Please, choose the player and the music storage!");
                    System.out.println("Please, choose the player and the music storage!");
                }
                // Если в каждой группе выбрано по варианту, то выполняем
                // действия в зависимости от выбранных вариантов
                else{
                    // Если устройство может воспроизвести соответсвующий носитель информации,
                    // то выводим автора и название песни в отдельном окне через JOptionPane.showMessageDialog
                    // Также дублируем название и автора в консоль и проигрываем отрывок из песни
                    if(musicPlayers[currentPlayer].isCompatible(musicStorages[currentStorage])){
                        musicPlayers[currentPlayer].playMusic(musicStorages[currentStorage]);
                        JOptionPane.showMessageDialog(new JFrame(), musicStorages[currentStorage].getAuthor() + " - " + musicStorages[currentStorage].getSong());
                        System.out.println(musicStorages[currentStorage].getAuthor() + " - " + musicStorages[currentStorage].getSong());
                    }
                    // Если устройство и носитель несовместны, то
                    // выводим в окно и в консоль соответствующее сообщение
                    else{
                        new Sound(new File("resources/sounds/Error.wav")).play();
                        JOptionPane.showMessageDialog(new JFrame(), "This music player is not compatible with this storage!");
                        System.out.println("This music player is not compatible with this storage!");
                    }
                }
            }
        });

        // Добавляем кнопку на окно
        add(playButton);

        // Настраиваем функции и размеры окна и делаем его видимым
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(960,540));
        setMinimumSize(new Dimension(768,432));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
