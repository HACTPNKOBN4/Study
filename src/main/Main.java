package main;

public class Main {
    MainWindow mainWindow;



    public Main(){
        mainWindow = new MainWindow();
        MathLogic.generateNewExercise();
        mainWindow.update();
        mainWindow.setVisible(true);
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

}
