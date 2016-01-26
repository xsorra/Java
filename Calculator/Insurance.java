package Calculator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Insurance extends JFrame implements ActionListener{

	JRadioButton HMO;
	JRadioButton PPO;
	JCheckBox DENTAL;
	JCheckBox VISION;
	JCheckBox NONE;
	
	JTextField TOTAL = new JTextField(8);
	
	final int hmo = 200, ppo = 600, dental = 75, vision = 20;
	
	int subTotal, total = 0;
	
	public Insurance(){
		
		JFrame frame = new JFrame("Insurance Calculator");
		
		JPanel panel = new JPanel();
		
		JLabel label1 = new JLabel("Select insurance type : ");
		JLabel label2 = new JLabel("Select coverage : ");
		JLabel price = new JLabel("The price for your insurance: ");
		
		frame.add(panel);
		
	    label1.setFont(new Font("Helvetica", Font.BOLD, 13));
	    label2.setFont(new Font("Helvetica", Font.BOLD, 13));
	    
		HMO = new JRadioButton("HMO $200");
		PPO = new JRadioButton("PPO $600");
		
		DENTAL = new JCheckBox("Dental $75");
		VISION = new JCheckBox("Vision $20");
		
		NONE = new JCheckBox("Neither Option");
		
		
		ButtonGroup insurance = new ButtonGroup();
		insurance.add(HMO);
		insurance.add(PPO);
	
		panel.add(label1);
		panel.add(HMO);
		panel.add(PPO);
		
		panel.add(label2);
		panel.add(DENTAL);
		panel.add(VISION);
		
		panel.add(price);
		panel.add(TOTAL);
		
		frame.setSize(400,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		HMO.addActionListener(this);
		PPO.addActionListener(this);
		DENTAL.addActionListener(this);
		VISION.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(HMO.isSelected()){
			subTotal = hmo;
		}
		
		if(PPO.isSelected()){
			subTotal = ppo;
		}
		
		if(DENTAL.isSelected()){
			subTotal += dental;
		}
		
		if(VISION.isSelected()){
			subTotal += vision;
		}
		
		else if(NONE.isSelected()){
			subTotal -= 0;
		}
		
		TOTAL.setText("$" + subTotal);
	}
	
	public static void main(String[]args){
		
		new Insurance();
	}
}
