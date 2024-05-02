import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerLeaveGUI extends JDialog {
    private JTextArea txtMessage;
    private JButton btnExit;
    private boolean customerSatisfied;

    public CustomerLeaveGUI(Frame owner, int customerPay, boolean modal) {
        super(owner, modal); 
        if (customerPay == 0) {
            customerSatisfied = false;
        } else {
            customerSatisfied = true;
        }
        setTitle("Customer Feedback");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        txtMessage = new JTextArea();
        txtMessage.setText(customerSatisfied ?
            "Customer pays the bill and leaves you some tips!" :
            "Sorry, customer is not satisfied with your drink and leaves without paying...");
        txtMessage.setEditable(false);
        txtMessage.setMargin(new Insets(10, 30, 10, 30));
        add(txtMessage, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        btnExit = new JButton("Continue");
        btnExit.addActionListener(this::exitClicked);
        panel.add(btnExit);

        add(panel, BorderLayout.SOUTH);
        pack(); 
        setVisible(true);
    }

    public void exitClicked(ActionEvent e) {
        dispose();
    }
}
