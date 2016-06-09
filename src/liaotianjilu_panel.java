

import java.awt.Font; 
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class liaotianjilu_panel  extends JFrame{

	JTextArea jilu=null;

	JButton close=null;
	JButton min=null;
	Point point;// 拖曳窗体之前的鼠标位置；（成员变量）
	Font font =new Font("隶书",Font.PLAIN,20);
	public liaotianjilu_panel()
	{
		//arrow_up.setBounds(730, 516, 26, 26);
		this.setBounds(440, 256, 400, 380);
		this.setUndecorated(true);//设置无边框
		this.setAlwaysOnTop(true);
        this.setLayout(null);
		
        this.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				point =e.getPoint();
			}
		});
        // 面板的鼠标拖曳事件中移动窗体
		this.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				Point newpoint=e.getLocationOnScreen();
				setLocation(newpoint.x-point.x,newpoint.y-point.y);
			}
		});

        String name="与"+dialog_panel.user_name.getText()+"聊天记录";
		JLabel lable =new JLabel(name);
		this.add(lable);
		lable.setFont(font);
		lable.setBounds(130, 0, 150, 30);
		
		close=hover_press_utilclass.getbtnClose();
		min=hover_press_utilclass.getbtnMin();
		this.add(close);
		close.setBounds(372, -4, 26, 26);
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		this.add(min);
		min.setBounds(342, -4, 26, 26);
		min.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		
		
		
		jilu=new JTextArea();
//		jilu.setBounds(0, 26, 400, 350);

		JScrollPane jsp=new JScrollPane(jilu);
//		jsp.add(jilu);
		jsp.setBounds(0, 26, 400, 350);
		
		
		
		this.add(jsp);
		//this.add(jilu);
		
		getText();
		
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



		
	



//	public static void main(String[] args) {
//		new liaotianjilu();
//	}

	private void getText() {
//		File file=new File("image/qq/11.txt");
		
		
		String filename="user//"+"(用户)"+dialog_panel.user_name.getText()+"File//liaotianjilu.txt";
		File file=new File(filename);
		try {
//			FileInputStream fis=new FileInputStream(file);
//			InputStreamReader is=new InputStreamReader(fis) ;
//			int n=0;
//			if((n=is.read())!=-1)
//			{
//				System.out.println((char)n);
//			}
//			
//			is.close();
//			fis.close();
			
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String str=null;
			String result="";
			while((str=br.readLine()) != null){
				result+=str+"\r\n";
			}
			
			jilu.setText(result);
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
