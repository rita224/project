package Java_Project;

import java.awt.Color;
import java.util.Random;

public class Game extends Thread {

	private boolean isGameOver = false;
	private int player1_score = 0;
	private int is_player1_correct = 0;
	private int player2_score = 0;
	private int is_player2_correct = 0;
	private String[] str = new String[4];
	private int round = 0;
	public String winner_name = "";
	public String winner_score = "";
	public boolean draw = false;
	
	private Data_Base data_base;
	private Timer timer;
	private Second_Frame second_frame;
	private First_Frame first_frame;
	
	Game(Data_Base data_base, Second_Frame second_frame,First_Frame first_frame) // �غc�l
	{
		this.timer = new Timer(second_frame, this);
		this.data_base = data_base;
		this.second_frame = second_frame;
		this.first_frame = first_frame;
	}

	public void run() // �]�C�����e
	{
		Random rand = new Random();
		int question_pointer = 0;
		player1_score = 0;
		player2_score = 0;

		timer.start();

		for (int run_question_num = 1; run_question_num <= 5; run_question_num++) {

			// ��l��
			initial_game();

			// �X�D
			question_pointer = rand.nextInt(data_base.num_question);

			// �D�رƪ�
			question_setText(question_pointer);
			
			// �ﶵ�ƪ�
			option_setText(question_pointer);

			// ���ݦ^���έp�ɾ��k�s
			while (true) {
				if (second_frame.is_question_on == false) // �p�ɾ���s
					break;

				if (second_frame.player1_answer != 0 && second_frame.player2_answer != 0) // ���^���A���e�����p��
				{
					second_frame.is_question_on = false;
					break;
				}

				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// �ﵪ�סB�έp����
			answer_show(question_pointer);

			// ���⦹�D���Z
			score(question_pointer);

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		final_score();
		isGameOver = true;
		second_frame.dispose();
		
		System.out.println("\"game.run()\"thread over.");
	}

	private void initial_game()
	{
		second_frame.is_question_on = true;
		second_frame.player1_answer = 0;
		second_frame.player2_answer = 0;
		is_player1_correct = 0;
		is_player2_correct = 0;
		timer.is_player1_timer_stop = false;
		timer.is_player2_timer_stop = false;
		timer.player1_time_remaining = 6;
		timer.player2_time_remaining = 6;
		second_frame.btn1.setBackground(null);
		second_frame.btn2.setBackground(null);
		second_frame.btn3.setBackground(null);
		second_frame.btn4.setBackground(null);
		second_frame.btn5.setBackground(null);
		second_frame.btn6.setBackground(null);
	}
	
	private void question_setText(int question_pointer)
	{
		for (int i = 0; i < 4; i++)
			str[i] = "";
		round = 0;
		if (data_base.question_array[question_pointer].length() > 15) {
			while (data_base.question_array[question_pointer].length() / 15 >= round) {
				if (data_base.question_array[question_pointer].length() / 15 == round)
					for (int i = 0; i < data_base.question_array[question_pointer].length() % 15; i++)
						str[round] += data_base.question_array[question_pointer].charAt(i + 15 * round);
				else
					for (int i = 0; i < 15; i++)
						str[round] += data_base.question_array[question_pointer].charAt(i + 15 * round);
				round++;
			}
		} else
			str[0] = data_base.question_array[question_pointer];
		
		second_frame.qst1.setText(str[0]);
		second_frame.qst2.setText(str[1]);
		second_frame.qst3.setText(str[2]);
		second_frame.qst4.setText(str[3]);
	}
	
	private void option_setText(int question_pointer)
	{
		second_frame.btn1.setText("(a)" + data_base.optiona_array[question_pointer]);
		second_frame.btn2.setText("(s)" + data_base.optionb_array[question_pointer]);
		second_frame.btn3.setText("(d)" + data_base.optionc_array[question_pointer]);
		second_frame.btn4.setText("(j)" + data_base.optiona_array[question_pointer]);
		second_frame.btn5.setText("(k)" + data_base.optionb_array[question_pointer]);
		second_frame.btn6.setText("(l)" + data_base.optionc_array[question_pointer]);
	}
	
	private void answer_show(int question_pointer)
	{
		if (second_frame.is_question_on == false) // ������ܵ���
		{
			if (data_base.answer_array[question_pointer].equalsIgnoreCase("1")) {
				second_frame.btn1.setBackground(Color.red);
				second_frame.btn4.setBackground(Color.red);
				second_frame.btn1.setOpaque(true);
				second_frame.btn4.setOpaque(true);
			}
			if (data_base.answer_array[question_pointer].equalsIgnoreCase("2")) {
				second_frame.btn2.setBackground(Color.red);
				second_frame.btn5.setBackground(Color.red);
				second_frame.btn2.setOpaque(true);
				second_frame.btn5.setOpaque(true);
			}
			if (data_base.answer_array[question_pointer].equalsIgnoreCase("3")) {
				second_frame.btn3.setBackground(Color.red);
				second_frame.btn6.setBackground(Color.red);
				second_frame.btn3.setOpaque(true);
				second_frame.btn6.setOpaque(true);
			}
		}
		
		choose_correct_answer_show(0,second_frame.player1_answer,question_pointer);
		choose_correct_answer_show(1,second_frame.player2_answer,question_pointer);
	}
	
	private void choose_correct_answer_show(int id,int choose_answer,int question_pointer)
	{
		if (Integer.toString(choose_answer).equals(data_base.answer_array[question_pointer])) // if player ans correct
		{
			if (data_base.answer_array[question_pointer].equalsIgnoreCase("1")) {
				if(id==0)
				{
					second_frame.btn1.setBackground(Color.green);
					second_frame.btn1.setOpaque(true);
				}
				else if(id==1)
				{
					second_frame.btn4.setBackground(Color.green);
					second_frame.btn4.setOpaque(true);
				}
			}
			if (data_base.answer_array[question_pointer].equalsIgnoreCase("2")) {
				if(id==0)
				{
					second_frame.btn2.setBackground(Color.green);
					second_frame.btn2.setOpaque(true);
				}
				else if(id==1)
				{
					second_frame.btn5.setBackground(Color.green);
					second_frame.btn5.setOpaque(true);
				}
			}
			if (data_base.answer_array[question_pointer].equalsIgnoreCase("3")) {
				if(id==0)
				{
					second_frame.btn3.setBackground(Color.green);
					second_frame.btn3.setOpaque(true);
				}
				else if(id==1)
				{
					second_frame.btn6.setBackground(Color.green);
					second_frame.btn6.setOpaque(true);
				}
			}
		}
	}
	
	private void score(int question_pointer)
	{
		if (Integer.toString(second_frame.player1_answer).equals(data_base.answer_array[question_pointer]))
			is_player1_correct = 10;
		if (Integer.toString(second_frame.player2_answer).equals(data_base.answer_array[question_pointer]))
			is_player2_correct = 10;
		player1_score += (is_player1_correct * timer.player1_time_remaining);
		player2_score += (is_player2_correct * timer.player2_time_remaining);
		second_frame.label2.setText(Integer.toString(player1_score));
		second_frame.label4.setText(Integer.toString(player2_score));
	}
	
	private void final_score()
	{
		
		if(player1_score>player2_score)
		{
			winner_name = first_frame.input_name1();
			winner_score = Integer.toString(player1_score);
		}
		else if(player1_score<player2_score)
		{
			winner_name = first_frame.input_name2();
			winner_score = Integer.toString(player2_score);
		}
		else
			draw = true;
		
	}
	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}
}