import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Notepad{
	private JFrame window = new JFrame();
	
	public Notepad(){
		window.setBounds(300,100,800,600);
		window.setLayout(new BorderLayout(5,5));
		
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		new Notepad();
	}
}