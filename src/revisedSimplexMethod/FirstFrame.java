package revisedSimplexMethod;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame extends Frame implements ActionListener{
	
	TextField tf1; TextField tf2;
	
	public FirstFrame(){
		
		setSize(300,230);
		setTitle("Revised Simplex Method");
		
		Label label = new Label();
		label.setText("Revised Simplex Method");
		label.setBounds(0,40,300,20);
		label.setAlignment(Label.CENTER);
		add(label);
		
		Button enter = new Button("Enter");
		enter.setBounds(110, 180, 80, 30);
		add(enter);
		
		enter.addActionListener(this);
		
		Label l1 = new Label();
		l1.setText("Number of Variables:");
		l1.setBounds(10,85,150,20);
		l1.setAlignment(Label.LEFT);
		add(l1);
		
		Label l2 = new Label();
		l2.setText("Number of Constraints:");
		l2.setBounds(10,135,150,20);
		l2.setAlignment(Label.LEFT);
		add(l2);
		
		tf1 = new TextField();
		tf1.setBounds(180, 80, 100, 30);
		
		tf2 = new TextField();
		tf2.setBounds(180, 130, 100, 30);
		
		add(tf1);
		add(tf2);
		
		setLayout(null);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		Frame second = new SecondFrame(tf1.getText(),tf2.getText());
		
	}
	
}
