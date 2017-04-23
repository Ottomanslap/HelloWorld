package revisedSimplexMethod;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class SecondFrame extends Frame {
	
	private Component[] funct;
	private Component[][] lines;
	private int connum;
	private int varnum;
	
	public SecondFrame(String var, String con){
		
		varnum = Integer.parseInt(var);
		connum = Integer.parseInt(con);
		
		lines = new Component[connum][2 * (varnum + 1)];
		funct = new Component[varnum * 2];
		
		setSize((varnum + 1) * 200,(connum * 50) + 190);
		setTitle("Revised Simplex Method");
		
		//40 / 20 / 60
		
		Label label = new Label();
		label.setText("Revised Simplex Method");
		label.setBounds(0,40,getWidth(),20);
		label.setAlignment(Label.CENTER);
		add(label);
		
		//80 / 20 / 100
		
		Label function = new Label();
		function.setText("Function:");
		function.setBounds(0,80,getWidth(),20);
		function.setAlignment(Label.CENTER);
		add(function);
		
		// 120 / 30 / 150
		
		int start = 10;
		
		for (int x = 0 ; x < funct.length ; x += 2){
			System.out.println(x);
			// 10 + 150x w
			funct[x] = new TextField();
			funct[x].setBounds(start + (150 * (x/2)), 120 , 100, 30);
			Label temp = new Label();
			temp.setBounds(105 + start + (150 * (x/2)), 125, 35, 20);
			if (x == funct.length-2)
				temp.setText("X" + (x / 2 + 1));
			else
				temp.setText("X" + (x / 2 + 1) + "  +");
			funct[x+1] = temp;
			add(funct[x]); add(funct[x+1]);
		}
		
		// 170 / 20 / 190
		
		Label constraints = new Label();
		constraints.setText("Constraints:");
		constraints.setBounds(0,170,getWidth(),20);
		constraints.setAlignment(Label.CENTER);
		add(constraints);
		
		
		setLayout(null);
		setVisible(true);
		
	}
}
