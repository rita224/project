package Java_Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Data_Base {
	
	private int num_question=20;
	private String[] question_array;
	private String[] optiona_array;
	private String[] optionb_array;
	private String[] optionc_array;
	private String[] answer_array;
	
	public Data_Base()
	{
		//�ܼƫŧi
		String[] question_array = new String[num_question];
		String[] optiona_array = new String[num_question];
		String[] optionb_array = new String[num_question];
		String[] optionc_array = new String[num_question];
		String[] answer_array = new String[num_question];
		

		//�s����Ʈw(scanner)
		Scanner scanner;
		try {
			scanner = new Scanner(new FileInputStream("C:\\Users\\USER\\Desktop\\Coding-X\\Java_Project��Ƨ�\\source\\example.txt"));
			for(int i =0;i<num_question;i++)
			{
				question_array[i]=scanner.nextLine();
				optiona_array[i]=scanner.nextLine();
				optionb_array[i]=scanner.nextLine();
				optionc_array[i]=scanner.nextLine();
				answer_array[i]=scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.question_array=question_array;
		this.optiona_array=optiona_array;
		this.optionb_array=optionb_array;
		this.optionc_array=optionc_array;
		this.answer_array=answer_array;
	}
}
