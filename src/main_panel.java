

import java.awt.BorderLayout;
import java.awt.Color;   
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;






import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;








public class main_panel  extends JFrame {

 

	
     JLabel headimg,headimgbg;
     static JLabel usernicheng;
     JLabel qianming ;				//个性签名
	 JLabel kongjian ;					//QQ空间图标
	
	JLabel tianqi;					//天气图标

	JButton btnSearch ,huihua,lianxiren,konjian,konjian2, qun,weibo;					//搜索按钮
	JTextField jtfSearch ;				//搜索文本框
	Font font = new Font("微软雅黑", Font.PLAIN, 12);

	String userqianmingqianming;
     static JMenu  MenuStatus;
     JButton btnClose ;					//关闭按钮
	 JButton btnMin ;						//最小化按钮
	 JButton btnSkin ;						//换肤按钮
	
	 JScrollPane js	 =new JScrollPane();//好友列表
	 
	 JScrollPane js2=new JScrollPane();//临时会话列表
	 JScrollPane js3=new JScrollPane();//空间列表
	 JScrollPane js4=new JScrollPane();//微博列表
	 JScrollPane jsqun=new JScrollPane();//微博列表
	 
	 
	 qun_list_panel qunlist=new qun_list_panel();//群
	 
	Container con=this.getContentPane();
	
	
	//外部得到参数
	private long account = 0;								//自己的账号
	private String picturePath;								//自己的头像路径
	private String nicheng;								//自己的呢称
	private String zhuantai;									//自己的状态
	private String gexingqianming;							//自己的个性签名
	private String ip;								//自己的IP地址
	private int port;										//自己的端口号
	private String sex;										//自己的性别
	
	Point point;
	
	 JMenuBar mBar; // 登录状态菜单条
	 JMenu menuStatus;// 登录状态菜单
	 JMenuItem zaixian;
	 JMenuItem yinshen ;
	JMenuItem manglu ;
	 JMenuItem likai ;
   JMenuItem qwo ;
	 JMenuItem wurao ;
	 FriendList qqList;
	
	
	public main_panel(String user)
	{
	 
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

	

			new Thread() {// 创建新线程
	            public void run() {
	            	int screenwidth,screenheight;
	            	Toolkit kit=Toolkit.getDefaultToolkit();
	        		Dimension screensize=kit.getScreenSize();
	            	 screenwidth=(int)screensize.getWidth();
	        		 screenheight=(int)screensize.getHeight();
	                for (int i = 0; i <=674; i += 85) {// 循环拉伸窗体
	                    setBounds( screenwidth/2-284/2, screenheight/2-i/2,284, i);// 不断设置窗体大小与位置
	                    try {
	                        Thread.sleep(5);// 线程休眠10毫秒
	                    } catch (InterruptedException e1) {
	                        e1.printStackTrace();
	                    }
	                }
	            }
	        }.start();// 启动线程
    	       
		
		
	        usernicheng=new JLabel();
	    
            usernicheng.setText(user);
	        usernicheng.setBounds(79,37,80,17);
	        usernicheng.setFont(new Font("微软雅黑", Font.PLAIN, 12));
	        usernicheng.setForeground(Color.BLACK);
	       con.add(usernicheng);
	     	mBar = new JMenuBar(); // 登录状态菜单条
		   menuStatus = new JMenu();// 登录状态菜单
		   zaixian = new JMenuItem();
		   yinshen = new JMenuItem();
		   manglu = new JMenuItem();
		   likai = new JMenuItem();
	       qwo = new JMenuItem();
		   wurao = new JMenuItem();
		
		menuStatus.setIcon(new ImageIcon("image/zaixian.png"));
		menuStatus.setBorder(null);
		menuStatus.setFocusPainted(false);
		menuStatus.setContentAreaFilled(false);
		menuStatus.setName("zaixian");
		mBar.setBorder(null);
		menuStatus.setBorder(null);

		zaixian.setIcon(new ImageIcon("image/zaixian.png"));
		yinshen.setIcon(new ImageIcon("image/yinshen.png"));
		manglu.setIcon(new ImageIcon("image/manglu.png"));
		likai.setIcon(new ImageIcon("image/likai.png"));
		qwo.setIcon(new ImageIcon("image/qwo.png"));
		wurao.setIcon(new ImageIcon("image/wurao.png"));

		zaixian.setText("    我在线上");
		zaixian.setFont(font);
		qwo.setText("    Q我吧");
		qwo.setFont(font);
		likai.setText("    离开");
		likai.setFont(font);
		manglu.setText("    忙碌");
		manglu.setFont(font);
		wurao.setText("    请勿打扰");
		wurao.setFont(font);
		yinshen.setText("    隐身");
		yinshen.setFont(font);

		menuStatus.add(zaixian);
		menuStatus.addSeparator();
		menuStatus.add(qwo);
		menuStatus.add(likai);
		menuStatus.add(manglu);
		menuStatus.add(wurao);
		menuStatus.addSeparator();
		menuStatus.add(yinshen);
		mBar.add(menuStatus);
		mBar.setOpaque(false);// 如果为true，则该组件绘制其边界内的所有像素
		menuStatus.setOpaque(false);

		zaixian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuStatus.setIcon(zaixian.getIcon());
				menuStatus.setName("zaixian");
			}
		});
		yinshen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuStatus.setIcon(yinshen.getIcon());
				menuStatus.setName("yinshen");
			}
		});
		manglu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuStatus.setIcon(manglu.getIcon());
				menuStatus.setName("manglu");
			}
		});
		likai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuStatus.setIcon(likai.getIcon());
				menuStatus.setName("likai");
			}
		});
		qwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuStatus.setIcon(qwo.getIcon());
				menuStatus.setName("qwo");
			}
		});
		wurao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuStatus.setIcon(wurao.getIcon());
				menuStatus.setName("wurao");
			}
		});
		
		
	

		mBar.setBounds(148, 40, 16, 14);
		con.add(mBar);
		mBar.updateUI();
		
		
		
		// 登陆头像及背景
		headimg=new JLabel(new ImageIcon("image/headimg2.jpg"));
		headimgbg=new JLabel(new ImageIcon("image/headimgbg.png"));
		
		con.add(headimg);
	    con.add(headimgbg);
	    
		headimg.setBounds(11, 41, 61, 60);
		headimgbg.setBounds(9, 39,65,65);
	   

		
		headimg.addMouseListener(new MouseAdapter() {

			public void mouseExited(MouseEvent e) {
			
				headimgbg.setBorder(BorderFactory.createLineBorder(new Color(147,112,219),20));
			   
			
			}
			public void mouseEntered(MouseEvent e) {
				
				headimgbg.setBorder(BorderFactory.createLineBorder(new Color(199,21,133 ),20));
				}
		});
	
	
		
		
	    btnClose = hover_press_utilclass.getbtnButton("image/Mainclose.png", 
				"image/Mainclose_hover.png",
				"image/Mainclose_press.png");
		btnMin = hover_press_utilclass.getbtnButton("image/Mainmin.png", 
				"image/Mainmin_hover.png",
				"image/Mainmin_press.png");
		btnSkin = hover_press_utilclass.getbtnButton("image/skin.png", 
				"image/skin_hover.png",
				"image/skin_press.png");
		
		con.add(btnClose);
		btnClose.setBounds(255, -2, 39, 20);
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
			 main_panel.this.dispose();
			 
//			 String exitUser = usernicheng.getText().trim();
//             Vector v = new Vector();
//             v.add("退出：" + exitUser);
//             
//             try {
//                 out.writeObject(v);
//                 out.flush();// 刷新输出缓冲区
//             } catch (IOException ex) {
//                 ex.printStackTrace();
//             }
			}
		});
		
	   
		con.add(btnMin);
		btnMin.setBounds(230, -1, 28, 20);
		btnMin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		    
				//setVisible(false);
			setExtendedState(JFrame.ICONIFIED);
				
			}
		});
		con.add(btnSkin);
		btnSkin.setBounds(204, -2, 28, 20);
		
		
		huihua= hover_press_utilclass.getbtnButton("image/xiang1.png", 
				"image/xiang1_press.png",
				"image/xiang1_press.png");
		lianxiren= hover_press_utilclass.getbtnButton("image/xiang2.png", 
				"image/xiang2_press.png",
				"image/xiang2_press.png");
		konjian= hover_press_utilclass.getbtnButton("image/xiang3.png", 
				"image/xiang3_press.png",
				"image/xiang3_press.png");
		qun= hover_press_utilclass.getbtnButton("image/xiang4.png", 
				"image/xiang4_press.png",
				"image/xiang4_press.png");
		weibo= hover_press_utilclass.getbtnButton("image/xiang5.png", 
				"image/xiang5_press.png",
				"image/xiang5_press.png");
		con.add(huihua);
		huihua.setToolTipText("临时会话");
     	con.add(lianxiren);
     	lianxiren.setToolTipText("联系人");
		con.add(konjian);
		konjian.setToolTipText("空间");
		con.add(qun);
		qun.setToolTipText("群会话");
		con.add(weibo);
		weibo.setToolTipText("微博");
//		//假定有50个好友
//		js.setVisible(false);
	
		
		huihua.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		//		System.out.print("群");
				js.setVisible(false);
				js3.setVisible(false);
				js4.setVisible(false);
			
				js2.setVisible(true);
				con.repaint();
	//			System.out.print("群xxxxxx");
			
				
			}
			
		});
		konjian.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	System.out.print("群");
				js2.setVisible(false);
				js.setVisible(false);
				js4.setVisible(false);
			
				js3.setVisible(true);
				con.repaint();
		//		System.out.print("群xxxxxx");
			
				
			}
			
		});
		weibo.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	System.out.print("群");
				js2.setVisible(false);
				js.setVisible(false);
				js3.setVisible(false);
			
				js4.setVisible(true);
				con.repaint();
	//			System.out.print("群xxxxxx");
			
				
			}
			
		});
		lianxiren.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		//		System.out.print("联系人");
				js2.setVisible(false);
				js4.setVisible(false);
				jsqun.setVisible(false);
				js3.setVisible(false);
				js.setVisible(true);
				
				con.repaint();
				
			}
			
		});
		qun.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		//		System.out.print("群");
				js.setVisible(false);
				js3.setVisible(false);
				js2.setVisible(false);
				js4.setVisible(false);
				jsqun.setVisible(true);
				
				con.repaint();
		//		System.out.print("群xxxxxx");
			
				
			}
			
		});
		huihua.setBounds(14,141,34,40);
		lianxiren.setBounds(72,139,34,40);
		konjian.setBounds(129,135,34,46);
		qun.setBounds(178,141,34,40);
		weibo.setBounds(230,142,34,40);
		
		
		jtfSearch = new JTextField("搜索:联系人、讨论组、群、企业");
		jtfSearch.setBorder(null);
		jtfSearch.setFont(new Font("楷体",Font.PLAIN,14));
		jtfSearch.setForeground(Color.darkGray);
		jtfSearch.setBackground(new Color(248,248,255 ) );
		
		jtfSearch.addMouseListener(new MouseAdapter() {

			
			public void mouseEntered(MouseEvent e) {
				
				jtfSearch.setBackground(Color.white);
				}
		});
		btnSearch = hover_press_utilclass.getbtnButton(
				"image/search.png",
				"image/search_hover.png",
				"image/search_press.png");

//		sousuoguanbi = hover_press_utilclass.getbtnButton(
//				"image/sousuoguanbi_press.png",
//				"image/sousuoguanbi_hover.png",
//				"image/sousuoguanbi_press.png");
		//给搜索文本框添加鼠标监听
		jtfSearch.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				jtfSearch.setText("");
				
				
				
			 //   jtfSearch.setBackground(Color.white);
			   
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnSearch.updateUI();
				
			 //   jtfSearch.setBackground(Color.white);
			   
			}
		});
			
		jtfSearch.addKeyListener(new KeyAdapter(){

			@Override
			public void keyReleased(KeyEvent e){
				
			
				
		
				
			}
		});
		
		con.add(btnSearch);
		btnSearch.setBounds(250, 111, 22, 25);
		btnSearch.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
		
			}
			
		});
	
			con.add(jtfSearch);
		jtfSearch.setBounds(1, 108, 282, 33);	
		
		
		
		userqianmingqianming="我爱你，你爱我吗?";
		
		qianming = new JLabel(userqianmingqianming);	 // 个性签名
		qianming.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		qianming.setForeground(Color.BLACK);
		con.add(qianming);
	     qianming.setBounds(76, 54, 200, 20);	
	     
	 	//konjian2 = new JLabel(new ImageIcon("image/konjian.png"));// QQ空间
	 	
		tianqi = new JLabel(new ImageIcon("image/tianqi.png"));
	        // con.add(konjian2);
		//	konjian2.setBounds(74, 74, 12, 12);
			con.add(tianqi );
			tianqi.setBounds(220, 30, 60, 50);
	     
//		 con.add(sousuoguanbi);
//			sousuoguanbi.setBounds(250, 110, 27, 24);
//		
//	   sousuoguanbi.updateUI(); 
//	
		
//	  
	     
		
			js.setBorder(null);
			
			
			js.setBounds(2,182 , 278, 430);
			js.setVisible(true);
			
			con.add(js);
		   
            js2.setBorder(null);
			js2.setBounds(2,182 , 278, 430);
			//js2.add(new JLabel("dfdfdflkdjflkdjkfldlkfjldkjfldjlfdjfdf"));
			js2.setViewportView(new JLabel("               临时会话面板尚未完成,敬请期待"));
			con.add(js2);
			//js2.setVisible(false);
			js3.setBorder(null);
			js3.setBounds(2,182 , 278, 430);
			//js2.add(new JLabel("dfdfdflkdjflkdjkfldlkfjldkjfldjlfdjfdf"));
			js3.setViewportView(new JLabel("               空间会话面板尚未完成,敬请期待"));
			con.add(js3);
			js4.setBorder(null);
			js4.setBounds(2,182 , 278, 430);
			//js2.add(new JLabel("dfdfdflkdjflkdjkfldlkfjldkjfldjlfdjfdf"));
			js4.setViewportView(new JLabel("               微博会话面板尚未完成,敬请期待"));
			con.add(js4);
			jsqun.setBorder(null);
			jsqun.setBounds(2,182 , 278, 430);
			//js2.add(new JLabel("dfdfdflkdjflkdjkfldlkfjldkjfldjlfdjfdf"));
			jsqun.setViewportView(qunlist);
			con.add(jsqun);
	    	  ClientUser qqClientUser=new ClientUser();
				User u=new User();
				u.setUserId(Login.user.getText().trim());
				u.setPasswd(new String(Login.psw.getPassword()));
				
				
				if(qqClientUser.checkUser(u))
				{
					try {
						//把创建好友列表的语句提前.
						
						 qqList=new FriendList(u.getUserId());
						 js.add(qqList);
						 js.setViewportView(qqList);
						
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
	     
	     
	     
	
	    
		    System.out.println("1");
//	    
////		
//		  tree = new JTree();
//		  tree.setFont(new Font("微软雅黑", Font.PLAIN, 16));
//          tree.addTreeSelectionListener(new TreeSelectionListener() {
//            public void valueChanged(TreeSelectionEvent e) {
//                do_tree_valueChanged(e);
//            }
//        });
//        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
//      //  js.setViewportView(tree);
//////    
//        DefaultMutableTreeNode root = new DefaultMutableTreeNode("好友列表");
//        DefaultMutableTreeNode parent1 = new DefaultMutableTreeNode("我的好友");
//////     
//////        
//        parent1.add(new DefaultMutableTreeNode("马化腾"));
//        parent1.add(new DefaultMutableTreeNode("系统客服"));
//
////        
////        
////        
////        
//////        
//        root.add(parent1);
//        DefaultMutableTreeNode parent2 = new DefaultMutableTreeNode("我的陌生人");
//        parent2.add(new DefaultMutableTreeNode("陌生人1"));
//        parent2.add(new DefaultMutableTreeNode("陌生人2"));
//      
//        root.add(parent2);
//        DefaultTreeModel model = new DefaultTreeModel(root);
//        tree.setModel(model);
////////    
//        js.setViewportView(tree);
//////       
		
		
		background_utilclass bg=new background_utilclass();// 创建背景面板
		bg.setImage(this.getToolkit().getImage(getClass().getResource("mainbg.png")));// 设置面板背景图片
		bg.setBounds(0,0,284,674);
		con.add(bg);
		
		this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("title.png")));

		this.setSize(284,674);
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		

	    this.setLocationRelativeTo(null);
    
//	    this.addWindowListener(new WindowAdapter()
//	    {
//	    	public void windowClosing(WindowEvent e)
//	    	{
//	    		
//	    		
//	    	}
//	    	  
//	    });
	}

	
	

	

	public JMenu getMenuStatus() {
		return menuStatus;
	}
	
	public long getAccount() {
		return account;
	}

	
	public String getnicheng() {
		return nicheng;
	}

	public void setnicheng(String nicheng) {
		this.nicheng = nicheng;
	}

	public String getgexingqianming() {
		return gexingqianming;
	}

	public void setgexingqianming(String gexingqianming) {
		this.gexingqianming = gexingqianming;
	}

	
	public String getIpAddress() {
		return ip;
	}

	public void setIpAddress(String ipAddress) {
		this.ip = ipAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}


	public String getuserqianmingqianming() {
		return userqianmingqianming;
	}

	public void userqianmingqianming(String  userqianmingqianming) {
		this.userqianmingqianming = userqianmingqianming;
	}



	public JLabel getLblHead() {
		return headimg;
	}

	public void setLblHead(JLabel lblHead) {
		this.headimg = lblHead;
	}

	public JLabel getLblgexingqianming() {
		return qianming;
	}

	public void setLblgexingqianming(JLabel lblgexingqianming) {
		this.qianming = lblgexingqianming;
	}

	public JLabel getLblUserName() {
		return usernicheng;
	}

	public void setLblUserName(JLabel lblUserName) {
		this.usernicheng = lblUserName;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	
	

//	public  void do_tree_valueChanged(TreeSelectionEvent e) {
//        TreePath path = tree.getSelectionPath();
//        if(path==null) {
//            return;
//        }
//        DefaultMutableTreeNode node = (DefaultMutableTreeNode)path.getLastPathComponent();
//          if (!(node.toString().equals("好友列表")||node.toString().equals("我的好友")||node.toString().equals("我的陌生人")))
//          {
//        	  new dialog_panel(node.toString(),"个性签名");// 调用方法创建套接字对象;//main_panel.this.MenuStatus 有错误，需要改进
//        	  
//          }
//         
//        
//    }
//	

	


//	public static void main(String args[])
//
//	{
//		new main_panel();
//	}
//	
}
