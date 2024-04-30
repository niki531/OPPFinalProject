import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SucceedGUI extends JFrame {
    private JTextArea txtSucceed;
    private JButton btnNextLevel;
    private JButton btnExit;
    private int currentLevel;
    private RecipeBook rb;

    public SucceedGUI(int currentLevel, RecipeBook rb) {
        this.currentLevel = currentLevel;
        this.rb = rb;
        setTitle("Level "+currentLevel+" Passed");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        txtSucceed = new JTextArea();
        txtSucceed.setText("Congratulations! You passed level " + currentLevel + ".");
        txtSucceed.setEditable(false);
        txtSucceed.setMargin(new Insets(10, 30, 10, 30)); 
        add(txtSucceed, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        btnNextLevel = new JButton("Next Level");
        btnNextLevel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextClicked(rb);
            }
        });
        panel.add(btnNextLevel);

        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitClicked();
            }
        });
        panel.add(btnExit);

        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void nextClicked(RecipeBook rb) {
        if (currentLevel== 1){
            //new Level2GUI(rb);
            System.out.println("level2");
        }
    }

    public void exitClicked() {
        System.exit(0);
    }
}
