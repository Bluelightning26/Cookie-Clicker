import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

import static java.awt.Color.*;


public class DinoClicker implements ActionListener
{

    int increment = 1;
    int count = 0;
    int level = 0;

    JFrame frame;
    JPanel panel;
    JLabel countLabel;
    JProgressBar progressBar;
    ImageIcon dinoImg;
    JLabel levelLabel;

    JButton dino;


    public DinoClicker()
    {
        frame = new JFrame();
        panel = new JPanel();

         dinoImg= new ImageIcon("src/img/dinoRoar.png");

        dino = new JButton("Orpheus", dinoImg);
        dino.addActionListener(this);
        dino.setForeground(RED);
        dino.setBackground(pink);
        dino.setOpaque(true);
        dino.setFont(new Font("Monospaced", Font.PLAIN, 30));
        System.out.println(dino.getSize());
        //dino.setIconTextGap(100);
        dinoImg.setDescription("Dino");
        dino.setPreferredSize(new Dimension(200, 500));
        panel.add(dino);

        countLabel = new JLabel("       Count: ");
        countLabel.setForeground(darkGray);
        countLabel.setBackground(ORANGE);
        countLabel.setOpaque(true);
        countLabel.setFont(new Font("Monospaced", Font.PLAIN, 30));
        panel.add(countLabel);





        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setForeground(darkGray);
        progressBar.setBackground(pink);
        progressBar.setOpaque(true);
        progressBar.setFont(new Font("Monospaced", Font.PLAIN, 30));
        progressBar.setValue(0);
        panel.add(progressBar);

        levelLabel = new JLabel("       Level: 1");
        levelLabel.setForeground(darkGray);
        levelLabel.setBackground(ORANGE);
        levelLabel.setOpaque(true);
        levelLabel.setFont(new Font("Monospaced", Font.PLAIN, 30));
        panel.add(levelLabel);



        panel.setBorder(BorderFactory.createEmptyBorder(50, 80, 50, 80));
        panel.setPreferredSize(new Dimension(1000, 600));
        panel.setLayout(new GridLayout(2, 2));
        panel.setBackground(gray);

        frame.add(panel);
        frame.setTitle("Dino Clicker");
        frame.setBackground(orange);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        //frame.setSize(480, 360);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setVisible(true);

        //System.out.println(panel.getSize());

    }



    public static void main(String[] args)
    {
        new DinoClicker();
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {

        if (count >= 20 && level == 0)
            {
            //dino.setText("Completed Level One!");
            progressBar.setValue(1);
            level++;
            }


        else if (e.getSource() == dino)
            {   progressBar.setValue(progressBar.getValue() + 5);

                count += increment;
                countLabel.setText("       Count: " + count);


            }

        if (progressBar.getValue() == progressBar.getMaximum())
            {
            increment++;
            levelLabel.setText("       Level: " + increment);
            progressBar.setValue(0);
            }



    }
}
