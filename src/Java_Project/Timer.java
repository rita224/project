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
		
		while(true)  //����
		{
			if(second_frame.is_question_on==true)
			{
				for(time = 5;time>=-1;time--) {  //�p�ɾ�����
					
					if(second_frame.player1_answer!=0 && second_frame.player2_answer!=0)
						break;
					
					if(time < 0)
					{
						second_frame.is_question_on = false;
						break;
					}
					
					if(time<10)  //�ƪ�
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
					if(second_frame.player1_answer==0)
						player1_time_remaining--;
					if(second_frame.player2_answer==0)
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