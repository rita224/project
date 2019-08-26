package Java_Project;

public class Player extends Thread{
	private int id;
	private String name;
	Player(int id , String name)  //建構子
	{
		this.id=id;
		this.name=name;
	}
	public void run(){  //start後執行以下程式
		while(true)  //確認執行緒進行
		{
			System.out.println("Hello! This is "+name);
			
			try
			{
				this.sleep(1000);  //millisecond
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
