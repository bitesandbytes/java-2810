import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class About extends JDialog
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public About()
	{
		setBounds(100, 100, 424, 214);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnBackToGame = new JButton("Back to Game");
			btnBackToGame.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					closeWindow();
				}
			});
			btnBackToGame.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					closeWindow();
				}
			});
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
			JLabel lblForProjectSource = new JLabel(
					"For project source code, visit ");
			lblForProjectSource.setBounds(5, 95, 415, 32);
			contentPanel.add(lblForProjectSource);
		}
		{
			JLabel lblGithubbitesandbytesjavatictactoe = new JLabel(
					"github.com/bitesandbytes/java-2810/TicTacToe");
			lblGithubbitesandbytesjavatictactoe
					.setHorizontalAlignment(SwingConstants.CENTER);
			lblGithubbitesandbytesjavatictactoe.setBounds(34, 119, 336, 32);
			contentPanel.add(lblGithubbitesandbytesjavatictactoe);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
		}
	}

	public void closeWindow()
	{
		this.setVisible(false);
		this.dispose();
		return;
	}
}