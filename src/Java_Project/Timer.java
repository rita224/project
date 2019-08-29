package Java_Project;

public class Timer extends Thread{
	
	static int time = 60;
	int player1_time_remaining=0;
	int player2_time_remaining=0;
	boolean is_player1_timer_stop = false;
	boolean is_player2_timer_stop = false;
	
	Second_Frame second_frame;
	Game game;
	
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
					
					second_frame.timer.setText(time_display+Integer.toString(time));
					//System.out.println(time);

					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						e.printStackTrace();
				     }
					if(game.isIs_player1_answer()==false)
						player1_time_remaining--;
					if(game.isIs_player2_answer()==false)
						player2_time_remaining--;
				}
			}
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
		     }
		}
			

   }

}