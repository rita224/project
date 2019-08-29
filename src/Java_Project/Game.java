package Java_Project;

import java.awt.Color;
import java.util.Random;

public class Game extends Thread {

	private boolean isGameOver = false;
	private int is_player1_correct = 0;
	private boolean is_player1_answer = false;
	private int is_player2_correct = 0;
	private boolean is_player2_answer = false;
	private String[] str = new String[4];
	private int round = 0;
	public String winner_name = "";
	public String winner_score = "";
	public boolean draw = false;
	
	private Data_Base data_base;
	private Timer timer;
	private Second_Frame second_frame;
	private First_Frame first_frame;
	private Player player1;
	private Player player2;
	
	Game(Data_Base data_base, Second_Frame second_frame,First_Frame first_frame,Player player1,Player player2) // 嚙諍構嚙締
	{
		this.timer = new Timer(second_frame, this);
		this.data_base = data_base;
		this.second_frame = second_frame;
		this.first_frame = first_frame;
		this.player1 = player1;
		this.player2 = player2;
	}

	public void run() // 嚙稽嚙瘠嚙踝蕭嚙踝蕭嚙箴
	{
		Random rand = new Random();
		int question_pointer = 0;

		timer.start();

		for (int run_question_num = 1; run_question_num <= 5; run_question_num++) {

			// 嚙踝蕭l嚙踝蕭
			initial_game();

			// 嚙碼嚙瘩
			question_pointer = rand.nextInt(data_base.getNum_question());

			// 嚙瘩嚙諍排迎蕭
			question_setText(question_pointer);
			
			// 嚙踝項嚙複迎蕭
			option_setText(question_pointer);

			// 嚙踝蕭嚙豎回嚙踝蕭嚙諄計嚙褕橘蕭嚙糊嚙編
			wait_for_answer();

			// 嚙踝答嚙論、嚙諄計嚙踝蕭嚙踝蕭
			answer_show(question_pointer);

			// 嚙踝蕭嚙賤此嚙瘩嚙踝蕭嚙稿
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
		player1.setAnswer(0);
		player2.setAnswer(0);
		is_player1_correct = 0;
		is_player2_correct = 0;
		setIs_player1_answer(false);
		setIs_player2_answer(false);
		timer.setIs_player1_timer_stop(false);
		timer.setIs_player2_timer_stop(false);
		timer.setPlayer1_time_remaining(6);
		timer.setPlayer2_time_remaining(6);
		second_frame.getBtn1().setBackground(null);
		second_frame.getBtn2().setBackground(null);
		second_frame.getBtn3().setBackground(null);
		second_frame.getBtn4().setBackground(null);
		second_frame.getBtn5().setBackground(null);
		second_frame.getBtn6().setBackground(null);
	}
	
	private void question_setText(int question_pointer)
	{
		for (int i = 0; i < 4; i++)
			str[i] = "";
		round = 0;
		if (data_base.getQuestion_array()[question_pointer].length() > 15) {
			while (data_base.getQuestion_array()[question_pointer].length() / 15 >= round) {
				if (data_base.getQuestion_array()[question_pointer].length() / 15 == round)
					for (int i = 0; i < data_base.getQuestion_array()[question_pointer].length() % 15; i++)
						str[round] += data_base.getQuestion_array()[question_pointer].charAt(i + 15 * round);
				else
					for (int i = 0; i < 15; i++)
						str[round] += data_base.getQuestion_array()[question_pointer].charAt(i + 15 * round);
				round++;
			}
		} else
			str[0] = data_base.getQuestion_array()[question_pointer];
		
		second_frame.getQst1().setText(str[0]);
		second_frame.getQst2().setText(str[1]);
		second_frame.getQst3().setText(str[2]);
		second_frame.getQst4().setText(str[3]);
	}
	
	private void option_setText(int question_pointer)
	{
		second_frame.getBtn1().setText("(a)" + data_base.getOptiona_array()[question_pointer]);
		second_frame.getBtn2().setText("(s)" + data_base.getOptionb_array()[question_pointer]);
		second_frame.getBtn3().setText("(d)" + data_base.getOptionc_array()[question_pointer]);
		second_frame.getBtn4().setText("(j)" + data_base.getOptiona_array()[question_pointer]);
		second_frame.getBtn5().setText("(k)" + data_base.getOptionb_array()[question_pointer]);
		second_frame.getBtn6().setText("(l)" + data_base.getOptionc_array()[question_pointer]);
	}
	
	private void wait_for_answer()
	{
		while (true) {
			if (second_frame.is_question_on == false) // 嚙緘嚙褕橘蕭嚙踝蕭s
				break;

			if(player1.getAnswer()!=0)
				setIs_player1_answer(true);
			if(player2.getAnswer()!=0)
				setIs_player2_answer(true);
			
			if (player1.getAnswer() != 0 && player2.getAnswer()  != 0) // 嚙踝蕭嚙稷嚙踝蕭嚙璀嚙踝蕭嚙箴嚙踝蕭嚙踝蕭嚙緘嚙踝蕭
			{
				System.out.println("Both have answered.");
				second_frame.is_question_on = false;
				break;
			}

			try {
				Thread.sleep(250);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void answer_show(int question_pointer)
	{
		if (second_frame.is_question_on == false) // 嚙踝蕭嚙踝蕭嚙踝蕭傿嚙踝蕭嚙�
		{
			if (data_base.getAnswer_array()[question_pointer].equalsIgnoreCase("1")) {
				second_frame.getBtn1().setBackground(Color.red);
				second_frame.getBtn4().setBackground(Color.red);
				second_frame.getBtn1().setOpaque(true);
				second_frame.getBtn4().setOpaque(true);
			}
			if (data_base.getAnswer_array()[question_pointer].equalsIgnoreCase("2")) {
				second_frame.getBtn2().setBackground(Color.red);
				second_frame.getBtn5().setBackground(Color.red);
				second_frame.getBtn2().setOpaque(true);
				second_frame.getBtn5().setOpaque(true);
			}
			if (data_base.getAnswer_array()[question_pointer].equalsIgnoreCase("3")) {
				second_frame.getBtn3().setBackground(Color.red);
				second_frame.getBtn6().setBackground(Color.red);
				second_frame.getBtn3().setOpaque(true);
				second_frame.getBtn6().setOpaque(true);
			}
		}
		
		choose_correct_answer_show(0,player1.getAnswer() ,question_pointer);
		choose_correct_answer_show(1,player2.getAnswer(),question_pointer);
	}
	
	private void choose_correct_answer_show(int id,int choose_answer,int question_pointer)
	{
		if (Integer.toString(choose_answer).equals(data_base.getAnswer_array()[question_pointer])) // if player ans correct
		{
			if (data_base.getAnswer_array()[question_pointer].equalsIgnoreCase("1")) {
				if(id==0)
				{
					second_frame.getBtn1().setBackground(Color.green);
					second_frame.getBtn1().setOpaque(true);
				}
				else if(id==1)
				{
					second_frame.getBtn4().setBackground(Color.green);
					second_frame.getBtn4().setOpaque(true);
				}
			}
			if (data_base.getAnswer_array()[question_pointer].equalsIgnoreCase("2")) {
				if(id==0)
				{
					second_frame.getBtn2().setBackground(Color.green);
					second_frame.getBtn2().setOpaque(true);
				}
				else if(id==1)
				{
					second_frame.getBtn5().setBackground(Color.green);
					second_frame.getBtn5().setOpaque(true);
				}
			}
			if (data_base.getAnswer_array()[question_pointer].equalsIgnoreCase("3")) {
				if(id==0)
				{
					second_frame.getBtn3().setBackground(Color.green);
					second_frame.getBtn3().setOpaque(true);
				}
				else if(id==1)
				{
					second_frame.getBtn6().setBackground(Color.green);
					second_frame.getBtn6().setOpaque(true);
				}
			}
		}
	}
	
	private void score(int question_pointer)
	{
		if (Integer.toString(player1.getAnswer()).equals(data_base.getAnswer_array()[question_pointer]))
			is_player1_correct = 10;
		if (Integer.toString(player2.getAnswer()).equals(data_base.getAnswer_array()[question_pointer]))
			is_player2_correct = 10;
		player1.setScore(player1.getScore() + (is_player1_correct * timer.getPlayer1_time_remaining()));
		player2.setScore(player2.getScore() + (is_player2_correct * timer.getPlayer2_time_remaining()));
		second_frame.getLabel2().setText(Integer.toString(player1.getScore()));
		second_frame.getLabel4().setText(Integer.toString(player2.getScore()));
	}
	
	private void final_score()
	{
		
		if(player1.getScore()>player2.getScore())
		{
			winner_name = first_frame.input_name1();
			winner_score = Integer.toString(player1.getScore());
		}
		else if(player1.getScore()<player2.getScore())
		{
			winner_name = first_frame.input_name2();
			winner_score = Integer.toString(player2.getScore());
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

	public boolean isIs_player1_answer() {
		return is_player1_answer;
	}

	public void setIs_player1_answer(boolean is_player1_answer) {
		this.is_player1_answer = is_player1_answer;
	}

	public boolean isIs_player2_answer() {
		return is_player2_answer;
	}

	public void setIs_player2_answer(boolean is_player2_answer) {
		this.is_player2_answer = is_player2_answer;
	}
}