package Java_Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//hello!!!!!!!!!!

public class Data_Base {
	
	int num_question=20;
	String[] question_array;
	String[] optiona_array;
	String[] optionb_array;
	String[] optionc_array;
	String[] answer_array;
	
	Data_Base()
	{
		//變數宣告
		String[] question_array = new String[num_question];
		String[] optiona_array = new String[num_question];
		String[] optionb_array = new String[num_question];
		String[] optionc_array = new String[num_question];
		String[] answer_array = new String[num_question];
		

		//存取資料庫(scanner)
		Scanner scanner;
		try {
			scanner = new Scanner(new FileInputStream("C:\\Users\\USER\\Desktop\\Coding-X\\Java_Project資料夾\\source\\example.txt"));
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
