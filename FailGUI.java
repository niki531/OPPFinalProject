import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FailGUI extends JFrame {
    private JTextArea txtFail;
    private JButton btnNew;
    private JButton btnExit;
    private static FailGUI instance;

    private FailGUI() {
        setTitle("Game Failed...");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        txtFail = new JTextArea();
        txtFail.setText("Sorry, you failed...");
        txtFail.setEditable(false);
        txtFail.setMargin(new Insets(10, 30, 10, 30)); 
        add(txtFail, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        btnNew = new JButton("Try Again");
        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newClicked();
            }
        });
        panel.add(btnNew);

        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitClicked();
            }
        });
        panel.add(btnExit);

        add(panel, BorderLayout.SOUTH);

        setVisible(false);
    }

    public void newClicked() {
        hideFail();
        MainGUI.getInstance().displayMain();
    }

    public void exitClicked() {
        System.exit(0);
    }

    public static FailGUI getInstance() {
        if (instance == null) {
            synchronized (FailGUI.class) {
                if (instance == null) {
                    instance = new FailGUI();
                }
            }
        }
        return instance;
    }

    public void displayFail() {
        setVisible(true);
    }

    public void hideFail() {
        setVisible(false);
    }
}
