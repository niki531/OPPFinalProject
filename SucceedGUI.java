import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        this.dispose();
        if (currentLevel== 1){
            ArrayList<Customer> customers = new ArrayList<>();
            customers.add(new Customer("Alice", rb.getRecipes().get(0)));
            customers.add(new Customer("Bob", rb.getRecipes().get(1))); 
            new LevelGUI(rb, customers, 10,10000,2);
        }
        if (currentLevel== 2){
            ArrayList<Customer> customers = new ArrayList<>();
            customers.add(new Customer("Alice", rb.getRecipes().get(0)));
            customers.add(new Customer("Bob", rb.getRecipes().get(1))); 
            customers.add(new Customer("Chris", rb.getRecipes().get(2))); 
            new LevelGUI(rb, customers, 10,10000,3);
        }
        if (currentLevel== 3){
            ArrayList<Customer> customers = new ArrayList<>();
            customers.add(new Customer("Alice", rb.getRecipes().get(0)));
            customers.add(new Customer("Bob", rb.getRecipes().get(1))); 
            customers.add(new Customer("Chris", rb.getRecipes().get(2))); 
            customers.add(new Customer("David", rb.getRecipes().get(3))); 
            new LevelGUI(rb, customers, 10,10000,4);
        }
        if (currentLevel== 4){
            ArrayList<Customer> customers = new ArrayList<>();
            customers.add(new Customer("Alice", rb.getRecipes().get(0)));
            customers.add(new Customer("Bob", rb.getRecipes().get(1))); 
            customers.add(new Customer("Chris", rb.getRecipes().get(2))); 
            customers.add(new Customer("David", rb.getRecipes().get(3))); 
            customers.add(new Customer("Emily", rb.getRecipes().get(4))); 
            new LevelGUI(rb, customers, 10,10000,5);
        }
        if (currentLevel== 5){
            ArrayList<Customer> customers = new ArrayList<>();
            customers.add(new Customer("Alice", rb.getRecipes().get(0)));
            customers.add(new Customer("Bob", rb.getRecipes().get(1))); 
            customers.add(new Customer("Chris", rb.getRecipes().get(2))); 
            customers.add(new Customer("David", rb.getRecipes().get(3))); 
            customers.add(new Customer("Emily", rb.getRecipes().get(4))); 
            customers.add(new Customer("Frank", rb.getRecipes().get(5))); 
            new LevelGUI(rb, customers, 10,10000,6);
        }
    }

    public void exitClicked() {
        System.exit(0);
    }
}
