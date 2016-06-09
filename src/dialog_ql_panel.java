
import java.awt.BorderLayout;  
import java.awt.Color ;  
import java.awt.Font;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.*;


public class dialog_ql_panel extends JFrame{

	JButton min,big,close,shezhi,guanbi,fasong;
	
	JButton btn1[]=new JButton[5];
	String btn1_str[]={"liaotian","gg","xc","wenjian","yingyong"};
		
	
	JButton btn2[]=new JButton[10];
	String btn2_str[]={"ziti","bianqing","mfbq","pmdd","yyxx","dgnsr","fstp","diange","jietu","xiaoxi"};
	
	JLabel title_img,user_name,tongzhi,quncy;
	
	JPanel pane1,pane2,pane3,pane4;
	JTextArea xiansixiaoxi,tongzhiArea;
	JTextField fasongxiaoxi;
	
	
	
	JList quncy_liat;
	public static String quncy_name[]={"1","2","3","4"};
	
	 String qun_title="dfdfdfd";
	Point point;
	 FriendList qqList;
	
	
	
	
	
	Socket s = null;
	DataOutputStream dos = null;
	DataInputStream dis = null;
	private boolean bConnected = false;

	Thread tRecv = new Thread(new RecvThread()); 
	String qunName;
	
	public dialog_ql_panel(String qunName)
	{
		this.qun_title=qunName;
		
		this.setAlwaysOnTop(true);
		shezhi=hover_press_utilclass.getbtnShezhi();
		shezhi.setIcon(new ImageIcon("image/dialog/shezhi.png"));
		shezhi.setPressedIcon(new ImageIcon("image/dialog/shezhi_p.png"));
		shezhi.setRolloverIcon(new ImageIcon("image/dialog/shezhi_hover.png"));
		shezhi.setBounds(436, 2, 25, 16);
		add(shezhi);
		
		min=hover_press_utilclass.getbtnMin();
		min.setBounds(464, 2, 25, 16);
		add(min);
		min.setIcon(new ImageIcon("image/dialog/min.png"));
		min.setPressedIcon(new ImageIcon("image/dialog/min_p.png"));
		min.setRolloverIcon(new ImageIcon("image/dialog/min_hover.png"));
		min.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		
		big=hover_press_utilclass.getbtnClose();
		big.setBounds(492, 2, 25, 16);
		add(big);
		big.setIcon(new ImageIcon("image/dialog/big.png"));
		big.setRolloverIcon(new ImageIcon("image/dialog/big_hover.png"));
		big.setPressedIcon(new ImageIcon("image/dialog/big_p.png"));
		
		close=hover_press_utilclass.getbtnClose();
		close.setBounds(520, 2, 33, 16);
		add(close);
		close.setIcon(new ImageIcon("image/dialog/close.png"));
		close.setRolloverIcon(new ImageIcon("image/dialog/close_hover.png"));
		close.setPressedIcon(new ImageIcon("image/dialog/close_p.png"));
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				dialog_ql_panel.this.dispose();
			}
		});
		
		//关闭按钮
		guanbi=hover_press_utilclass.getbtnButton("image/dialog/guanbi.png", "image/dialog/guanbi_hover.png", "image/dialog/guanbi_p.png");
		guanbi.setBounds(230, 503, 71, 24);
		guanbi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				dialog_ql_panel.this.dispose();
			}
		});
		add(guanbi);
		
		//发送按钮
		fasong=hover_press_utilclass.getbtnButton("image/dialog/fasong.png", "image/dialog/fasong_hover.png", "image/dialog/fasong_p.png");
		fasong.setBounds(310, 503, 83, 24);
		add(fasong);
		 fasong.addActionListener(new TFListener());
		
		title_img=new JLabel(new ImageIcon("image/dialog/qun.png"));
		title_img.setBounds(11, 11, 44, 44);
		add(title_img);
		
		user_name=new JLabel();
		user_name.setText(qun_title);
		user_name.setBounds(56, 12, 500, 20);
		add(user_name);
		
		//显示群里通知
		tongzhi=new JLabel(new ImageIcon("image/dialog/tongzhi.png"));
		tongzhi.setBounds(405, 90, 147, 20);
		add(tongzhi);
		
		tongzhiArea=new JTextArea();
		tongzhiArea.setLineWrap(true);
		tongzhiArea.setFont(new Font("楷体",Font.BOLD,22));
		tongzhiArea.setEditable(false);
		tongzhiArea.setText("由于时间较为紧,本群的按钮功能尚未实现");
		JScrollPane jsa_tz=new JScrollPane(tongzhiArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane3=new JPanel();
		pane3.setLayout(new BorderLayout());
		pane3.add(jsa_tz);
		pane3.setBounds(405, 110, 147, 200);
		add(pane3);
		
		
		//显示群成员
		quncy=new JLabel(new ImageIcon("image/dialog/quncy.png"));
		quncy.setBounds(405, 310, 147, 20);
		add(quncy);
		
		quncy_liat=new JList(quncy_name);
		JScrollPane jsa_quncy=new JScrollPane(quncy_liat, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane4=new JPanel(new BorderLayout());
		pane4.setBounds(405, 330, 147, 200);
		pane4.add(jsa_quncy);
		add(pane4);
		
	
	    	   ClientUser qqClientUser=new ClientUser();
				User u=new User();
				u.setUserId(Login.user.getText().trim());
				u.setPasswd(new String(Login.psw.getPassword()));
				
				
				if(qqClientUser.checkUser(u))
				{
					try {
						//把创建好友列表的语句提前.
						
						qqList=new FriendList(u.getUserId());
						jsa_quncy.add(qqList);
						jsa_quncy.setViewportView(qqList);
						ManageFriendList.addQqFriendList(u.getUserId(), qqList);
						
						//发送一个要求返回在线好友的请求包.
						ObjectOutputStream oos=new ObjectOutputStream
						(ManageClientConServerThread.getClientConServerThread(u.getUserId()).getS().getOutputStream());
						
						//做一个Message
						Message m=new Message();
						m.setMesType(MessageType.message_get_onLineFriend);
						//指明我要的是这个qq号的好友情况.
						m.setSender(u.getUserId());
						oos.writeObject(m);
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					
					
				}
		
		
		
		
		
		
		
		
		//发送消息窗口
		fasongxiaoxi=new JTextField();
	//	fasongxiaoxi.setLineWrap(true);
		JScrollPane jsa=new JScrollPane(fasongxiaoxi, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane1=new JPanel();
		pane1.setLayout(new BorderLayout());
		pane1.add(jsa);
		pane1.setBounds(5,410, 395, 90);
		add(pane1);
		
		//显示对话消息
		xiansixiaoxi=new JTextArea();
		
		xiansixiaoxi.setLineWrap(true);
		JScrollPane jsa1=new JScrollPane(xiansixiaoxi, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane2=new JPanel();
		pane2.setLayout(new BorderLayout());
		pane2.add(jsa1);
		pane2.setBounds(5, 95, 395, 285);
		add(pane2);
		
		int x1=1;
		for(int i=0;i<5;i++)
		{
			btn1[i]=hover_press_utilclass.getbtnButton("image/dialog/"+btn1_str[i]+".png", "image/dialog/"+btn1_str[i]+"_hover.png", "image/dialog/"+btn1_str[i]+".png");
			btn1[i].setBackground(new Color(255,255,255));
			btn1[i].setBorder(null);
			
			btn1[i].setBounds(x1, 55, 71, 35);
			x1+=72;
			add(btn1[i]);
		}
		
		int x2=3;
		for(int i=0;i<10;i++)
		{
			btn2[i]=hover_press_utilclass.getbtnButton("image/dialog/"+btn2_str[i]+".png", "image/dialog/"+btn2_str[i]+"_hover.png", "image/dialog/"+btn2_str[i]+".png");
			btn2[i].setBounds(x2, 382, 20, 20);
			btn2[i].setBorder(null);
			if(i==9)
			{
				btn2[i].setBounds(300, 380, 103,28 );
			}
			x2+=30;
			add(btn2[i]);
		}

	
		background_utilclass bg=new background_utilclass();
		bg.setImage(dialog_ql_panel.this.getToolkit().getImage(dialog_ql_panel.this.getClass().getResource("dialogbg.png")));
		bg.setBounds(0, 0, 555,535);
		this.add(bg);
		
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
				
				setLocation(newpoint.x - point.x,newpoint.y-point.y);
				
			}
		});
		
	
			
			this.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent arg0) {
					disconnect();
					System.exit(0);
				}
				
			});
			fasongxiaoxi.addActionListener(new TFListener());
	       
			connect();
			
			tRecv.start();
			
			
			this.setUndecorated(true);
			this.setSize(555, 535);
			this.setTitle(qun_title);
			this.setLayout(null);
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("qun.png")));
			//this.setDefasongxiaoxiultCloseOperation(this.EXIT_ON_CLOSE);
			this.setAlwaysOnTop(true);
	
			
			
	}
	
	public void connect() {
		try {
			s = new Socket("127.0.0.1", 8888);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
		 //   System.out.println("ceshidis);
            System.out.println("登录群聊界面,端口正常连接!");
			bConnected = true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void disconnect() {
		try {
			dos.close();
			dis.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		try {
			bConnected = fasongxiaoxilse;
			tRecv.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				dis.close();
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
	}
	
	private class TFListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String str = fasongxiaoxi.getText().trim();
			//xiansixiaoxi.setText(str);
			fasongxiaoxi.setText("");
			
			try {
               //System.out.println(s);
				dos.writeUTF(str);
		
				dos.flush();
				//dos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}
	
	private class RecvThread implements Runnable {

		public void run() {
			try {
				while(bConnected) {
					String str = dis.readUTF();
					//System.out.println(str);
					DateFormat df = DateFormat.getDateInstance();// 获得DateFormat实例
				    String dateString = df.format(new Date());         // 格式化为日期
				     df = DateFormat.getTimeInstance(DateFormat.MEDIUM);// 获得DateFormat实例
				     String timeString = df.format(new Date());         // 格式化为时间
					
					
					xiansixiaoxi.setText(xiansixiaoxi.getText()+"       "+dateString+"   "+timeString+"\r\n" + str + '\n');
				}
			} catch (SocketException e) {
				System.out.println("退出了，bye!");
			} catch (EOFException e) {
				System.out.println("退出了，bye - bye!");
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		}
		
	}
//	public static void main(String args[])
//	{
//		new dialog_ql_panel();
//	}
	
}