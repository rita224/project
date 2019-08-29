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
	
	private Player player1;
	private Player player2;
	
	private JLabel label1 = new JLabel("Player1");
	private JLabel label2 = new JLabel("0");
	private JLabel label3 = new JLabel("Player2");
	private JLabel label4 = new JLabel("0");
	
	private JLabel timer;
	private JButton btn1 = new JButton("1");
	private JButton btn2 = new JButton("2");
	private JButton btn3 = new JButton("3");
	private JButton btn4 = new JButton("4");
	private JButton btn5 = new JButton("5");
	private JButton btn6 = new JButton("6");
	private JLabel qst1 = new JLabel("問題第1行");
	private JLabel qst2 = new JLabel("問題第2行");
	private JLabel qst3 = new JLabel("問題第3行");
	private JLabel qst4 = new JLabel("問題第4行");
	
	public Second_Frame(Player player1,Player player2) {
		
		this.player1 = player1;
		this.player2 = player2;

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		// Make JLabel with size (400,50)
		JLabel time = new JLabel("TIME:");
		time.setSize(200, 80);
		time.setLocation(350, 30);
		time.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 50));

		JLabel timer = new JLabel("00:30");
		this.setTimer(timer);
		timer.setSize(200, 100);
		timer.setLocation(350, 80);
		timer.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 46));

		getLabel1().setSize(200, 100);
		getLabel1().setLocation(100, 90);
		getLabel1().setFont(new Font("Bitstream Vera Sans", Font.LAYOUT_LEFT_TO_RIGHT, 32));

		getLabel2().setSize(200, 200);
		getLabel2().setLocation(100, 100);
		getLabel2().setFont(new Font("Bitstream Vera Sans", Font.BOLD, 46));

		
		getLabel3().setSize(200, 100);
		getLabel3().setLocation(580, 90);
		getLabel3().setFont(new Font("Bitstream Vera Sans", Font.LAYOUT_LEFT_TO_RIGHT, 32));
		
		getLabel4().setSize(200, 200);
		getLabel4().setLocation(580, 100);
		getLabel4().setFont(new Font("Bitstream Vera Sans", Font.BOLD, 46));


		getQst1().setSize(300, 25);
		getQst1().setLocation(250, 170);
		getQst1().setFont(new Font("新細明體", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		getQst2().setSize(300, 25);
		getQst2().setLocation(250, 195);
		getQst2().setFont(new Font("新細明體", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		getQst3().setSize(300, 25);
		getQst3().setLocation(250, 220);
		getQst3().setFont(new Font("新細明體", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		getQst4().setSize(300, 25);
		getQst4().setLocation(250, 245);
		getQst4().setFont(new Font("新細明體", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		
		// Make six JButton in a JPanel with size (0,800)
//		JButton btn1 = new JButton("1");
//		JButton btn2 = new JButton("2");
//		JButton btn3 = new JButton("3");
		getBtn1().setSize(230, 50);
		getBtn2().setSize(230, 50);
		getBtn3().setSize(230, 50);
		getBtn1().setLocation(70, 300);
		getBtn2().setLocation(70, 370);

		getBtn3().setLocation(70, 440);
		this.add(getBtn1());
		this.add(getBtn2());
		this.add(getBtn3());
		getBtn1().addKeyListener(this);
		getBtn2().addKeyListener(this);
		getBtn3().addKeyListener(this);
		

		// player 2
//		JButton btn4 = new JButton("4");
//		JButton btn5 = new JButton("5");
//		JButton btn6 = new JButton("6");
		JPanel pn2 = new JPanel();
		getBtn4().setSize(230, 50);
		getBtn5().setSize(230, 50);
		getBtn6().setSize(230, 50);
		getBtn4().setLocation(500, 300);
		getBtn5().setLocation(500, 370);
		
		getBtn6().setLocation(500, 440);
		this.add(getBtn4());
		this.add(getBtn5());
		this.add(getBtn6());
		getBtn4().addKeyListener(this);
		getBtn5().addKeyListener(this);
		getBtn6().addKeyListener(this);

		this.add(time);
		this.add(getLabel1());
		this.add(getLabel2());
		this.add(getLabel3());
		this.add(getLabel4());
		this.add(timer);
		this.add(getQst1());
		this.add(getQst2());
		this.add(getQst3());
		this.add(getQst4());
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
			if(player1.getAnswer()==0)
			{
				if(e.getKeyCode() == KeyEvent.VK_A||e.getKeyCode() == KeyEvent.VK_S||e.getKeyCode() == KeyEvent.VK_D)
				{
					getBtn1().setBackground(Color.gray);
					getBtn2().setBackground(Color.gray);
					getBtn3().setBackground(Color.gray);
				}
				
				if (e.getKeyCode() == KeyEvent.VK_A) {
					player1.setAnswer(1);
					getBtn1().setBackground(Color.yellow);
				}
				
				else if (e.getKeyCode() == KeyEvent.VK_S) {
					player1.setAnswer(2);
					getBtn2().setBackground(Color.yellow);
				}
				
				else if (e.getKeyCode() == KeyEvent.VK_D) {
					player1.setAnswer(3);
					getBtn3().setBackground(Color.yellow);
				}
			}
			if(player2.getAnswer()==0)
			{
				if(e.getKeyCode() == KeyEvent.VK_J||e.getKeyCode() == KeyEvent.VK_K||e.getKeyCode() == KeyEvent.VK_L)
				{
					getBtn4().setBackground(Color.gray);
					getBtn5().setBackground(Color.gray);
					getBtn6().setBackground(Color.gray);
				}
				
				if (e.getKeyCode() == KeyEvent.VK_J) {
					player2.setAnswer(1);
					getBtn4().setBackground(Color.yellow);
				}
				
				else if (e.getKeyCode() == KeyEvent.VK_K) {
					player2.setAnswer(2);
					getBtn5().setBackground(Color.yellow);
				}
				
				else if (e.getKeyCode() == KeyEvent.VK_L) {
					player2.setAnswer(3);
					getBtn6().setBackground(Color.yellow);
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public JLabel getTimer() {
		return timer;
	}

	public void setTimer(JLabel timer) {
		this.timer = timer;
	}

	public JButton getBtn1() {
		return btn1;
	}

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	public JButton getBtn2() {
		return btn2;
	}

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	public JButton getBtn3() {
		return btn3;
	}

	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}

	public JButton getBtn4() {
		return btn4;
	}

	public void setBtn4(JButton btn4) {
		this.btn4 = btn4;
	}

	public JButton getBtn5() {
		return btn5;
	}

	public void setBtn5(JButton btn5) {
		this.btn5 = btn5;
	}

	public JButton getBtn6() {
		return btn6;
	}

	public void setBtn6(JButton btn6) {
		this.btn6 = btn6;
	}

	public JLabel getQst1() {
		return qst1;
	}

	public void setQst1(JLabel qst1) {
		this.qst1 = qst1;
	}

	public JLabel getQst2() {
		return qst2;
	}

	public void setQst2(JLabel qst2) {
		this.qst2 = qst2;
	}

	public JLabel getQst3() {
		return qst3;
	}

	public void setQst3(JLabel qst3) {
		this.qst3 = qst3;
	}

	public JLabel getQst4() {
		return qst4;
	}

	public void setQst4(JLabel qst4) {
		this.qst4 = qst4;
	}

	public JLabel getLabel2() {
		return label2;
	}

	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}

	public JLabel getLabel4() {
		return label4;
	}

	public void setLabel4(JLabel label4) {
		this.label4 = label4;
	}

	public JLabel getLabel1() {
		return label1;
	}

	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}

	public JLabel getLabel3() {
		return label3;
	}

	public void setLabel3(JLabel label3) {
		this.label3 = label3;
	}

}
