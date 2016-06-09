


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class  qun_list_panel  extends JPanel implements ActionListener,MouseListener{

	//处理第一张卡片.
	
	JPanel jphy1,jphy2,jphy3;
	JButton jphy_jb1,jphy_jb2;
	JScrollPane jsp1;
	String owner;
	 String qunname;
	//处理第二张卡片(分组).
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
	
	
	
	public  qun_list_panel ()
	{
		
		//处理第一张卡片(显示好友列表)
		jphy_jb1=new JButton("我的群");
		jphy_jb2=new JButton("我的分组");
		jphy_jb2.addActionListener(this);
		
		jphy1=new JPanel(new BorderLayout());
		//假定有50个好友
		jphy2=new JPanel(new GridLayout(10,1,4,4));
		jphy2.setBorder(BorderFactory.createEmptyBorder(2, 10, 6, 5));
	
		
		jb1s =new JLabel[10];
	

		for(int i=0;i<10;i++)
		{
			jb1s[i]=new JLabel("我的QQ群"+(i+1)+"",new ImageIcon("image/qunimg/"+i+".png"),JLabel.LEFT);
			jb1s[i].addMouseListener(this);
			jb1s[i].setFont(new Font("欧体",Font.BOLD,15));
			jphy2.add(jb1s[i]);
			
			
		}
		

		jphy3=new JPanel(new GridLayout(2,1));
		//把两个按钮加入到jphy3
		jphy3.add(jphy_jb2);
        
		
		
		jsp1=new JScrollPane(jphy2);
		
		
		//对jphy1,初始化
		jphy1.add(jphy_jb1,"North");
		jphy1.add(jsp1,"Center");
		jphy1.add(jphy3,"South");
		
		
		//处理第二张卡片
		
		
		jpmsr_jb1=new JButton("我的群");
		jpmsr_jb1.addActionListener(this);
		jpmsr_jb2=new JButton("我的分组");
		
		
		jpmsr1=new JPanel(new BorderLayout());
	
		jpmsr2=new JPanel(new GridLayout(10,1,4,4));
		
	
		JLabel []jb1s2=new JLabel[10];
		
		for(int i=0;i<jb1s2.length;i++)
		{
			jb1s2[i]=new JLabel("我的分组"+(i+1)+"",new ImageIcon("image/qunimg/"+i+".png"),JLabel.LEFT);
			jb1s2[i].addMouseListener(this);
			jb1s2[i].setFont(new Font("欧体",Font.BOLD,15));
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
		
		if(arg0.getClickCount()==2)
		{

			 qunname=((JLabel)arg0.getSource()).getText();
				//System.out.println("你希望和 "+qunname+" 聊天");
				
			new dialog_ql_panel(qunname);
			
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
