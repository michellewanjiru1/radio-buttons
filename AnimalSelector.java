import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalSelector extends JFrame {
    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private JLabel imageLabel;

    public AnimalSelector() {
        setTitle("Animal Selector");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //  a panel for the radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1));

        //  radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Adding the radio buttons to the panel
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        //  a label for the image
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        // Adding the panel and the image label to the frame
        add(radioPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);

        // Add action listeners to the radio buttons
        birdButton.addActionListener(new AnimalActionListener("images/istockphoto-626132614-612x612.jpg", "Bird"));
        catButton.addActionListener(new AnimalActionListener("images/istockphoto-1443562748-612x612.jpg", "Cat"));
        dogButton.addActionListener(new AnimalActionListener("images/istockphoto-509052128-612x612.jpg", "Dog"));
        rabbitButton.addActionListener(new AnimalActionListener("images/istockphoto-959866606-612x612.jpg", "Rabbit"));
        pigButton.addActionListener(new AnimalActionListener("images/istockphoto-1390779481-612x612.jpg", "Pig"));

        setVisible(true);
    }

    private class AnimalActionListener implements ActionListener {
        private String imagePath;
        private String animalName;

        public AnimalActionListener(String imagePath, String animalName) {
            this.imagePath = imagePath;
            this.animalName = animalName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ImageIcon icon = new ImageIcon(imagePath);
            imageLabel.setIcon(icon);
            JOptionPane.showMessageDialog(AnimalSelector.this, "You selected: " + animalName);
        }
    }

    public static void main(String[] args) {
        new AnimalSelector();
    }
}
