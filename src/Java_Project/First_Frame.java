package Java_Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class First_Frame extends JFrame implements ActionListener {
	
	private boolean isFirstFrameFinish = false;
	private Data_Base data_base;
	
//	public String First_Frame_Name = false;
	
	private JLabel lb1 = new JLabel("Enter player1 name here:");
	private JTextField input_name1 = new JTextField(50);
	private JLabel lb2 = new JLabel("Enter player2 name here:");
	private JTextField input_name2 = new JTextField(50);
	public JButton btn = new JButton("Confirm");
	
	public First_Frame(Data_Base data_base){
		
		this.data_base=data_base;
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		lb1.setLocation(200,10);
		lb1.setSize(400,50);
		add(lb1);
		
		lb2.setLocation(200,100);
		lb2.setSize(400,50);
		add(lb2);
		

		input_name1.setLocation(200,50);
		input_name1.setSize(400,50);
		input_name1.setText("Name");
		add(input_name1);
		
		input_name2.setLocation(200,150);
		input_name2.setSize(400,50);
		input_name2.setText("Name");
		add(input_name2);
		
		
		btn.setLocation(300,250);
		btn.setSize(200,50);
		add(btn);
		btn.addActionListener(this);
		
		// Add ActionListener with {YOURBUTTONNAME}.addActionListener(this)
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// implement button listener
		setFirstFrameFinish(true);
		this.dispose();
		System.out.println("First frame is disposed.");
	}

	public boolean isFirstFrameFinish() {
		return isFirstFrameFinish;
	}

	public void setFirstFrameFinish(boolean isFirstFrameFinish) {
		this.isFirstFrameFinish = isFirstFrameFinish;
	}

	public String input_name1()
	{
		return input_name1.getText();

	}
	
	public String input_name2()
	{
		return input_name2.getText();

	}
}