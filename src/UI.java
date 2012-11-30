import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

@SuppressWarnings("serial")
public class UI extends JFrame implements ActionListener {

	public boolean asked;
	private JFrame frame;
	private JPanel mainPanel, subPanel1, subPanel2, inv;
	private JTextArea textA;
	private JScrollPane textS;
	private JTextField textF;
	private String input;
	private String pName;
	private Character player;
	private JButton [] b = new JButton [9];

	@SuppressWarnings("deprecation")
	public UI() {

		pName = "";
		frame = new JFrame("Java_RPG");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBackground(Color.black);

		mainPanel = new JPanel();
		subPanel1 = new JPanel();
		subPanel2 = new JPanel();
		inv = new JPanel();
		
		inv.setLayout(new BoxLayout(inv, BoxLayout.Y_AXIS));
		
		for(int i = 0; i <= 8; i++) {
			b[i] = new JButton();
			b[i].setFocusable(false);
			b[i].setRolloverEnabled(false);
			b[i].setVisible(false);
			b[i].setSize(new Dimension(90,90));
			inv.add(b[i]);
		}

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		subPanel1.setLayout(new BoxLayout(subPanel1, BoxLayout.X_AXIS));
		subPanel2.setLayout(new BoxLayout(subPanel2, BoxLayout.Y_AXIS));

		b[0].setIcon(new ImageIcon("map.png"));
		b[1].setIcon(new ImageIcon("axe.png"));
		b[2].setIcon(new ImageIcon("pickaxe.png"));
		b[3].setIcon(new ImageIcon("wood.png"));
		b[4].setIcon(new ImageIcon("stone.png"));
		b[5].setIcon(new ImageIcon("iron.png"));
		b[6].setIcon(new ImageIcon("gold.png"));
		b[7].setIcon(new ImageIcon("potion.png"));
		b[8].setIcon(new ImageIcon("sword.png"));

		textA = new JTextArea();
		textS = new JScrollPane(textA);
		textF = new JTextField();

		textF.addActionListener(this);


		textA.setEditable(false);
		subPanel2.add(inv);
		subPanel1.add(subPanel2);
		subPanel1.add(textS);
		mainPanel.add(subPanel1);
		mainPanel.add(textF);
		textS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textS.setBorder(BorderFactory.createLoweredBevelBorder());
		textF.setBorder(BorderFactory.createLineBorder(Color.black));
		textS.setPreferredSize(new Dimension(900, 500));
		frame.add(mainPanel);
		frame.pack();
		frame.show();
		asked = false;

	}

	public void setCharName(String charName) throws NumberFormatException, IOException {
		pName = charName;
		player = new Character(pName);
		update();
	}

	public void pln(String text) {

		textA.append(text + "\n");

		JScrollBar vertical = textS.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum()+1);
		if(pName.length() > 0) {
			update();
		}
		frame.validate();
	}

	public void pr(String text) {

		textA.append(text);
		JScrollBar vertical = textS.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());
		if(pName.length() > 0) {
			update();
		}
		frame.validate();
	}

	public void actionPerformed(ActionEvent evt) {       
		input = textF.getText();
		asked = true;

	}

	public String getString() {

		asked = false;
		textF.setText("");
		return input;
	}

	public void update() {
		if(pName.length() > 0) {
			try {
				player.update();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(player.getMap() > 0) {
				b[0].setVisible(true);
				String str = "";
				if(player.getMap() == 2)
					str = "Upgraded ";
				b[0].setText(str+"Map-");
			} else b[0].setVisible(false);
			if(player.getAxe()) {
				b[1].setVisible(true);
				b[1].setText("Axe-"+Boolean.toString(player.getAxe()));
			} else b[1].setVisible(false);
			if(player.getPick()) {
				b[2].setVisible(true);
				b[2].setText("Pick-"+Boolean.toString(player.getPick()));
			} else b[2].setVisible(false);
			if(player.getWood() > 0) {
				b[3].setVisible(true);
				b[3].setText("Wood-"+Integer.toString(player.getWood()));
			} else b[3].setVisible(false);
			if(player.getStone() > 0) {
				b[4].setVisible(true);
				b[4].setText("Stone-"+Integer.toString(player.getStone()));
			} else b[4].setVisible(false);
			if(player.getIron() > 0) {
				b[5].setVisible(true);
				b[5].setText("Iron-"+Integer.toString(player.getIron()));
			} else b[5].setVisible(false);
			if(player.getGold() > 0) {
				b[6].setVisible(true);
				b[6].setText("Gold-"+Integer.toString(player.getGold()));
			} else b[6].setVisible(false);
			if(player.getHPot() > 0) {
				b[7].setVisible(true);
				b[7].setText("Health Potions-"+Integer.toString(player.getHPot()));
			} else b[7].setVisible(false);
			b[8].setVisible(true);
			try {
				b[8].setText("Weapon-"+Integer.toString(player.getWeapon()));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
