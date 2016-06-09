

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class FriendList extends JPanel implements ActionListener,MouseListener{

	//处理第一张卡片.
	
	JPanel jphy1,jphy2,jphy3;
	JButton jphy_jb1,jphy_jb2;
	JScrollPane jsp1;
	String owner;
	static String friendNo;
	//处理第二张卡片(陌生人).
	int counter_user;
	JPanel jpmsr1,jpmsr2,jpmsr3;
	JButton jpmsr_jb1,jpmsr_jb2;
	JScrollPane jsp2;
	JLabel []jb1s;
	//把整个JFrame设置成CardLayout
	CardLayout cl;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//	//	QqFriendList qqFriendList=new QqFriendList();
//	}
	
	//更新在线的好友情况
	public void upateFriend(Message m)
	{
		String onLineFriend[]=m.getCon().split(" ");
		
		for(int i=0;i<onLineFriend.length;i++)
		{
			
			jb1s[Integer.parseInt(onLineFriend[i])-10001].setEnabled(true);
		}

	}
	
	public  FriendList(String ownerId)
	{
		this.owner=ownerId;
		//处理第一张卡片(显示好友列表)
		jphy_jb1=new JButton("我的好友");
		jphy_jb2=new JButton("陌生人");
		jphy_jb2.addActionListener(this);
		
		jphy1=new JPanel(new BorderLayout());
		//假定有50个好友
		jphy2=new JPanel(new GridLayout(50,1,4,4));
		jphy2.setBorder(BorderFactory.createEmptyBorder(2, 10, 6, 5));
		//给jphy2，初始化20好友.
		jb1s =new JLabel[50];
	

		for(int i=0;i<50;i++)
		{
			jb1s[i]=new JLabel(i+10001+"",new ImageIcon("image/headimg/"+i+".png"),JLabel.LEFT);
			jb1s[i].setEnabled(false);
			if(jb1s[i].getText().equals(ownerId))
			{
				jb1s[i].setEnabled(true);
			}
			jb1s[i].addMouseListener(this);
			jb1s[i].setFont(new Font("欧体",Font.PLAIN,15));
			jphy2.add(jb1s[i]);
			
			
		}
		

		  //暂时先将注册的用户当做同个用户的好友数据库
		//读取用户名
//		FileReader fr;
//		boolean pd=true;
//		
//		try {
//				fr = new FileReader("数据库//用户注册数据库.txt");
//				BufferedReader in=new BufferedReader(fr);
//				
//				int x=0;
//				for(;in.readLine()!=null;)
//					x++;
//
//				counter_user=x;
//				fr = new FileReader("数据库//用户注册数据库.txt");
//				BufferedReader in2 = new BufferedReader(fr);
//				String sth=in2.readLine();
//				StringTokenizer st = new StringTokenizer(sth,"|");
//				
//				String yhm;
//			String suzu[]=new String[x];
//				for(int i=1;i<=x;i++)
//				{
//					yhm=st.nextToken();
//					
//
//					suzu[i-1]=yhm;
//				//	System.out.println("ren"+yhm);
//					
//					if(i==x) break;
//					st = new StringTokenizer(in2.readLine(),"|");
//					
//				}
//				
//				for(int i=0;i<counter_user;i++)
//			    {
//					jb1s[i]=new JLabel(suzu[i]+" ",new ImageIcon("image/headimg/"+i+".png"),JLabel.LEFT);
//					jb1s[i].setEnabled(false);
//					if(jb1s[i].getText().equals(ownerId))
//					{
//						jb1s[i].setEnabled(true);
//					}
//					jb1s[i].addMouseListener(this);
//					jphy2.add(jb1s[i]);
//			     }
//			} catch (FileNotFoundException e3) {
//				// TODO 自动生成的 catch 块
//				e3.printStackTrace();
//			} catch (IOException e1) {
//				// TODO 自动生成的 catch 块
//				e1.printStackTrace();
//			}
			
		
		
	
//		
		
		jphy3=new JPanel(new GridLayout(2,1));
		//把两个按钮加入到jphy3
		jphy3.add(jphy_jb2);
        
		
		
		jsp1=new JScrollPane(jphy2);
		
		
		//对jphy1,初始化
		jphy1.add(jphy_jb1,"North");
		jphy1.add(jsp1,"Center");
		jphy1.add(jphy3,"South");
		
		
		//处理第二张卡片
		
		
		jpmsr_jb1=new JButton("我的好友");
		jpmsr_jb1.addActionListener(this);
		jpmsr_jb2=new JButton("陌生人");
		
		
		jpmsr1=new JPanel(new BorderLayout());
		//假定有40个陌生人
		jpmsr2=new JPanel(new GridLayout(50,1,4,4));
		
		//给jphy2，初始化50陌生人.
		JLabel []jb1s2=new JLabel[50];
		
		for(int i=0;i<jb1s2.length;i++)
		{
			if(i==0)
				jb1s2[i]=new JLabel("      美女"+"  ",new ImageIcon("image/headimg/"+i+".png"),JLabel.LEFT);
			else if(i==1)
				jb1s2[i]=new JLabel("      野猫人"+"  ",new ImageIcon("image/headimg/"+i+".png"),JLabel.LEFT);
		    else
			{
				
				jb1s2[i]=new JLabel("      屌 丝"+" "+i+"号  ",new ImageIcon("image/headimg/"+i+".png"),JLabel.LEFT);
				jb1s2[i].setFont(new Font("欧体",Font.BOLD,15));

			}
			jpmsr2.add(jb1s2[i]);
		}
		
		jpmsr3=new JPanel(new GridLayout(2,1));
		//把两个按钮加入到jphy3
		jpmsr3.add(jpmsr_jb1);
		jpmsr3.add(jpmsr_jb2);
		
		
		jsp2=new JScrollPane(jpmsr2);
		jsp2.setBorder(BorderFactory.createEmptyBorder(2, 10, 6, 5));
		
		//对jphy1,初始化
		jpmsr1.add(jpmsr3,"North");
		jpmsr1.add(jsp2,"Center");

		
		
		cl=new CardLayout();
		this.setLayout(cl);
		this.add(jphy1,"1");
		this.add(jpmsr1,"2");
		//在窗口显示自己的编号.
	
		this.setSize(140, 400);
		this.setVisible(true);
		
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//如果点击了陌生人按钮，就显示第二张卡片
		if(arg0.getSource()==jphy_jb2)
		{
			cl.show(this, "2");
		}else if(arg0.getSource()==jpmsr_jb1){
			cl.show(this,"1");
		}
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//响应用户双击的事件，并得到好友的编号.
		if(arg0.getClickCount()==2)
		{
			//得到该好友的编号
			 friendNo=((JLabel)arg0.getSource()).getText();
			//System.out.println("你希望和 "+friendNo+" 聊天");
			dialog_panel dialog=new dialog_panel(this.owner,friendNo);
			System.out.print(arg0.getSource().toString());
			
			
			
			//把聊天界面加入到管理类
			ManageChat.addQqChat(this.owner+" "+friendNo, dialog);
			
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)arg0.getSource();
		jl.setBackground(Color.red);
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)arg0.getSource();
		jl.setForeground(Color.black);
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
