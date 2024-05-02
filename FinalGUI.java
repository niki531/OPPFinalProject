import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FinalGUI extends JFrame {
    private JTextArea txtFinal;
    private JButton btnMain;
    private JButton btnExit;
    private static FinalGUI instance;

    private FinalGUI() {
        setTitle("Final");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        txtFinal = new JTextArea();
        txtFinal.setText("Congratulations! You have successfully completed all levels! You are now a professional bartender!");
        txtFinal.setEditable(false);
        txtFinal.setMargin(new Insets(10, 30, 10, 30)); 
        add(txtFinal, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        btnMain = new JButton("Main Menu");
        btnMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainClicked();
            }
        });
        panel.add(btnMain);

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

    public void mainClicked() {
        hideFinal();
        MainGUI.getInstance().displayMain();
    }

    public void exitClicked() {
        System.exit(0);
    }

    public static FinalGUI getInstance() {
        if (instance == null) {
            synchronized (FinalGUI.class) {
                if (instance == null) {
                    instance = new FinalGUI();
                }
            }
        }
        return instance;
    }

    public void displayFinal() {
        setVisible(true);
    }

    public void hideFinal() {
        setVisible(false);
    }
}
