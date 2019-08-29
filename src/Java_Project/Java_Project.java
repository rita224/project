package Java_Project;

public class Java_Project {
	public static void main(String[] args) {
		//��l�Ƹ�Ʈw
		Data_Base data_base=new Data_Base();
		
		//GUI�t�m
		
			//First_Frame�n�J�e��

			First_Frame first_frame = new First_Frame(data_base);  //���K�b�����n�J�e���� 1.�}��Second frame 2.��l�ƹC���i�{ 3.���a�]�m
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
			
		//���a�]�w
		int id=0;
		Player player1 = new Player(id,first_frame.input_name1());
		id++;
		Player player2 = new Player(id,first_frame.input_name2());
		id++;
		System.out.println("players already set");
		
		//GUI�t�m
		
			//Second_Frame�C���e��
			
			Second_Frame second_frame = new Second_Frame(player1,player2);
			second_frame.setVisible(true);
			second_frame.setResizable(false);
			second_frame.getLabel1().setText(first_frame.input_name1());
			second_frame.getLabel3().setText(first_frame.input_name2());
			System.out.println("Second frame is created");

		//��l�ƹC���{��
		Game game = new Game(data_base,second_frame,first_frame,player1,player2);
		game.start();  //�}�l�C��
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
				
		//GUI�t�m

			//Final_Frame����e��
			Final_Frame final_frame = new Final_Frame(game);  //���K�b�����n�J�e���� 1.�}��Second frame 2.��l�ƹC���i�{ 3.���a�]�m
			final_frame.setVisible(true);
			final_frame.setResizable(false);
			System.out.println("Final frame is created");

		
		System.out.println("\nover");
	}
}

