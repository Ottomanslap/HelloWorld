package revisedSimplexMethod;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondFrame extends Frame implements ActionListener{

	private Component[] funct;
	private Component[][] lines;
	private int connum;
	private int varnum;
	private Button calc;
	private Choice type;

	public SecondFrame(String var, String con){

		varnum = Integer.parseInt(var);
		connum = Integer.parseInt(con);

		lines = new Component[connum][2 * (varnum + 1)];
		funct = new Component[varnum * 2];

		setSize( ( (varnum + 1) * 150 ) + 10 , ( connum * 50 ) + 260 );
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

		int start = 100;

		for (int x = 0 ; x < funct.length ; x += 2){

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

		//210 / 30 / 240

		for (int y = 0 ; y < lines.length ; y++){



			for (int z = 0 ; z < lines[y].length ; z += 2){

				if (z == (lines[y].length - 2)){

					Choice c = new Choice();
					c.setBounds(-15 + (150 * (z/2)), 210 + (50 * y), 60, 30);
					c.add("<"); c.add(">"); c.add("=");
					add(c);
					lines[y][z + 1] = c;

					TextField t = new TextField();
					t.setBounds(50 + (150 * (z/2)), 210 + (50 * y), 100, 30);
					add(t);
					lines[y][z] = t;

				}else{

					TextField t = new TextField();
					t.setBounds(10 + (150 * (z/2)), 210 + (50 * y), 100, 30);
					add(t);
					lines[y][z] = t;

					if (z == lines[y].length - 4){
						Label l = new Label("X" + ( (z / 2) + 1 ));
						l.setBounds(115 + (150 * (z/2)), 215 + (50 * y), 20, 20);
						add(l);
						lines[y][z + 1] = l;
					}else{
						Label l = new Label("X" + ( (z / 2) + 1 ) + "  +");
						l.setBounds(115 + (150 * (z/2)), 215 + (50 * y), 35, 20);
						add(l);
						lines[y][z + 1] = l;
					}


				}

			}



		}

		int calwid = 100;
		calc = new Button("Calculate");
		calc.setBounds((getWidth() / 2) + 5 ,this.getHeight() - 50, calwid, 30);
		add(calc);
		calc.addActionListener(this);
		
		type = new Choice();
		type.setBounds((getWidth() / 2) - 105 ,this.getHeight() - 50, calwid, 30);
		type.add("Min"); type.add("Max");
		add(type);
		
		setLayout(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		char[]	relations 	= new char[lines.length];
		int[][] constraints = new int[lines.length][lines[0].length/2];
		int[]	function	= new int[funct.length/2];
		String 	mode;
		
		for (int a = 0 ; a < lines.length ; a++)
			relations[a] = ((Choice) lines[a][lines[a].length - 1]).getSelectedItem().charAt(0);
		for (int b = 0 ; b < lines.length ; b++)
			for (int c = 0 ; c < lines[b].length ; c += 2)
				constraints[b][c/2] = Integer.parseInt(((TextField) lines[b][c]).getText());
		for (int d = 0 ; d < funct.length ; d += 2)
			function[d/2] = Integer.parseInt(((TextField) funct[d]).getText());
		mode = type.getSelectedItem();
		
		for (char c : relations)
			System.out.println(c);
		for (int[] l : constraints)
			for (int i : l)
				System.out.println(i);
		for (int i : function)
			System.out.println(i);
		System.out.println(mode);
	}
}
