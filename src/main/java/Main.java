import util.SQLiteConnection;
import util.SQLiteInitializer;
import view.MainView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {



        SQLiteInitializer.initializeDatabase();

        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        new MainView();
    }
}
