package Java_Project;

import java.awt.Color;
import java.util.Random;

public class Game extends Thread {

	private int player1_score = 0;
	private int is_player1_correct = 0;
	private int player2_score = 0;
	private int is_player2_correct = 0;
	private String[] str = new String[4];
	private int round = 0;
	public String winner_name = "";
	public String winner_score = "";
	public boolean draw = false;
	
	Data_Base data_base;
	Timer timer;
	Second_Frame second_frame;
	First_Frame first_frame;
	
	Game(Data_Base data_base, Second_Frame second_frame,First_Frame first_frame) // 建構子
	{
		this.timer = new Timer(second_frame, this);
		this.data_base = data_base;
		this.second_frame = second_frame;
		this.first_frame = first_frame;
	}

	public void run() // 跑遊戲內容
	{
		Random rand = new Random();
		int question = 0;
		player1_score = 0;
		player2_score = 0;

		timer.start();

		for (int run_question_num = 1; run_question_num <= 1; run_question_num++) {

			// 初始化
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

			// 出題
			question = rand.nextInt(data_base.num_question);

			for (int i = 0; i < 4; i++) // 題目排版
				str[i] = "";
			round = 0;
			if (data_base.question_array[question].length() > 15) {
				while (data_base.question_array[question].length() / 15 >= round) {
					if (data_base.question_array[question].length() / 15 == round)
						for (int i = 0; i < data_base.question_array[question].length() % 15; i++)
							str[round] += data_base.question_array[question].charAt(i + 15 * round);
					else
						for (int i = 0; i < 15; i++)
							str[round] += data_base.question_array[question].charAt(i + 15 * round);
					round++;
				}
			} else
				str[0] = data_base.question_array[question];

			second_frame.qst1.setText(str[0]);
			second_frame.qst2.setText(str[1]);
			second_frame.qst3.setText(str[2]);
			second_frame.qst4.setText(str[3]);
			second_frame.btn1.setText("(a)" + data_base.optiona_array[question]);
			second_frame.btn2.setText("(s)" + data_base.optionb_array[question]);
			second_frame.btn3.setText("(d)" + data_base.optionc_array[question]);
			second_frame.btn4.setText("(j)" + data_base.optiona_array[question]);
			second_frame.btn5.setText("(k)" + data_base.optionb_array[question]);
			second_frame.btn6.setText("(l)" + data_base.optionc_array[question]);

			// 等待回答或計時器歸零
			while (true) {
				if (second_frame.is_question_on == false) // 計時器到零
					break;

				if (second_frame.player1_answer != 0 && second_frame.player2_answer != 0) // 都回答，提前結束計時
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

			// 對答案、統計分數

			// display answer
			if (second_frame.is_question_on == false) // 紅色顯示答案
			{
				if (data_base.answer_array[question].equalsIgnoreCase("1")) {
					second_frame.btn1.setBackground(Color.red);
					second_frame.btn4.setBackground(Color.red);
					second_frame.btn1.setOpaque(true);
					second_frame.btn4.setOpaque(true);
				}
				if (data_base.answer_array[question].equalsIgnoreCase("2")) {
					second_frame.btn2.setBackground(Color.red);
					second_frame.btn5.setBackground(Color.red);
					second_frame.btn2.setOpaque(true);
					second_frame.btn5.setOpaque(true);
				}
				if (data_base.answer_array[question].equalsIgnoreCase("3")) {
					second_frame.btn3.setBackground(Color.red);
					second_frame.btn6.setBackground(Color.red);
					second_frame.btn3.setOpaque(true);
					second_frame.btn6.setOpaque(true);
				}
			}

			if (Integer.toString(second_frame.player1_answer).equals(data_base.answer_array[question])) // if player1
																										// ans is
																										// correct
			{
				if (data_base.answer_array[question].equalsIgnoreCase("1")) {
					second_frame.btn1.setBackground(Color.green);
					second_frame.btn1.setOpaque(true);
				}
				if (data_base.answer_array[question].equalsIgnoreCase("2")) {
					second_frame.btn2.setBackground(Color.green);
					second_frame.btn2.setOpaque(true);
				}
				if (data_base.answer_array[question].equalsIgnoreCase("3")) {
					second_frame.btn3.setBackground(Color.green);
					second_frame.btn3.setOpaque(true);
				}
			}

			if (Integer.toString(second_frame.player2_answer).equals(data_base.answer_array[question])) // if player2
																										// ans is
																										// correct
			{
				if (data_base.answer_array[question].equalsIgnoreCase("1")) {
					second_frame.btn4.setBackground(Color.green);
					second_frame.btn4.setOpaque(true);
				}
				if (data_base.answer_array[question].equalsIgnoreCase("2")) {
					second_frame.btn5.setBackground(Color.green);
					second_frame.btn5.setOpaque(true);
				}
				if (data_base.answer_array[question].equalsIgnoreCase("3")) {
					second_frame.btn6.setBackground(Color.green);
					second_frame.btn6.setOpaque(true);
				}
			}

			// compute scores
			if (Integer.toString(second_frame.player1_answer).equals(data_base.answer_array[question]))
				is_player1_correct = 10;
			if (Integer.toString(second_frame.player2_answer).equals(data_base.answer_array[question]))
				is_player2_correct = 10;
			player1_score += (is_player1_correct * timer.player1_time_remaining);
			player2_score += (is_player2_correct * timer.player2_time_remaining);
			second_frame.label2.setText(Integer.toString(player1_score));
			second_frame.label4.setText(Integer.toString(player2_score));

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(player1_score>player2_score)
		{
			winner_name = first_frame.player1_name;
			winner_score = Integer.toString(player1_score);
		}
		else if(player1_score<player2_score)
		{
			winner_name = first_frame.player2_name;
			winner_score = Integer.toString(player2_score);
		}
		else
			draw =true;
		second_frame.dispose();
		Final_Frame final_frame = new Final_Frame(this);  //順便在結束登入畫面後 1.開啟Second frame 2.初始化遊戲進程 3.玩家設置
		final_frame.setVisible(true);
		final_frame.setResizable(false);
	}
}
