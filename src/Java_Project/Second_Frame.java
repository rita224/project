package Java_Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Second_Frame extends JFrame implements KeyListener {
	
	public boolean is_question_on = false;
	public boolean finish_Second_Frame = false;
	public int player1_answer=0;
	public int player2_answer=0;
	
	JLabel label1 = new JLabel("Player1");
	JLabel label2 = new JLabel("0");
	JLabel label3 = new JLabel("Player2");
	JLabel label4 = new JLabel("0");
	
	JLabel timer;
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	JButton btn4 = new JButton("4");
	JButton btn5 = new JButton("5");
	JButton btn6 = new JButton("6");
	JLabel qst1 = new JLabel("問題第1行");
	JLabel qst2 = new JLabel("問題第2行");
	JLabel qst3 = new JLabel("問題第3行");
	JLabel qst4 = new JLabel("問題第4行");
	
	public Second_Frame() {
		
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		// Make JLabel with size (400,50)
		JLabel time = new JLabel("TIME:");
		time.setSize(200, 80);
		time.setLocation(350, 30);
		time.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 50));

		JLabel timer = new JLabel("00:30");
		this.timer=timer;
		timer.setSize(200, 100);
		timer.setLocation(350, 80);
		timer.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 46));

		label1.setSize(200, 100);
		label1.setLocation(100, 90);
		label1.setFont(new Font("Bitstream Vera Sans", Font.LAYOUT_LEFT_TO_RIGHT, 32));

		label2.setSize(200, 200);
		label2.setLocation(100, 100);
		label2.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 46));

		
		label3.setSize(200, 100);
		label3.setLocation(580, 90);
		label3.setFont(new Font("Bitstream Vera Sans", Font.LAYOUT_LEFT_TO_RIGHT, 32));
		
		label4.setSize(200, 200);
		label4.setLocation(580, 100);
		label4.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 46));


		qst1.setSize(300, 25);
		qst1.setLocation(250, 170);
		qst1.setFont(new Font("新細明體", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		qst2.setSize(300, 25);
		qst2.setLocation(250, 195);
		qst2.setFont(new Font("新細明體", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		qst3.setSize(300, 25);
		qst3.setLocation(250, 220);
		qst3.setFont(new Font("新細明體", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		qst4.setSize(300, 25);
		qst4.setLocation(250, 245);
		qst4.setFont(new Font("新細明體", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		
		// Make six JButton in a JPanel with size (0,800)
//		JButton btn1 = new JButton("1");
//		JButton btn2 = new JButton("2");
//		JButton btn3 = new JButton("3");
		btn1.setSize(230, 50);
		btn2.setSize(230, 50);
		btn3.setSize(230, 50);
		btn1.setLocation(70, 300);
		btn2.setLocation(70, 370);

		btn3.setLocation(70, 440);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		btn1.addKeyListener(this);
		btn2.addKeyListener(this);
		btn3.addKeyListener(this);
		

		// player 2
//		JButton btn4 = new JButton("4");
//		JButton btn5 = new JButton("5");
//		JButton btn6 = new JButton("6");
		JPanel pn2 = new JPanel();
		btn4.setSize(230, 50);
		btn5.setSize(230, 50);
		btn6.setSize(230, 50);
		btn4.setLocation(500, 300);
		btn5.setLocation(500, 370);
		
		btn6.setLocation(500, 440);
		this.add(btn4);
		this.add(btn5);
		this.add(btn6);
		btn4.addKeyListener(this);
		btn5.addKeyListener(this);
		btn6.addKeyListener(this);

		this.add(time);
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.add(timer);
		this.add(qst1);
		this.add(qst2);
		this.add(qst3);
		this.add(qst4);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(is_question_on == true)
		{
			if(this.player1_answer==0)
			{
				if (e.getKeyCode() == KeyEvent.VK_A) {
					this.player1_answer = 1;
					btn1.setBackground(Color.yellow);
					btn2.setBackground(Color.gray);
					btn3.setBackground(Color.gray);
				}
				
				else if (e.getKeyCode() == KeyEvent.VK_S) {
					this.player1_answer = 2;
					btn1.setBackground(Color.gray);
					btn2.setBackground(Color.yellow);
					btn3.setBackground(Color.gray);
				}
				
				else if (e.getKeyCode() == KeyEvent.VK_D) {
					this.player1_answer = 3;
					btn1.setBackground(Color.gray);
					btn2.setBackground(Color.gray);
					btn3.setBackground(Color.yellow);
				}
			}
			if(this.player2_answer==0)
			{
				if (e.getKeyCode() == KeyEvent.VK_J) {
					this.player2_answer = 1;
					btn4.setBackground(Color.yellow);
					btn5.setBackground(Color.gray);
					btn6.setBackground(Color.gray);
		
				}
				
				else if (e.getKeyCode() == KeyEvent.VK_K) {
					this.player2_answer = 2;
					btn4.setBackground(Color.gray);
					btn5.setBackground(Color.yellow);
					btn6.setBackground(Color.gray);
				}
				
				else if (e.getKeyCode() == KeyEvent.VK_L) {
					this.player2_answer = 3;
					btn4.setBackground(Color.gray);
					btn5.setBackground(Color.gray);
					btn6.setBackground(Color.yellow);
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
