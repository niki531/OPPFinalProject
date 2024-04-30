import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGUI extends JFrame {

    private JButton btnInstruction;
    private JButton btnStartGame;
    private JButton btnExit;
    private RecipeBook rb;

    public MainGUI(RecipeBook rb) {
        this.rb = rb;
        setTitle("Bartenders Simulation");
        setSize(1000, 800); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); 

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0; 
        constraints.gridy = 0; 
        constraints.insets = new Insets(10, 10, 10, 10); 

        btnInstruction = new JButton("Instructions");
        btnStartGame = new JButton("Start Game");
        btnExit = new JButton("Exit");

        btnInstruction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                instructionClicked();
            }
        });

        btnStartGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGameClicked();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitClicked();
            }
        });

        add(btnInstruction, constraints);
        
        constraints.gridx = 1; 
        add(btnStartGame, constraints);

        constraints.gridx = 2; 
        add(btnExit, constraints);

        setVisible(true);
    }

    public void instructionClicked() {
        new InstructionGUI(); 
    }

    public void startGameClicked() {
        new Level1GUI(rb);
        this.dispose();
    }

    public void exitClicked() {
        System.exit(0);
    }
}
