package Java_Project;

public class Java_Project {
	public static void main(String[] args) {
		
		//��l�Ƹ�Ʈw
		Data_Base data_base=new Data_Base();
		
		//GUI�t�m
		
			//First_Frame�n�J�e�� hello
			First_Frame first_frame = new First_Frame(data_base);  //���K�b�����n�J�e���� 1.�}��Second frame 2.��l�ƹC���i�{ 3.���a�]�m
			first_frame.setVisible(true);
			first_frame.setResizable(false);
	}
}
