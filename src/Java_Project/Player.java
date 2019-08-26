package Java_Project;

public class Player extends Thread{
	private int id;
	private String name;
	Player(int id , String name)  //�غc�l
	{
		this.id=id;
		this.name=name;
	}
	public void run(){  //start�����H�U�{��
		while(true)  //�T�{������i��
		{
			System.out.println("Hello! This is "+name);
			
			try
			{
				this.sleep(1000);  //millisecond helootest
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
