import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Level1GUI extends JFrame {
    private Recipe product;
    private Customer customer1;
    private RecipeBook recipebook;
    private int aimMoney = 15;
    private int gainMoney = 0;
    private int checktimes = 0;
    private JTextArea currentProduct, aimArea, gainArea, timeArea;
    private JButton btnCustomer1, btnRecipe, btnExitLevel1, btnRemake;
    private JButton[] ingredientButtons;
    private Timer timer;
    private int levelTime = 10000;
    private int count = 0;
    private int currentLevel =1;

    public Level1GUI(RecipeBook rb) {
        setTitle("Level 1");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.recipebook = rb;
        this.product = new Recipe("Product", 0);
        this.customer1 = new Customer("Alice", this.recipebook.getRecipes().get(0));

        setupGUI();
        setupTimer();
        setVisible(true);
    }

    private void setupGUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        setupTextAreas(constraints);
        setupButtons(constraints);
    }

    private void setupTextAreas(GridBagConstraints constraints) {
        currentProduct = createTextArea(product.displayProduct());
        aimArea = createTextArea("Aim: $" + aimMoney);
        gainArea = createTextArea("Gained: $" + gainMoney);
        timeArea = createTextArea("Remaining Time: " + (levelTime - count));

        addComponent(currentProduct, constraints, 0, 11, GridBagConstraints.REMAINDER);
        addComponent(aimArea, constraints, 0, 3);
        addComponent(gainArea, constraints, 0, 4);
        addComponent(timeArea, constraints, 0, 2);
    }

    private JTextArea createTextArea(String text) {
        JTextArea textArea = new JTextArea(200, 200);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setText(text);
        return textArea;
    }

    private void addComponent(Component component, GridBagConstraints constraints, int x, int y) {
        addComponent(component, constraints, x, y, 1);
    }

    private void addComponent(Component component, GridBagConstraints constraints, int x, int y, int width) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        add(component, constraints);
    }

    private void setupButtons(GridBagConstraints constraints) {
        String[] ingredients = {"Ice", "Gin", "Dry Vermouth", "Orange Bitters", "Mint Leaves", "Lime Wedge", "Sugar", "White Rum",
                                 "Club Soda", "Tequila", "Lime Juice", "Triple Sec", "Bourbon Whiskey", "Lemon Juice", "Simple Syrup",
                                 "Egg White", "Salt", "Lemon Twist", "Orange Slice", "Cherry", "Muddle", "Shake", "Stir", "Rim", "Strain"};
        ingredientButtons = new JButton[ingredients.length];
        int buttonCount = 0;
        int column = 2;
        for (int i = 0; i < ingredients.length; i++) {
            JButton button = new JButton("Add " + ingredients[i]);
            button.addActionListener(this::buttonAction);
            ingredientButtons[i] = button;
            constraints.gridx = column;
            constraints.gridy = buttonCount++;
            add(button, constraints);

            if (buttonCount == 10) {
                buttonCount = 0;
                column++;
            }
        }

        btnCustomer1 = new JButton(customer1.getName() + ": " + this.recipebook.getRecipes().get(0).getName() + " $" + this.recipebook.getRecipes().get(0).getPrice() + "+" + customer1.getTip());
        btnRecipe = new JButton("Recipe Book");
        btnExitLevel1 = new JButton("Exit Level 1");
        btnRemake = new JButton("Remake");

        btnCustomer1.addActionListener(this::customer1Action);
        btnRecipe.addActionListener(this::recipeAction);
        btnExitLevel1.addActionListener(e -> exitClicked());
        btnRemake.addActionListener(e -> remakeAction());

        addComponent(btnCustomer1, constraints, 1, 0);
        addComponent(btnRecipe, constraints, 0, 1);
        addComponent(btnExitLevel1, constraints, 0, 0);
        addComponent(btnRemake, constraints, 4, 9);
    }

    private void buttonAction(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        product.addIngredient(source.getText().substring(4));
        currentProduct.setText(product.displayProduct());
    }

    private void customer1Action(ActionEvent e) {
        customer1Pay();
        currentProduct.setText(product.displayProduct());
    }

    private void recipeAction(ActionEvent e) {
        displayRecipe(checktimes, recipebook);
        checktimes++;
    }
    public void displayRecipe(int checktimes, RecipeBook rb){
        RecipeBookGUI rbg = new RecipeBookGUI(checktimes,rb,this);
    }

    private void remakeAction() {
        product.clear();
        currentProduct.setText(product.displayProduct());
    }

    private void setupTimer() {
        timer = new Timer(1000, e -> {
            count++;
            timeArea.setText("Remaining Time: " + (levelTime - count));
            if (count >= levelTime) {
                timeUp();
                timer.stop();
            }
        });
        timer.start();
    }

    private void timeUp() {
        if (gainMoney >= aimMoney) {
            gameSucceed();
        } else {
            gameFail();
        }
    }

    private void customer1Pay() {
        int m = customer1.compareNPay(product);
        gainMoney += m;
        gainArea.setText("Gained: $" + gainMoney);
        product.clear();
        if (gainMoney >= aimMoney) {
            gameSucceed();
        }
    }

    private void gameSucceed() {
        new SucceedGUI(currentLevel, recipebook);
    }

    private void gameFail() {
        new FailGUI(recipebook);
    }

    private void exitClicked() {
        dispose();
        new MainGUI(recipebook);
    }
}
