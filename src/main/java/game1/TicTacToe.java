package game1;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TicTacToe implements MouseListener{
	
	private static final String PLAYERX="Player X";
	private static final String PLAYERO="Player O";
	
	private String playerName=PLAYERX;
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JLabel playerNumber;
	private JPanel buttonsPanel;
	
	TicTacToe() {
		buttonsPanel=new JPanel();
		button1=new JButton();
		button2=new JButton();
		button3=new JButton();
		button4=new JButton();
		button5=new JButton();
		button6=new JButton();
		button7=new JButton();
		button8=new JButton();
		button9=new JButton();
		playerNumber=new JLabel(playerName,SwingConstants.CENTER);
		
		button1.addMouseListener(this);
		button2.addMouseListener(this);
		button3.addMouseListener(this);
		button4.addMouseListener(this);
		button5.addMouseListener(this);
		button6.addMouseListener(this);
		button7.addMouseListener(this);
		button8.addMouseListener(this);
		button9.addMouseListener(this);
		
		Font buttonFont=new Font("Times New Roman",Font.PLAIN,60);
		
		button1.setFont(buttonFont);
		button2.setFont(buttonFont);
		button3.setFont(buttonFont);
		button4.setFont(buttonFont);
		button5.setFont(buttonFont);
		button6.setFont(buttonFont);
		button7.setFont(buttonFont);
		button8.setFont(buttonFont);
		button9.setFont(buttonFont);
		
		buttonsPanel.setLayout(new GridLayout(4,3));
		
		buttonsPanel.add(button1);
		buttonsPanel.add(button2);
		buttonsPanel.add(button3);
		buttonsPanel.add(button4);
		buttonsPanel.add(button5);
		buttonsPanel.add(button6);
		buttonsPanel.add(button7);
		buttonsPanel.add(button8);
		buttonsPanel.add(button9);
		
		setPlayerName(PLAYERX);
		buttonsPanel.add(playerNumber);
		
		JFrame f=new JFrame("TicTacToe game");
		f.setContentPane(buttonsPanel);
		f.setSize(300,400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void setPlayerName(String str) {
		this.playerName=str;
		playerNumber.setText(playerName+" your turn.");
	}
	
	private void reset() {
		button1.setText("");
		button2.setText("");
		button3.setText("");
		button4.setText("");
		button5.setText("");
		button6.setText("");
		button7.setText("");
		button8.setText("");
		button9.setText("");
		setPlayerName(PLAYERX);
	}
	
	public void checkForWinner() {
		String[] str= {"OK"};
		
		if(findThreeInARow()) {
			String winnerName=(playerName==PLAYERX)?PLAYERO:PLAYERX;
			
			JOptionPane.showOptionDialog(null,winnerName.concat(" won! Congratulations!!!"),
					"Congratulations!",JOptionPane.YES_OPTION,JOptionPane.PLAIN_MESSAGE,null,str,"OK");
			reset();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton currentButon=(JButton) e.getComponent();
		if(currentButon.getText()=="") {
			if(playerName==PLAYERX) {
				currentButon.setText("X");
				setPlayerName(PLAYERO);
			}
			else if(playerName==PLAYERO) {
				currentButon.setText("0");
				setPlayerName(PLAYERX);
			}
		}
		checkForWinner();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	private boolean findThreeInARow() {
		if((button1.getText()==button2.getText()&&button2.getText()==button3.getText()&&button1.getText()!="")||
				(button4.getText()==button5.getText()&&button5.getText()==button6.getText()&&button4.getText()!="")||
				(button7.getText()==button8.getText()&&button8.getText()==button9.getText()&&button7.getText()!="")||
				(button1.getText()==button4.getText()&&button4.getText()==button7.getText()&&button7.getText()!="")||
				(button2.getText()==button5.getText()&&button5.getText()==button8.getText()&&button2.getText()!="")||
				(button3.getText()==button6.getText()&&button6.getText()==button9.getText()&&button3.getText()!="")||
				(button1.getText()==button5.getText()&&button5.getText()==button9.getText()&&button1.getText()!="")||
				(button3.getText()==button5.getText()&&button5.getText()==button7.getText()&&button7.getText()!="")
				) return true;
		else return false;
	}

}
