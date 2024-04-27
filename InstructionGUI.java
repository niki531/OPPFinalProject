import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InstructionGUI extends JFrame {

    private JButton btnExit;
    private JTextArea txtInstruction;

    private String instruction = "Welcome to Bartenders Simulation!\n" + 
                                 "In this game, you will take on the role of a bartender, mixing cocktails to meet customer preferences within a fixed amount of time.\n" +
                                 "At the beginning of each level, you will be shown a cocktail recipe. Pay attention to the required ingredients, the amount needed, and the specific mixing sequence.\n"+
                                 "To make a successful cocktail, you must add ingredients and perform operations in the correct sequence.\n"+
                                 "Select ingredients and perform operations by clicking the corresponding buttons. The number of clicks should match the amount needed.\n" +
                                 "Each level features a list of customers, each requesting specific cocktails. Once a cocktail is ready, click the customer button to serve. You must only make one cocktail at a time.\n" +
                                 "Customer will check if the cocktail matches the recipe requested. A perfect match earns you money and possible tips, but errors result in no payment.\n" +
                                 "You must earn enough money within the time limit to pass the level and advance.\n" + 
                                 "Click the 'Recipe' button for a full view of the recipe at any time during the game. But if you clicked more than once, only part of the recipe will shown.\n" + 
                                 "Good Luck and Happy Mixing!";                                 
                                 
    public InstructionGUI() {
        setTitle("Instructions");
        setSize(800, 600); 
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout()); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitClicked();
            }
        });

        txtInstruction = new JTextArea(10, 30);
        displayInstruction();        
        

    }

    public void displayInstruction() {
        txtInstruction.setText(instruction); 
        txtInstruction.setWrapStyleWord(true);
        txtInstruction.setLineWrap(true);
        txtInstruction.setEditable(false); 
        txtInstruction.setOpaque(false); 
        txtInstruction.setMargin(new Insets(10, 30, 10, 30)); 
        add(txtInstruction, BorderLayout.CENTER);
        add(btnExit, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void exitClicked() {
        dispose(); 
    }
}
