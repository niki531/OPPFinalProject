import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level1GUI extends JFrame {
    private Recipe product;
    private Customer customer1; 
    private RecipeBook recipebook;
    private int aimMoney=15;
    private int gainMoney=0;
    private int checktimes=0;
    private JTextArea currentProduct;
    private JTextArea aimArea;
    private JTextArea gainArea;
    private JTextArea timeArea;
    private JButton btnCustomer1;
    private JButton btnRecipe;
    private JButton btnIce;
    private JButton btnGin;
    private JButton btnDryVermouth;
    private JButton btnOrangeBitters;
    private JButton btnMintLeaves;
    private JButton btnLimeWedge;
    private JButton btnSugar;
    private JButton btnWhiteRum;
    private JButton btnClubSoda;
    private JButton btnTequila;
    private JButton btnLimeJuice;
    private JButton btnTripleSec;
    private JButton btnBourbonWhiskey;
    private JButton btnLemonJuice;
    private JButton btnSimpleSyrup;
    private JButton btnEggWhite;
    private JButton btnSalt;

    private JButton btnMuddle;
    private JButton btnShake;
    private JButton btnStir;
    private JButton btnRim;
    private JButton btnStrain;

    private JButton btnExitLevel1;
    private JButton btnRemake;
    
    private JButton btnLemonTwist;
    private JButton btnOrangeSlice;
    private JButton btnCherry;
    private int levelTime=10000;
    private JLabel label;
    private Timer timer;
    private int count = 0;
    private int currentLevel=1;

    public Level1GUI(RecipeBook rb) {
        setTitle("Level 1");
        setSize(1000, 800); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.recipebook = rb;
        this.product = new Recipe("Product",0);
        this.customer1 = new Customer("Alice", this.recipebook.getRecipes().get(0));

        setLayout(new GridBagLayout()); 
        btnRecipe = new JButton("Recipe Book");
        btnIce = new JButton("Add Ice");
        btnGin = new JButton("Add Gin");
        btnDryVermouth = new JButton("Add Dry Vermouth");
        btnOrangeBitters = new JButton("Add Orange Bitters");
        btnMintLeaves = new JButton("Add Mint Leaves");
        btnLimeWedge = new JButton("Add Lime Wedge");
        btnSugar = new JButton("Add Sugar");
        btnWhiteRum = new JButton("Add White Rum");
        btnClubSoda = new JButton("Add Club Soda");
        btnTequila = new JButton("Add Tequila");
        btnLimeJuice = new JButton("Add Lime Juice");
        btnTripleSec = new JButton("Add Triple Sec");
        btnBourbonWhiskey = new JButton("Add Bourbon Whiskey");
        btnLemonJuice = new JButton("Add Lemon Juice");
        btnSimpleSyrup = new JButton("Add Simple Syrup");
        btnEggWhite = new JButton("Add Egg White");
        btnSalt = new JButton("Add Salt");
        
        btnMuddle = new JButton("Muddle");
        btnShake = new JButton("Shake");
        btnStir = new JButton("Stir");
        btnRim = new JButton("Rim");
        btnStrain = new JButton("Strain");
        
        btnExitLevel1 = new JButton("Exit Level 1");
        btnRemake = new JButton("Remake");

        btnLemonTwist = new JButton("Add Lemon Twist");
        btnOrangeSlice = new JButton("Add Orange Slice");
        btnCherry = new JButton("Add Cherry");
        btnCustomer1 = new JButton(this.customer1.getName()+": "+ this.recipebook.getRecipes().get(0).getName()+" $"+ this.recipebook.getRecipes().get(0).getPrice()+"+"+this.customer1.getTip());

        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10); 
        
        constraints.gridx = 1; 
        constraints.gridy = 0; 
        add(btnCustomer1,constraints);
        constraints.gridx = 0; 
        constraints.gridy = 1; 
        add(btnRecipe,constraints);
        constraints.gridx = 0; 
        constraints.gridy = 0; 
        add(btnExitLevel1,constraints);
        constraints.gridx = 0; 
        constraints.gridy = 0; 
        add(btnExitLevel1,constraints);
        constraints.gridx = 4; 
        constraints.gridy = 9; 
        add(btnRemake,constraints);
        
        JButton[] buttons = {
            btnGin, btnDryVermouth, btnOrangeBitters, btnWhiteRum, btnTequila, 
            btnTripleSec, btnBourbonWhiskey, btnClubSoda, btnLimeJuice, 
            btnLemonJuice, btnSimpleSyrup, btnLimeWedge, btnMintLeaves, btnIce, btnSugar, 
            btnEggWhite, btnSalt, btnLemonTwist, btnOrangeSlice, btnCherry, btnMuddle, 
            btnShake, btnStir, btnRim, btnStrain
        };
        int buttonCount = 0;
        int column = 2; 
        for (JButton button : buttons) {
            constraints.gridx = column;
            constraints.gridy = buttonCount;
            add(button, constraints);
        
            buttonCount++; 
        
            if (buttonCount == 10) {
                buttonCount = 0; 
                column++; 
            }
        }

        this.currentProduct = new JTextArea(800, 200);
        currentProduct.setEditable(false);
        currentProduct.setWrapStyleWord(true);
        currentProduct.setLineWrap(true);
        currentProduct.setEditable(false);
        currentProduct.setOpaque(false);
        currentProduct.setText(product.displayProduct());
        constraints.gridx = 0; 
        constraints.gridy = 11;
        constraints.gridwidth = GridBagConstraints.REMAINDER; 
        add(currentProduct,constraints);

        this.aimArea = new JTextArea(200, 200);
        aimArea.setEditable(false);
        aimArea.setWrapStyleWord(true);
        aimArea.setLineWrap(true);
        aimArea.setEditable(false);
        aimArea.setOpaque(false);
        aimArea.setText("Aim: $"+String.valueOf(this.aimMoney));
        constraints.gridx = 0; 
        constraints.gridy = 3;
        add(aimArea,constraints);

        this.gainArea = new JTextArea(200, 200);
        gainArea.setEditable(false);
        gainArea.setWrapStyleWord(true);
        gainArea.setLineWrap(true);
        gainArea.setEditable(false);
        gainArea.setOpaque(false);
        gainArea.setText("Gained: $"+String.valueOf(this.gainMoney));
        constraints.gridx = 0; 
        constraints.gridy = 4;
        add(gainArea,constraints);

        this.timeArea = new JTextArea(200, 200);
        timeArea.setEditable(false);
        timeArea.setWrapStyleWord(true);
        timeArea.setLineWrap(true);
        timeArea.setEditable(false);
        timeArea.setOpaque(false);
        
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                timeArea.setText("Remaining Time: "+String.valueOf(levelTime-count));
                if (count >= levelTime) {
                    timeUp(currentLevel,recipebook);
                    timer.stop(); 
                }
            }
        });

        constraints.gridx = 0; 
        constraints.gridy = 2;
        add(timeArea,constraints);
        
        setVisible(true);
        timer.start();  


        btnCustomer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer1Pay(product,recipebook,currentLevel);
                System.out.println("Consumer clicked");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnRecipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRecipe(checktimes, recipebook);
                checktimes ++;
            }
        });

        btnIce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("ice");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnGin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("gin");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnDryVermouth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("dry vermouth");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnOrangeBitters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("orange bitters");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnStir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("stir");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnLemonTwist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("lemon twist");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnWhiteRum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("white rum");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnTequila.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("tequila");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnTripleSec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("triple sec");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnBourbonWhiskey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("bourbon whiskey");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnClubSoda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("club soda");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnLimeJuice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("lime juice");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnLemonJuice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("lemon juice");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnSimpleSyrup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("simple syrup");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnLimeWedge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("lime wedge");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnMintLeaves.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("mint leaves");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnSugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("sugar");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnEggWhite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("egg white");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnSalt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("salt");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnOrangeSlice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("orange slice");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnCherry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("cherry");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnMuddle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("muddle");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnShake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("shake");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnRim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("rim");
                currentProduct.setText(product.displayProduct());
            }
        });

        btnStrain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.addIngredient("strain");
                currentProduct.setText(product.displayProduct());
            }
        });
        
        btnExitLevel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitClicked();
            }
        });
        btnRemake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               product.clear();
               currentProduct.setText(product.displayProduct());
            }
        });

    }

    public void displayRecipe(int checktimes, RecipeBook rb){
        RecipeBookGUI rbg = new RecipeBookGUI(checktimes,rb,this);
    }

    public void customer1Pay(Recipe product, RecipeBook rb, int currentLevel){
        int m = customer1.compareNPay(product);
        this.gainMoney += m;
        this.gainArea.setText("Gained: $"+String.valueOf(this.gainMoney));
        product.clear();
        if (this.gainMoney>=this.aimMoney){
            gameSucceed(currentLevel,rb);
        }
    }

    public void gameSucceed(int currentLevel, RecipeBook rb){
        new SucceedGUI(currentLevel,rb);
    }
    
    public void gameFail(RecipeBook rb){
        new FailGUI(rb);
    }

    public void timeUp(int currentLevel, RecipeBook rb){
        if (gainMoney>=aimMoney){
            gameSucceed(currentLevel,rb);
        }
        else{
            gameFail(rb);
        }
    }
    
    
    private void exitClicked() {
    	this.dispose();
        MainGUI main = new MainGUI(recipebook);
    }


}
