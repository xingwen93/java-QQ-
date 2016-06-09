
 

import java.awt.Container;

import java.awt.Font;

import java.awt.Point;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;




public class duoyonghu_panel extends JFrame implements ActionListener  {

	Point point;// 拖曳窗体之前的鼠标位置；（成员变量）
	
	Login loginframe;
	
	public duoyonghu_panel(Login loginframe)
	{
		this.loginframe=loginframe;
	}
	
	erweima_panel   erweimapanel;
	public duoyonghu_panel(erweima_panel erweima)
	{
		this.erweimapanel=erweima;
	}
    JButton login,close,min,tianjiayonghu;
	
	
	
	JButton erweima,duoyonghu;

	background_utilclass bg;
	Container con=this.getContentPane();
	JLabel threadbg,tip;
	
	duoyonghu_logining_thread duoyonghu_loging_thread;
	public duoyonghu_panel(duoyonghu_logining_thread duoyonghu_loging_thread)
	{
		this.duoyonghu_loging_thread=duoyonghu_loging_thread;
	}
	
	duoyonghu_adding_panel panel;
	public duoyonghu_panel(duoyonghu_adding_panel panel)
	{
		this.panel=panel;
	}
	 int screenwidth,screenheight;
	
	
    public void launch()
//	public duoyonghu_panel()
	 {
		this.setSize(437, 340);
		this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("title.png")));
		
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
  
     	this.setLocationRelativeTo(null);
        this.setLayout(null);
		
		
	
	

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
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
	    
	    
	    
	    
		this.addWindowListener(new WindowAdapter() {
		    
            public void windowActivated(WindowEvent e) {
//				// TODO Auto-generated method stub
         
              loginingbg thread =new loginingbg();
	     		thread.start();
		}
         
		});
	    
	 
		
		
		tianjiayonghu=hover_press_utilclass.getbtnButton("image/tianjiayonghu.png","image/tianjiayonghu_hover.png","image/tianjiayonghu_press.png");
		con.add(tianjiayonghu);
		tianjiayonghu.setBounds( 160,230, 118, 33);
		tianjiayonghu.addActionListener(this);
		
		
		
		
		
		
		threadbg=new JLabel(new ImageIcon(duoyonghu_panel.this.getClass().getResource("login_head_white.png")));
		 threadbg.setBounds(0,205,437,50);
	     con.add(threadbg);
		 con.remove(threadbg);
		 
		
		
		
//	    loginlb=new JLabel("请 您 添 加 ");
//		loginlb.setForeground(Color.white);
//		loginlb.setFont(new Font("宋体",Font.BOLD,19));
//	    login = hover_press_utilclass.getbtnButton(
//						"image/button_blue_hover.png",
//						"image/button_blue_press.png",
//						"image/button_blue_hover.png");
//		
//	  // login.addActionListener(this);
//	    
//	    
	    
//		loginlb.setBounds(190, 292, 250, 40);
//		
//		login.setBounds(105, 288, 237, 48);
//	
		JLabel tip=new JLabel("请 您 添 加 ");
		tip.setFont(new Font("宋体",Font.BOLD,18));
		
		tip.setBounds(165,288,237,48);
		con.add(tip);

		
	     duoyonghu = hover_press_utilclass.getbtnButton(
				"image/duoyonghu.png",
				"image/duoyonghu_hover.png",
				"image/duoyonghu_press.png");
		duoyonghu.setToolTipText("多帐号登录");
		duoyonghu.addActionListener(this);
	
					
		erweima =  hover_press_utilclass.getbtnButton(
							"image/weixin.png",
							"image/weixin_hover.png",
							"image/weixin_press.png");
					erweima.setToolTipText("微信");
		
					con.add(duoyonghu);
					duoyonghu.setBounds(2, 300, 40, 40);
					con.add(erweima);
					erweima.setBounds(396, 300, 40, 40);
					
		erweima.addActionListener(this);			
					
						
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
	
		
		
	
		
     
		
		 bg=new background_utilclass();// 创建背景面板
		bg.setImage(this.getToolkit().getImage(getClass().getResource("loginbg.png")));// 设置面板背景图片
		bg.setBounds(0,0,437,340);
	    
		this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("title.png")));
		
		
	}
	
    class loginingbg extends Thread
	   {
		
			int threadbg_x;
			int threadbg_y;
			
			int i;
			
			public void run()
			{
			
				while (true)
				{
					
				     
					threadbg_x=threadbg.getBounds().x;
					threadbg_y=threadbg.getBounds().y;
			 
				
				
					for( i=threadbg_y;i>=150;i=i-2)
					{
					    	threadbg.setLocation(0, i);
					    
					    
						
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
				
					
						//	System.out.println("dsfdsfdsfd"+headimg_y);System.out.println(headimgbg_y);
						
								return;
							
						}
						
					
						
						
					}
					
					
					
				}
			
			
			
		
	
	

	@Override
	public void actionPerformed(ActionEvent e)  {
		// TODO Auto-generated method stub
		
//		if(e.getSource()==login)
//		{
//		   if(Login.user!=null&&Login.psw!=null)
//		   {
//			  this.setVisible(false);
//			  // System.out.print("DSfdfdfdfdf");
//			   logining_thread t=new  logining_thread(duoyonghu_panel.this);
//			  t.launch();
//				t.setLocation(duoyonghu_panel.this.getX(),duoyonghu_panel.this.getY());
//				t.setVisible(true);
//		   }
//		    
//		   
//		    
//		    
//		
//		}
	    if(e.getSource()==erweima)
		{
			dispose();
		     
			erweima_panel ing=new  erweima_panel(duoyonghu_panel.this);
			ing.launch();
		    ing.setLocation(duoyonghu_panel.this.getX(),duoyonghu_panel.this.getY());
		    ing.setVisible(true);
			
		    
		}
		else if(e.getSource()==duoyonghu)
		{ 
		
			dispose();
//			
           loginframe.setLocation( duoyonghu_panel.this.getX(), duoyonghu_panel.this.getY());
            loginframe.setVisible(true);
		
			
			
		}
		else if(e.getSource()==tianjiayonghu)
		{    

			this.setVisible(false);
			duoyonghu_adding_panel lo=new duoyonghu_adding_panel(duoyonghu_panel.this);
			lo.launch();
			lo.setLocation(duoyonghu_panel.this.getX(),duoyonghu_panel.this.getY());
			lo.setVisible(true);
		}
		
		
	}

	
}

