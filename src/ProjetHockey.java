/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import projethockey.domain.Controller;
import projethockey.gui.MainWindow;
/**
 *
 * @author znuxor
 */
public class ProjetHockey {
    

    public static void main(String[] args) {
        projethockey.gui.MainWindow mainWindow = new projethockey.gui.MainWindow();
        Controller myController = new projethockey.domain.Controller();
        mainWindow.setController(myController);
        myController.subscribeWindow(mainWindow);
        mainWindow.setVisible(true);
        
        // Test stuff
    }
    
}
