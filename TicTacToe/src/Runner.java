import java.awt.EventQueue;

public class Runner
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainWindow window = new MainWindow();
					window.launch();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}
