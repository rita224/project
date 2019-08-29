package Java_Project;

public class Java_Project {
	public static void main(String[] args) {
		
		//初始化資料庫
		Data_Base data_base=new Data_Base();
		
		//GUI配置
		
			//First_Frame登入畫面

			First_Frame first_frame = new First_Frame(data_base);  //順便在結束登入畫面後 1.開啟Second frame 2.初始化遊戲進程 3.玩家設置
			first_frame.setVisible(true);
			first_frame.setResizable(false);
			
			while(true)
				if(first_frame.isFirstFrameFinish()==true)
					break;
				else
					try
					{
						Thread.sleep(1000);
						System.out.println("wait for login.");
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
			//Second_Frame遊戲畫面
			
			Second_Frame second_frame = new Second_Frame();
			second_frame.setVisible(true);
			second_frame.setResizable(false);
			second_frame.label1.setText(first_frame.input_name1());
			second_frame.label3.setText(first_frame.input_name2());
			System.out.println("Second frame is created");
			
		//玩家設定
		int id=0;
		Player player1 = new Player(id,first_frame.input_name1());
		id++;
		Player player2 = new Player(id,first_frame.input_name2());
		id++;
		System.out.println("players already set");

		//初始化遊戲程序
		Game game = new Game(data_base,second_frame,first_frame);
		game.start();  //開始遊戲
		System.out.println("game starts");
		while(true)
			if(game.isGameOver()==true)
				break;
			else
				try
				{
					Thread.sleep(1000);
					System.out.println("wait for game over.");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
		//GUI配置

			//Final_Frame結算畫面
			Final_Frame final_frame = new Final_Frame(game);  //順便在結束登入畫面後 1.開啟Second frame 2.初始化遊戲進程 3.玩家設置
			final_frame.setVisible(true);
			final_frame.setResizable(false);
			System.out.println("Final frame is created");

		
		System.out.println("\nover");
	}
}

