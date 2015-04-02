import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow
{

	private JFrame frmTicTacToe;
	private About aboutWindow;
	private TicTacToeBoard board;
	private int player;
	private JLabel GameStatus;

	/**
	 * Launch the application.
	 */
	public void launch()
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
		board = new TicTacToeBoard();
		player = 0;
		GameStatus = new JLabel("Waiting for Player 1 to make a move.");
	}

	// Initialize the contents of the frame.
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
		mntmNewGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				board = new TicTacToeBoard();
				player = 0;
				GameStatus = new JLabel("Waiting for Player 1 to make a move.");
			}
		});
		Game.add(mntmNewGame);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				frmTicTacToe.dispose();
			}
		});
		Game.add(mntmExit);

		JMenuItem AboutMenu = new JMenuItem("About");
		AboutMenu.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
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
		B11.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setBoard(0, 0);
			}
		});
		B11.setBounds(72, -5, 100, 100);
		GameArea.add(B11);

		JButton B12 = new JButton("B00");
		B12.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setBoard(0, 1);
			}
		});
		B12.setBounds(171, -5, 100, 100);
		GameArea.add(B12);

		JButton B13 = new JButton("B00");
		B13.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setBoard(0, 2);
			}
		});
		B13.setBounds(270, -5, 100, 100);
		GameArea.add(B13);

		JButton B23 = new JButton("B00");
		B23.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setBoard(1, 2);
			}
		});
		B23.setBounds(270, 90, 100, 100);
		GameArea.add(B23);

		JButton B21 = new JButton("B00");
		B21.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setBoard(1, 0);
			}
		});
		B21.setBounds(72, 90, 100, 100);
		GameArea.add(B21);

		JButton B22 = new JButton("B00");
		B22.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setBoard(1, 1);
			}
		});
		B22.setBounds(171, 90, 100, 100);
		GameArea.add(B22);

		JButton B33 = new JButton("B00");
		B33.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setBoard(2, 2);
			}
		});
		B33.setBounds(270, 188, 100, 100);
		GameArea.add(B33);

		JButton B31 = new JButton("B00");
		B31.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setBoard(2, 0);
			}
		});
		B31.setBounds(72, 188, 100, 100);
		GameArea.add(B31);

		JButton B32 = new JButton("B00");
		B32.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setBoard(2, 1);
			}
		});
		B32.setBounds(171, 188, 100, 100);
		GameArea.add(B32);

		JLabel lblNewLabel = new JLabel("Game Status : ");
		lblNewLabel.setBounds(4, 291, 104, 38);
		frmTicTacToe.getContentPane().add(lblNewLabel);

		GameStatus.setBounds(114, 291, 180, 38);
		frmTicTacToe.getContentPane().add(GameStatus);
	}

	private void setBoard(int x, int y)
	{
		// If attempted to set an already set cell.
		if (!board.set(x, y, player))
		{
			JOptionPane
					.showMessageDialog(frmTicTacToe,
							"You can't play this move.\nSelect an empty cell to mark as yours.");
		}

		// If the match has ended.
		if (board.isComplete())
		{
			JOptionPane
					.showMessageDialog(frmTicTacToe,
							"You can't play this game anymore.\n Start a new game using the Game menu.");
			if (board.whoWon() == 0)
				GameStatus.setText("Player 1 wins.");
			else if (board.whoWon() == 1)
				GameStatus.setText("Player 2 wins.");
			else
				GameStatus.setText("Match Drawn.");
		}

		// If match in progress.
		else
		{
			GameStatus.setText("Waiting for Player " + (player + 1) + ".");
			player = 1 - player;
		}
	}
}
