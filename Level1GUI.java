import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level1GUI extends JFrame {
    private Recipe product;
    private Customer customer1; 
    private RecipeBook recipebook;
    private int aimMoney;
    private int gainMoney;
    private int checktimes;
    private int level1Time;

    private JButton btnCustomer1;
    private JButton btnRecipe;
    private JButton btnIngredient1;
    private JButton btnIngredient2;
    private JButton btnIngredient3;

    public Level1GUI() {
       
        btnCustomer1 = new JButton("Customer 1");
        btnRecipe = new JButton("Recipe");
        btnIngredient1 = new JButton("Ingredient 1");
        btnIngredient2 = new JButton("Ingredient 2");
        btnIngredient3 = new JButton("Ingredient 3");

        this.product = new Recipe("Product");
        this.customer1 = new Customer("Alice", recipebook.get(0));
        
        
        btnCustomer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int payment = customer1Pay(product);
                gainMoney += payment;
                product.clear();
            }
        });

        btnRecipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRecipe(checktimes);
                checktimes = 1;
            }
        });

        btnIngredient1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("ingredient1");
            }
        });

        btnIngredient2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("ingredient2");
            }
        });

        btnIngredient3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("ingredient3");
            }
        });

        setLayout(new FlowLayout());
        add(btnCustomer1);
        add(btnRecipe);
        add(btnIngredient1);
        add(btnIngredient2);
        add(btnIngredient3);

        setTitle("Level 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


    public static void main(String[] args) {
       
    }
}

