package Java_Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Final_Frame extends JFrame implements ActionListener {
	public boolean finish_Second_Frame=false;
	

	Game game;
	
	public Final_Frame(Game game){
			int i;
			setSize(800,600);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(null);
			setBackground(Color.yellow);
		    this.game = game;
			
		
			
			JLabel printwinner = new JLabel("The winner is:");
			printwinner.setSize(400,32);
			printwinner.setLocation(50,150);
			printwinner.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 32));
			
			
			JLabel printscore = new JLabel("The score is:");
			printscore.setSize(400,32);
			printscore.setLocation(50,250);
			printscore.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 32));
		
			
			JLabel winner_name = new JLabel(game.winner_name);
			winner_name.setSize(400,32);
			winner_name.setLocation(350,150);
			winner_name.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 32));
			
			
			JLabel winner_score = new JLabel(game.winner_score);
			winner_score.setSize(400,32);
			winner_score.setLocation(350,250);
			winner_score.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 32));
			
			
			
	
		if(game.draw == true)
		{
			printscore.setText("Result: Draw!!");
			this.add(printscore);
		}
		else
		{
			this.add(printwinner);
			this.add(printscore);
			this.add(winner_name);
			this.add(winner_score);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}