import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InstructionGUI extends JFrame {

    private JButton btnExit;
    private JTextArea txtInstruction;
    private String instruction = "Welcome to Bartenders Simulation!\n\n" + 
                                 "In this game, you will take on the role of a bartender, mixing cocktails to meet customer preferences within a fixed amount of time.\n\n" +
                                 "At the beginning of each level, you will be shown a list of customers, each asking for a specific cocktail.\n\n"+
                                 "Click the recipe book to check the recipe book. Find the recipe you need, pay attention to the required ingredients, the amount needed, and the specific mixing sequence. (Each serving of spirits is 1/2oz)\n"+
                                 "The first time of checking recipe book is free. But if you check it more than once, only part of the recipe will shown.\n\n" + 
                                 "To make a successful cocktail, you must add ingredients and perform operations in the correct sequence.\n\n"+
                                 "Select ingredients and perform operations by clicking the corresponding buttons. The number of clicks should match the amount needed. \n\n" +
                                 "If you make a mistake, don't worry. You can always click remake button to clear everything you have added. But you must only make one cocktail at a time."+
                                 "Once a cocktail is ready, click the customer button to serve.\n\n" +
                                 "Customer will check if the cocktail matches the recipe requested. A perfect match earns you money and possible tips, but errors result in no payment.\n\n" +
                                 "You must earn enough money within the time limit to pass the level and advance.\n\n" + 
                                 "Good Luck and Happy Mixing!";                                 
                                 
    public InstructionGUI() {
        setTitle("Instructions");
        setSize(1000, 800); 
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout()); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        btnExit = new JButton("Return");
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
