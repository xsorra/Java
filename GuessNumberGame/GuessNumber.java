package GuessNumberGame;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

@SuppressWarnings("serial")
public class GuessNumber extends JFrame {
	
	Random randomNumber = new Random(); 
		
    int random = randomNumber.nextInt(1000) + 1;
	
    private JTextField input;
 
	private JLabel result = new JLabel("");	
	
   public GuessNumber(){
	   
      super("Guess the Number");
      
      JLabel label1 = new JLabel("A number between 1 and 1000.");
      JLabel label2 = new JLabel("Can you guess my number ?");
      JLabel label3 = new JLabel("Enter your first guess:");
      
      input = new JTextField(4);
      
      result = new JLabel("");
      
      JButton showButton = new JButton("Show");
      JButton guessButton = new JButton("Guess");
      JButton exitButton = new JButton("Exit");

      Container pane = getContentPane();
      setLayout(new FlowLayout());

      label1.setFont(new Font("Helvetica", Font.BOLD, 14));
      label2.setFont(new Font("Helvetica", Font.BOLD, 14));
      label3.setFont(new Font("Helvetica", Font.BOLD, 14));
      
      pane.add(label1);
      pane.add(label2);
      pane.add(label3);
      
      pane.add(input);

      pane.add(showButton);
      pane.add(guessButton);
      pane.add(exitButton);

      pane.add(result);
      
	  setSize(300,200);
	  setVisible(true);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      showButton.addActionListener(new showButtonListener());

      guessButton.addActionListener(new guessButtonListener());
      
      exitButton.addActionListener(new exitButtonListener());
   }
   
   class showButtonListener implements ActionListener{
	   
	   public void actionPerformed(ActionEvent e){
		   
           result.setText("The number is " + random);
           
           JOptionPane.showMessageDialog(null,"You lost.");  
           
           return;
		   
	   }
   }

   class guessButtonListener implements ActionListener{
    
	   public void actionPerformed(ActionEvent e){
		   
		 int inputNumber;
         
         inputNumber = Integer.parseInt(input.getText());
            
            if (inputNumber == random){
            	
                result.setText("You win!"); 
                
                GuessNumber.this.setBackgroundColor(Color.YELLOW);
            	
                JOptionPane.showMessageDialog(null,"The Number is " + random);  
            
                return;
            }
            
            if (inputNumber > random){
            	
               result.setText("Too High, Try a lower number.");
               
               GuessNumber.this.setBackgroundColor(Color.GRAY);
               
            } 
            
            if (inputNumber < random){
            	
               result.setText("Too Low, Try a higher number."); 
               
               GuessNumber.this.setBackgroundColor(Color.GRAY);
            }

            if (random - inputNumber <= 100 && random - inputNumber >= 50 ||
            	inputNumber - random <= 100 && inputNumber - random >= 50){
            	
               result.setText("You are getting colder");
               
               GuessNumber.this.setBackgroundColor(Color.BLUE);
 
            }

            if (random - inputNumber <= 50 && random - inputNumber >= 1 ||
            	inputNumber - random <= 50 && inputNumber - random >= 1){
               
               result.setText("You are getting warmer");
               
               GuessNumber.this.setBackgroundColor(Color.RED);

            }
            
         	if (inputNumber >= 1001){
         		
         		result.setText("Out of range, enter number {1 - 1000}");
         		
         		GuessNumber.this.setBackgroundColor(Color.WHITE);
         		
         	}
         } 

   }
   
   class exitButtonListener implements ActionListener{
	   
	      public void actionPerformed(ActionEvent e){
	    	  
	         System.exit(0);
	      }
	   }   

   public void setBackgroundColor(Color color){
	   
	   getContentPane().setBackground(color);
   }

   public static void main(String args[]) {

	   new GuessNumber();

   }
}