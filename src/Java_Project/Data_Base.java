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
		//變數宣告
		String[] question_array = new String[getNum_question()];
		String[] optiona_array = new String[getNum_question()];
		String[] optionb_array = new String[getNum_question()];
		String[] optionc_array = new String[getNum_question()];
		String[] answer_array = new String[getNum_question()];
		

		//存取資料庫(scanner)
		Scanner scanner;
		try {
			scanner = new Scanner(new FileInputStream("C:\\Users\\USER\\Desktop\\Coding-X\\Java_Project資料夾\\source\\example.txt"));
			for(int i =0;i<getNum_question();i++)
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

	public int getNum_question() {
		return num_question;
	}

	public String[] getQuestion_array() {
		return question_array;
	}

	public String[] getOptiona_array() {
		return optiona_array;
	}

	public String[] getOptionb_array() {
		return optionb_array;
	}

	public String[] getOptionc_array() {
		return optionc_array;
	}

	public String[] getAnswer_array() {
		return answer_array;
	}
}
