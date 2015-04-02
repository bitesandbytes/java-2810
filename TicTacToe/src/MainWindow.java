import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JMenu;

public class MainWindow
{

	private JFrame frmTicTacToe;
	private About aboutWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainWindow window = new MainWindow();
					window.frmTicTacToe.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow()
	{
		initialize();
		aboutWindow = new About();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmTicTacToe = new JFrame();
		frmTicTacToe.setAlwaysOnTop(true);
		frmTicTacToe.setFont(new Font("Oxygen-Sans", Font.PLAIN, 13));
		frmTicTacToe.setTitle("Tic Tac Toe v1.0");
		frmTicTacToe.setBounds(100, 100, 304, 380);
		frmTicTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar Menu = new JMenuBar();
		frmTicTacToe.setJMenuBar(Menu);

		JMenu Game = new JMenu("Game");
		Menu.add(Game);

		JMenuItem mntmNewGame = new JMenuItem("New Game");
		Game.add(mntmNewGame);

		JMenuItem mntmQuitCurrent = new JMenuItem("Quit Current");
		Game.add(mntmQuitCurrent);

		JMenuItem mntmExit = new JMenuItem("Exit");
		Game.add(mntmExit);

		JMenuItem AboutMenu = new JMenuItem("About");
		AboutMenu.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("Went here.");
				aboutWindow.setVisible(true);
				aboutWindow.setAlwaysOnTop(true);
			}
		});
		Menu.add(AboutMenu);
		frmTicTacToe.getContentPane().setLayout(null);

		JPanel GameArea = new JPanel();
		GameArea.setBounds(-70, 0, 446, 288);
		frmTicTacToe.getContentPane().add(GameArea);
		GameArea.setLayout(null);

		JButton B11 = new JButton("B00");
		B11.setBounds(72, -5, 100, 100);
		GameArea.add(B11);

		JButton B12 = new JButton("B00");
		B12.setBounds(171, -5, 100, 100);
		GameArea.add(B12);

		JButton B13 = new JButton("B00");
		B13.setBounds(270, -5, 100, 100);
		GameArea.add(B13);

		JButton B23 = new JButton("B00");
		B23.setBounds(270, 90, 100, 100);
		GameArea.add(B23);

		JButton B21 = new JButton("B00");
		B21.setBounds(72, 90, 100, 100);
		GameArea.add(B21);

		JButton B22 = new JButton("B00");
		B22.setBounds(171, 90, 100, 100);
		GameArea.add(B22);

		JButton B33 = new JButton("B00");
		B33.setBounds(270, 188, 100, 100);
		GameArea.add(B33);

		JButton B31 = new JButton("B00");
		B31.setBounds(72, 188, 100, 100);
		GameArea.add(B31);

		JButton B32 = new JButton("B00");
		B32.setBounds(171, 188, 100, 100);
		GameArea.add(B32);

		JLabel lblNewLabel = new JLabel("Game Status : ");
		lblNewLabel.setBounds(4, 291, 104, 38);
		frmTicTacToe.getContentPane().add(lblNewLabel);

		JLabel StatusLabel = new JLabel("In Progress");
		StatusLabel.setBounds(114, 291, 180, 38);
		frmTicTacToe.getContentPane().add(StatusLabel);
	}
}
