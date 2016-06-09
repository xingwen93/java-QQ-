

   
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


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;




public class erweima_panel extends JFrame implements ActionListener{
	
	Login login;
	public erweima_panel(Login er)
	{
		this.login=er;
	}
	
	
	private JButton close,min;
	
	private JLabel erweimabg1,erweimabg2;
    Point point;
    JButton erweima;
    background_utilclass bg;
	boolean flag;
	Font font = new Font("微软雅黑", Font.PLAIN, 12);
	
	Container con=this.getContentPane();
	
   
	 int screenwidth,screenheight;
	
	
	
    	duoyonghu_panel duo;
	public erweima_panel(duoyonghu_panel duo)
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
		
		
		
         
//			@Override
//			public void windowActivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//
//				new Thread() {// 创建新线程
//    	            public void run() {
//    	               
//    	                for (int i = 0; i <=340; i += 85) {// 循环拉伸窗体
//    	                    setBounds( screenwidth/2-437/2, screenheight/2-i/2,437, i);// 不断设置窗体大小与位置
//    	                    try {
//    	                        Thread.sleep(5);// 线程休眠10毫秒
//    	                    } catch (InterruptedException e1) {
//    	                        e1.printStackTrace();
//    	                    }
//    	                }
//    	            }
//    	        }.start();// 启动线程
//	    	       
//			}
          
		
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
	    
	    
	    
	
	
		this.setLayout(null);
		erweimabg1=new JLabel(new ImageIcon("image/erweimabg1.png"));
		erweimabg1.setBounds(155,150, 129,123);
		
	
		
		erweimabg1.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				 yidong thread =new yidong();
		     		
				 thread.start(); 
		     		
		     		if(flag)
			 		{
			 			yidong2 thread2 =new yidong2();
			     		thread2.start();
			 		}
			}
			
			
		});
			
		
	
		con.add(erweimabg1);
        
		
		erweimabg2=new JLabel(new ImageIcon("image/erweimabg2.png"));
	
		
		
		
				
		
		
		
		
		
//		 duoyonghu = hover_press_utilclass.getbtnButton(
//					"image/duoyonghu.png",
//					"image/duoyonghu_hover.png",
//					"image/duoyonghu_press.png");
//			duoyonghu.setToolTipText("多帐号登录");
//			duoyonghu.addActionListener(this);
		
						
			erweima =  hover_press_utilclass.getbtnButton(
								"image/weixin.png",
								"image/weixin_hover.png",
								"image/weixin_press.png");
						erweima.setToolTipText("微信");
			
//						con.add(duoyonghu);
//						duoyonghu.setBounds(2, 300, 40, 40);
						con.add(erweima);
						erweima.setBounds(396, 296, 40, 40);
						
			erweima.addActionListener(this);			
						
		
	
	   close=hover_press_utilclass.getbtnClose();
	   close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {


				erweima_panel
				.this.setVisible(false);
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
		bg.setImage(this.getToolkit().getImage(getClass().getResource("shezhibg2.png")));// 设置面板背景图片
		bg.setBounds(0,0,437,340);
		con.add(bg);
		this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("title.png")));
		
		
	}
	
	 class yidong extends Thread
	   {
		   int pic_x ;// 定义图片移动位置的x坐标
	        int pic_y;// 定义图片移动位置的y坐标
	       
			
			int i,j;
			
			public void run()
			{
			
				while (true)
				{
					
				     
					pic_x=erweimabg1.getBounds().x;
					pic_y=erweimabg1.getBounds().y;
		
					for( i=pic_x,j=pic_y;i>=89;i=i-6)
					{
					    	
							
					
							erweimabg1.setLocation(i, j);
							con.add(erweimabg1);
							
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

	                      //    System.out.println(i);
	                          if(pic_x<=89)
	  						{
	  									
	  							 return;	
	  								    
	  				     	}	
	  					     
					    } 
					  
				
					erweimabg2.setBounds(220,100, 178,182);
			     	con.add(erweimabg2);
	  				con.repaint(); 
	  		//		System.out.print(pic_x);
					flag=true;	
					
						
					
					}
					
					
				}
			}
			
	 class yidong2 extends Thread
	   {
		   int pic2_x ;// 定义图片移动位置的x坐标
	        int pic2_y;// 定义图片移动位置的y坐标
	       
	   
		 
			
			int i,j;
			
			public void run()
			{     
				JLabel  erweimabg1_2=new JLabel(new ImageIcon("image/erweimabg1.png"));
			    erweimabg1_2.setBounds(89,150, 129,123);
			
				while (true)
				{
					
					
					pic2_x=erweimabg1_2.getBounds().x;
					pic2_y=erweimabg1_2.getBounds().y;
		
					for( i=pic2_x,j=pic2_y;i<=155;i=i+6)
					{
					    	
							
					
						    erweimabg1.setVisible(false);
						    erweimabg2.setVisible(false);
						    
							erweimabg1_2.setLocation(i, j);
							con.add(erweimabg1_2);
							
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

	                      //    System.out.println(i);
	                          if(pic2_x>=155)
	  						{
	  									
	  							 return;	
	  								    
	  				     	}	
	  					     
					    } 
					  
				
						
					
						
						
					}
					
					
				}
			}
			
	 
	 
	 
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
//		
//	 if(e.getSource()==duoyonghu)
//		{ 
//		
//			dispose();
//			
//			duoyonghu_panel lo=new duoyonghu_panel(erweima_panel.this);
//			lo.launch();
//			lo.setLocation(erweima_panel.this.getX(),erweima_panel.this.getY());
//			lo.setVisible(true);
//         
//			
//			
//		}
		 if(e.getSource()==erweima)
		{    

			dispose();
			
			login.setLocation(erweima_panel.this.getX(),erweima_panel.this.getY());
		     login.setVisible(true);
	       
	
		}
	
	}

	
}



