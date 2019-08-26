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
	}
}
