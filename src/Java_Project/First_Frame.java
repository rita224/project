package Java_Project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class First_Frame extends JFrame implements ActionListener {
	
	public boolean finish_First_Frame = false;
	public String player1_name;
	public String player2_name;
	Data_Base data_base;
	
//	public String First_Frame_Name = false;
	
	JLabel lb1 = new JLabel("Enter player1 name here:");
	JTextField input_name1 = new JTextField(50);
	JLabel lb2 = new JLabel("Enter player2 name here:");
	JTextField input_name2 = new JTextField(50);
	JButton btn = new JButton("Confirm");
	
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
		player1_name = input_name1.getText();
		player2_name = input_name2.getText();
		
		finish_First_Frame = true;
		this.dispose();
		
		//初始化遊戲畫面
		Second_Frame second_frame = new Second_Frame();
		second_frame.setVisible(true);
		second_frame.setResizable(false);
		System.out.println("Second frame is created");
		second_frame.label1.setText(player1_name);
		second_frame.label3.setText(player2_name);

		//初始化遊戲
		Game game = new Game(data_base,second_frame,this);
		game.start();  //開始遊戲
		System.out.println("game start");
		
		//玩家設定
		int id=0;
		Player player1 = new Player(id,this.player1_name);
		id++;
		Player player2 = new Player(id,this.player2_name);
		id++;
		//player1.start();  //開始玩家執行緒
		//player2.start();
		System.out.println("players already set");
	}

}