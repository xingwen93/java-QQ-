




	import java.awt.Color ;    
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

	import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


     public class duoyonghu_logining_thread  extends JFrame implements ActionListener{

    	 Point point;
	//	Login loginframe;
		static boolean yanzheng;
		
		duoyonghu_adding_panel panel;
		public duoyonghu_logining_thread(duoyonghu_adding_panel panel)
		{
			this.panel=panel;
		}
//		public duoyonghu_logining_thread(Login panel)
//		{
//			this.loginframe=panel;
//		}
		
		private JButton login,close,min;
		
		
		
		


		Container con=this.getContentPane();
		JLabel threadbg,headimg,headimgbg, loginlb;
		background_utilclass bg;
		 int screenwidth,screenheight;
		
		
		public void launch()
		{
			this.setSize(437, 340);
			this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("title.png")));
			
			this.setUndecorated(true);
			this.setAlwaysOnTop(true);
	  
	     	this.setLocationRelativeTo(null);
	        this.setLayout(null);
//	        timer t=new  timer();
//	        t.start();
//			
		
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

			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			this.addWindowListener(new WindowAdapter() {
	    
	            public void windowActivated(WindowEvent e) {
//					// TODO Auto-generated method stub
	         
	              loginingbg thread =new loginingbg();
		     		thread.start();
			}
	         
			});
			
			
	
			
			headimg=new JLabel(new ImageIcon( duoyonghu_logining_thread.this.getClass().getResource("headimg.png")));
			headimgbg=new JLabel(new ImageIcon( duoyonghu_logining_thread.this.getClass().getResource("headimgbg.png")));
			headimg.setBounds( 80,202, 80, 79);
			headimgbg.setBounds(78, 200, 84,84);
			
			
			
			
			
			threadbg=new JLabel(new ImageIcon( duoyonghu_logining_thread.this.getClass().getResource("login_head_white.png")));
			 threadbg.setBounds(0,205,437,40);
		//	 con.add(threadbg);
			// con.remove(threadbg);]
			 
			
			
			
		    loginlb=new JLabel("取 消 登 录");
			loginlb.setForeground(Color.white);
			loginlb.setFont(new Font("宋体",Font.BOLD,19));
		    login = hover_press_utilclass.getbtnButton(
							"image/button_blue_normal.png",
							"image/button_blue_press.png",
							"image/button_blue_hover.png");
			
		    login.addActionListener(this);
		    
		    
			loginlb.setBounds(165, 292, 250, 40);
			
			login.setBounds(105, 288, 237, 48);
		
			
		 
							
		   close=hover_press_utilclass.getbtnClose();
		   close.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
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
			
			
		
		//	bg=new JLabel(new ImageIcon( logining_thread.this.getClass().getResource("loginbg.png")));
			//bg.setBounds(0,0,437,340);
		//	con.add(bg);
			 bg=new background_utilclass();// 创建背景面板
			bg.setImage(this.getToolkit().getImage(getClass().getResource("loginbg.png")));// 设置面板背景图片
			bg.setBounds(0,0,437,340);
			this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("title.png")));
			
			
		}
		
		
		
		   class loginingbg extends Thread
		   {
			   int login_x ;// 定义图片移动位置的x坐标
		        int login_y;// 定义图片移动位置的y坐标
		        int loginlb_x;
		        int loginlb_y;
		        
				int headimg_x;
				int headimgbg_x;
				int headimg_y;
				int headimgbg_y;
				int threadbg_x;
				int threadbg_y;
				
				int i,j,k,o,p;
				
				public void run()
				{
				
					while (true)
					{
						
					     
						threadbg_x=threadbg.getBounds().x;
						threadbg_y=threadbg.getBounds().y;
				 
						headimg_x=headimg.getBounds().x;
						headimg_y=headimg.getBounds().y;
						
						headimgbg_x=headimg.getBounds().x;
						headimgbg_y=headimg.getBounds().y;
						
					    loginlb_x=loginlb.getBounds().x;
					    
				         loginlb_y=loginlb.getBounds().y+3;
						
				         login_x=login.getBounds().x;
						    //,       ,k++,o--   &&loginlb_x==152&&login_x==90
				         login_y=login.getBounds().y+3;
				         
						for( i=threadbg_y,j=headimg_x,k=headimgbg_x,o=loginlb_y,p=login_y;i>=171&&j<=198&&k<=177 &&o>=120&&p>=168 ;i=i-1,j=j+3,k=k+3,o=o-1,p=p-1)
						{
						    	threadbg.setLocation(0, i);
						    	headimg.setLocation(j, 202);
						    	headimgbg.setLocation(k,200 );
						     	loginlb.setLocation(165,o);
						     	login.setLocation(105,p );
						    	
						     	con.add(loginlb);
								con.add(login);
								con.add(headimg);
								con.add(headimgbg);
								
								con.add(threadbg);
								
						
								
								con.add(bg);
								
							    con.repaint();
						//		System.out.println(threadbg_y);
								try
								{
									Thread.sleep(6);
								}
								catch(InterruptedException e)
								{
									e.printStackTrace();
								}


						    }
					
						if(threadbg_y==173)
						{
							
					//		System.out.print("stop");
							while(true)
							{
								for(int y=headimg_y,y_bg=headimgbg_y;y>=170&&y_bg>=174;y--,y_bg--)
							    {
								headimg.setLocation(j, y);
								headimgbg.setLocation(y_bg, y);
								
								con.repaint();
								
								try{
									this.sleep(30);
								}
								catch(InterruptedException  e)
								{
									e.printStackTrace();
								}
							    }
								
							//	System.out.println("dsfdsfdsfd"+headimg_y);System.out.println(headimgbg_y);
							
 
								yanzheng=true;
								System.out.print("来了");
								duoyonghu_logining_thread.this.setVisible(false);
								
//								loginframe.setLocation(duoyonghu_logining_thread.this.getX(),duoyonghu_logining_thread.this.getY());
//							    loginframe.setVisible(true);
								
							    dispose();
							    
								
						
//								main_panel m=new main_panel(duoyonghu_adding_panel.user.getText());
//								
//							   
//								m.setVisible(true);
								
								
								
									return;
								
							}
							
						
							
							
						}
						
						link_tip_panel link=new link_tip_panel();
						link.setBounds(105, 307, 300,100);
						con.add(link);
						
						con.repaint();
						
					}
				}
				
				
			}
		

		   class link_tip_panel extends JPanel{
			   public void paint(Graphics g)
			   {
				   Color color=Color.darkGray;
				   g.setColor(color);
				   g.setFont(new Font("楷体",Font.BOLD,14));
				   g.drawString("正在连接服务器，请稍后.....",20, 20);
				   
			   }
		   }
		   
							
	  
		
		   
		   
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==login)
			{
				
				
				
			      panel.setVisible(true);
			      panel.setLocation(duoyonghu_logining_thread.this.getX(),duoyonghu_logining_thread.this.getY());
				
				  
			
			}
			
			
			
			
		}

		
	}



