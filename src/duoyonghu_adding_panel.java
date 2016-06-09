






	import java.awt.Color ;    
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

	import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



	public class duoyonghu_adding_panel extends JFrame implements ActionListener{
		
		private JButton close,min,btnConfirm;
		static JButton btnCancel;
		static  JTextField user;
		static  JPasswordField psw;
		private JLabel headimg,headimgbg;
	    Point point;
		

	    
		
		Font font = new Font("微软雅黑", Font.PLAIN, 12);
		
		Container con=this.getContentPane();
		
	   
		 int screenwidth,screenheight;
		
		
		 duoyonghu_logining_thread ing;
		 public duoyonghu_adding_panel(duoyonghu_logining_thread ing)
		 {
			 this.ing=ing;
		 }
	    	duoyonghu_panel duo;
		public duoyonghu_adding_panel(duoyonghu_panel duo)
		{
			this.duo=duo;
		}
		
	
		public void launch()
		{
			this.setUndecorated(true);
			this.setAlwaysOnTop(true);
			this.setSize(437,340);
		    this.setVisible(true);
		   
		    
		 
			
		    
		    
		    /*居中*/
			Toolkit kit=Toolkit.getDefaultToolkit();
			Dimension screensize=kit.getScreenSize();
			 screenwidth=(int)screensize.getWidth();
			 screenheight=(int)screensize.getHeight();
			this.setLocation(screenwidth/2-this.getWidth()/2,screenheight/2-this.getHeight()/2 );
			
			
			
	         
//				@Override
//				public void windowActivated(WindowEvent e) {
//					// TODO Auto-generated method stub
	//
//					new Thread() {// 创建新线程
//	    	            public void run() {
//	    	               
//	    	                for (int i = 0; i <=340; i += 85) {// 循环拉伸窗体
//	    	                    setBounds( screenwidth/2-437/2, screenheight/2-i/2,437, i);// 不断设置窗体大小与位置
//	    	                    try {
//	    	                        Thread.sleep(5);// 线程休眠10毫秒
//	    	                    } catch (InterruptedException e1) {
//	    	                        e1.printStackTrace();
//	    	                    }
//	    	                }
//	    	            }
//	    	        }.start();// 启动线程
//		    	       
//				}
	          
			
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
		    
		    
		    
			// 登陆头像及背景
			headimg=new JLabel(new ImageIcon("image/headimg.png"));
			headimgbg=new JLabel(new ImageIcon("image/headimgbg.png"));
			this.setLayout(null);
			
			headimg.setBounds(42, 197, 80, 79);
			headimgbg.setBounds(40, 195, 84,84);
			con.add(headimg);
			con.add(headimgbg);
			
			
			
			
			user=new JTextField(1000);
			user.addActionListener(this);
			user.setBorder(BorderFactory.createLineBorder(Color.black));
			user.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e)
				{
					user.setBorder(BorderFactory.createLineBorder(Color.red));
					
				}
				public void mouseEntered(MouseEvent e)
				{
					user.setBorder(BorderFactory.createLineBorder(Color.blue));
					
				}
				public void mouseExited(MouseEvent e)
				{
					user.setBorder(BorderFactory.createLineBorder(Color.black));
					
				}
			});
		
				
			
			
			psw=new JPasswordField(1000);
			psw.addActionListener(this);
			psw.setBorder(BorderFactory.createLineBorder(Color.black));
			psw.addMouseListener(new MouseAdapter(){
				public void mouseEntered(MouseEvent e)
				{
					psw.setBorder(BorderFactory.createLineBorder(Color.blue));
					
				}
				public void mouseClicked(MouseEvent e)
				{
					psw.setBorder(BorderFactory.createLineBorder(Color.red));
					
				}
				public void mouseExited(MouseEvent e)
				{
					psw.setBorder(BorderFactory.createLineBorder(Color.black));
					
				}
			
			});
			
				
		//	user.setBorder(new LineBorder(Color.gray,1));
			user.setFont(new Font("楷体",Font.BOLD,19));
			user.setForeground(Color.black);
		//	psw.setBorder(new LineBorder(Color.gray,1));
			psw.setFont(new Font("楷体",Font.BOLD,9));
			psw.setEchoChar('●');
			psw.setForeground(Color.black);
			psw.setToolTipText("请输入密码");
			user.setToolTipText("请输入用户账号");
			psw.requestFocus(true);
			user.setBounds(140, 197,174, 28);
			psw.setBounds(140, 230, 174, 28);
			
		   
		
			
			 
			
			
		
			
			
		   
		
			
				
						
			    
					
				
						btnCancel=new JButton("取消");
						btnCancel.setForeground(Color.black);
						btnCancel.setContentAreaFilled(false);
						btnCancel.setFont(font);
						btnCancel.addActionListener(this);

						btnCancel.setBounds(233, 265,90, 25);
					
					
						
						btnConfirm=new JButton("确定添加");
						btnConfirm.setForeground(Color.black);
						btnConfirm.setContentAreaFilled(false);
						btnConfirm.setFont(font);

					
						
					    btnConfirm.addActionListener(this);
				     	btnConfirm.setBounds( 140, 265, 90, 25);
						
						
						con.add(user);
						con.add(psw);	
						con.add(btnConfirm);
						con.add(btnCancel);
						
							
		   close=hover_press_utilclass.getbtnClose();
		   close.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					duoyonghu_adding_panel.this.setVisible(false);
				}
			});
		   
		   min=hover_press_utilclass.getbtnMin();
		   min.addActionListener(this);
		
			con.add(close);
			close.setBounds(400, 5, 27, 19);
			con.add(min);
			min.setBounds(375, 5, 27, 17);


	        min.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
			    
					//setVisible(false);
				setExtendedState(JFrame.ICONIFIED);
					
				}
			});
			
			background_utilclass bg=new background_utilclass();// 创建背景面板
			bg.setImage(this.getToolkit().getImage(getClass().getResource("loginbg.png")));// 设置面板背景图片
			bg.setBounds(0,0,437,340);
			con.add(bg);
			this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("title.png")));
			
			
		}
		
		
		   public void do_login()
		   {
			   if(user.getText().length()!=0&&psw.getText().length()!=0)
				{
						FileReader fr;
						try {
							fr = new FileReader("数据库//用户注册数据库.txt");
							BufferedReader in=new BufferedReader(fr);
							
							int x=0;
							for(;in.readLine()!=null;)
								x++;

							fr = new FileReader("数据库//用户注册数据库.txt");
							BufferedReader in2 = new BufferedReader(fr);
							String sth=in2.readLine();
							StringTokenizer st = new StringTokenizer(sth,"|");
							boolean pd=false;
							
							for(int i=1;i<=x;i++)
							{
								if(user.getText().equals(st.nextToken()) && psw.getText().equals(st.nextToken()))
								{
							
							
									this.setVisible(false);//多用户注册面板消失。。。。但是如果不消失，用户再登录则产生bug 需要改进
									
									duoyonghu_logining_thread  ing=new  duoyonghu_logining_thread(duoyonghu_adding_panel.this);
									ing.launch();
									ing.setLocation(duoyonghu_adding_panel.this.getX(),duoyonghu_adding_panel.this.getY());
								    ing.setVisible(true);
								    
								    pd=true;
								    break;
								  
								}
								if(i==x) break;
								st = new StringTokenizer(in2.readLine(),"|");
							}
							if(!pd)
								JOptionPane.showMessageDialog(this, "密码错误或用户不存在！");
						
						} catch (FileNotFoundException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
				}   
					   
						
		 
		   }
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
			 if(e.getSource()==btnConfirm)
			  {
	             //do_login();
	             JOptionPane.showMessageDialog(null,"该功能还存在bug ，我们的团队正在努力为之改善中，时间关系，望见谅"+"\n"+"请点击取消退回登录主面板");
			    	
			  }
			 
			
			
			else if(e.getSource()==btnCancel)
			{

                    duoyonghu_adding_panel.this.setVisible(false);
				
                    duo.setLocation(duoyonghu_adding_panel.this.getX(),duoyonghu_adding_panel.this.getY());
				    duo.setVisible(true);
			   
			}
		
		
		}

		
	}



