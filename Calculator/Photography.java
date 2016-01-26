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
public class Photography extends JFrame implements ActionListener{

	JRadioButton BASEPRICE;
	JRadioButton INSTUDIO;
	JCheckBox PET;
	JCheckBox ONLOCATION;
	JCheckBox NONE;
	
	JTextField TOTAL = new JTextField(8);
	
	final int BASE_PRICE = 40, IN_STUDIO = 75, WITH_PET = 95, ON_LOCATION = 90;
	int subTotal, total = 0;
	
	public Photography(){
		
		JFrame frame = new JFrame("Photography Calculator");
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		JLabel type = new JLabel("Paula's Portrais, a photography studio");
		JLabel price = new JLabel("The price for your Photography: ");
		
		BASEPRICE = new JRadioButton("Base price $40");
		INSTUDIO = new JRadioButton("In-studio $75");
		
		PET = new JCheckBox("With a pet $95");
		ONLOCATION = new JCheckBox("On location $90");
		
		NONE = new JCheckBox("Neither Option");
		
		ButtonGroup Photography = new ButtonGroup();
		Photography.add(BASEPRICE);
		Photography.add(INSTUDIO);

		type.setFont(new Font("Helvetica", Font.BOLD, 13));
		
		panel.add(type);

		panel.add(BASEPRICE);
		panel.add(INSTUDIO);
		panel.add(PET);
		panel.add(ONLOCATION);
		panel.add(price);
		panel.add(TOTAL);
		
		frame.setSize(300,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		BASEPRICE.addActionListener(this);
		INSTUDIO.addActionListener(this);
		PET.addActionListener(this);
		ONLOCATION.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(BASEPRICE.isSelected()){
			subTotal = BASE_PRICE;
		}
		
		if(INSTUDIO.isSelected()){
			subTotal = IN_STUDIO;
		}
		
		if(PET.isSelected()){
			subTotal += WITH_PET;
		}
		
		if(ONLOCATION.isSelected()){
			subTotal += ON_LOCATION;
		}
		
		else if(NONE.isSelected()){
			subTotal -= 0;
		}
		
		TOTAL.setText("$" + subTotal);
	}
	
	public static void main(String[]args){
		
		new Photography();
	}
}
