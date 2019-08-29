package Java_Project;

public class Timer extends Thread{
	
	private static int time = 60;
	private int player1_time_remaining=0;
	private int player2_time_remaining=0;
	private boolean is_player1_timer_stop = false;
	private boolean is_player2_timer_stop = false;
	
	private Second_Frame second_frame;
	private Game game;
	
	public Timer(Second_Frame second_frame,Game game)
	{
		this.second_frame = second_frame;
		this.game = game;
	}
	
	public void run() {
		
		String time_display="00:";
		
		while(true)  //偵測
		{
			if(second_frame.is_question_on==true)
			{
				for(time = 5;time>=-1;time--) {  //計時器本體
					
					if((game.isIs_player1_answer()==true) && (game.isIs_player2_answer()==true))
						break;
					
					if(time < 0)
					{
						second_frame.is_question_on = false;
						break;
					}
					
					if(time<10)  //排版
						time_display="00:0";
					else
						time_display="00:";
					
					second_frame.getTimer().setText(time_display+Integer.toString(time));
					//System.out.println(time);

					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						e.printStackTrace();
				     }
					if(game.isIs_player1_answer()==false)
						setPlayer1_time_remaining(getPlayer1_time_remaining() - 1);
					if(game.isIs_player2_answer()==false)
						setPlayer2_time_remaining(getPlayer2_time_remaining() - 1);
				}
			}
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
		     }
		}
			

   }

	public boolean isIs_player1_timer_stop() {
		return is_player1_timer_stop;
	}

	public void setIs_player1_timer_stop(boolean is_player1_timer_stop) {
		this.is_player1_timer_stop = is_player1_timer_stop;
	}

	public boolean isIs_player2_timer_stop() {
		return is_player2_timer_stop;
	}

	public void setIs_player2_timer_stop(boolean is_player2_timer_stop) {
		this.is_player2_timer_stop = is_player2_timer_stop;
	}

	public int getPlayer1_time_remaining() {
		return player1_time_remaining;
	}

	public void setPlayer1_time_remaining(int player1_time_remaining) {
		this.player1_time_remaining = player1_time_remaining;
	}

	public int getPlayer2_time_remaining() {
		return player2_time_remaining;
	}

	public void setPlayer2_time_remaining(int player2_time_remaining) {
		this.player2_time_remaining = player2_time_remaining;
	}

}