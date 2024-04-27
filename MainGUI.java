import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGUI extends JFrame {

    private JButton btnInstruction;
    private JButton btnStartGame;
    private JButton btnExit;

    public MainGUI() {
        setTitle("Main GUI");
        setSize(800, 600);
        setLayout(new FlowLayout()); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        add(btnInstruction);
        add(btnStartGame);
        add(btnExit);

        setVisible(true);
    }

    public void instructionClicked() {
        System.out.println("Instructions button clicked");
    }

    public void startGameClicked() {
        System.out.println("Start Game button clicked");
    }

    public void exitClicked() {
        System.exit(0); 
    }

    public static void main(String[] args) {
        new MainGUI(); 
    }
}
