import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JInternalFrame;


public class About extends JDialog
{

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			About dialog = new About();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public About()
	{
		setBounds(100, 100, 424, 214);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnBackToGame = new JButton("Back to Game");
			btnBackToGame.setBounds(290, 158, 130, 25);
			contentPanel.add(btnBackToGame);
		}
		{
			JLabel lblTicTacToe = new JLabel("Tic Tac Toe");
			lblTicTacToe.setForeground(new Color(65, 105, 225));
			lblTicTacToe.setFont(new Font("LM Roman Caps 10", Font.BOLD, 20));
			lblTicTacToe.setHorizontalAlignment(SwingConstants.CENTER);
			lblTicTacToe.setBounds(72, 0, 263, 42);
			contentPanel.add(lblTicTacToe);
		}
		{
			JLabel lblVersion = new JLabel("Version 0.1");
			lblVersion.setBounds(5, 23, 150, 42);
			contentPanel.add(lblVersion);
		}
		{
			JLabel lblCreatedByJssuhas = new JLabel("Created by J.S.Suhas");
			lblCreatedByJssuhas.setBounds(5, 70, 180, 42);
			contentPanel.add(lblCreatedByJssuhas);
		}
		{
			JLabel lblForProjectSource = new JLabel("For project source code, visit ");
			lblForProjectSource.setBounds(5, 95, 415, 32);
			contentPanel.add(lblForProjectSource);
		}
		{
			JLabel lblGithubbitesandbytesjavatictactoe = new JLabel("github.com/bitesandbytes/java-2810/TicTacToe");
			lblGithubbitesandbytesjavatictactoe.setHorizontalAlignment(SwingConstants.CENTER);
			lblGithubbitesandbytesjavatictactoe.setBounds(34, 119, 336, 32);
			contentPanel.add(lblGithubbitesandbytesjavatictactoe);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
		}
	}
}