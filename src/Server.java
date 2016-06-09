



/**
 * 服务器，监听，等待某个qq客户端，来连接 
 */


import java.net.*;  
import java.io.*;
import java.util.*;





public class Server {
	
	
	

	ServerSocket ss;
	public static void main (String args[])
	{
		new Server();
	    
		
	}
	
	public Server()
	{
		
		try {
			
			
			System.out.println("私聊服务器成功,在等着任意一个客户端,请先确定qunliao_Server是否运行了?");
			
		    ss=new ServerSocket(99);
			
			//阻塞,等待连接
			while(true)
			{
				Socket s=ss.accept();
				
				//接收客户端发来的信息.
				
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User u=(User)ois.readObject();
				System.out.println("服务器接收到用户id:"+u.getUserId()+"  密码:"+u.getPasswd());
				Message m=new Message();
			
				
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			
				if(s!=null)
				{
					
						System.out.println("成功登录主面板");
					
				
					//返回一个成功登陆的信息报
					
				
					m.setMesType("1");
					oos.writeObject(m);
					
					//这里就单开一个线程，让该线程与该客户端保持通讯.
					SerConClientThread scct=new SerConClientThread(s);
					ManageClientThread.addClientThread(u.getUserId(), scct);
					//启动与该客户端通信的线程.
					scct.start();
			
					//并通知其它在线用户.
					scct.notifyOther(u.getUserId());
					
					
				}
				
				
                
				  
				 
				
//					System.out.print("aaaaa");
//					m.setMesType("2");
//					oos.writeObject(m);
//					//关闭Socket
//					s.close();
//				
					
				
				
				
			}	
			
			
		} catch (BindException e) {
			System.out.println("端口使用中....");
			System.out.println("请关掉相关程序并重新运行服务器！");
			System.exit(0);
		} catch (IOException e) {
			System.out.print(0);
		}catch (Exception e) {
			System.exit(0);
			// TODO: handle exception
		}finally{
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.exit(0);
			}
		}
		
	}
	
	
}
     
   //这是用户信息类
 class User implements java.io.Serializable {

	private String userId;
	private String passwd;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
    
 
 class Message implements java.io.Serializable{

		private String mesType;
		
		private String sender;
		private String getter;
		private String con;
		private String sendTime;

		public String getSender() {
			return sender;
		}

		public void setSender(String sender) {
			this.sender = sender;
		}

		public String getGetter() {
			return getter;
		}

		public void setGetter(String getter) {
			this.getter = getter;
		}

		public String getCon() {
			return con;
		}

		public void setCon(String con) {
			this.con = con;
		}

		public String getSendTime() {
			return sendTime;
		}

		public void setSendTime(String sendTime) {
			this.sendTime = sendTime;
		}

		public String getMesType() {
			return mesType;
		}

		public void setMesType(String mesType) {
			this.mesType = mesType;
		}
	}
 
        
 /**
  * 服务器和某个客户端的通信线程 
  */
  class SerConClientThread  extends Thread{

	Socket s;
	
	public SerConClientThread(Socket s)
	{
		//把服务器和该客户端的连接赋给s
		this.s=s;
	}
	
	//让该线程去通知其它用户
	public void notifyOther(String iam)
	{
		//得到所有在线的人的线程
		HashMap hm=ManageClientThread.hm;
		Iterator it=hm.keySet().iterator();
		
		while(it.hasNext())
		{
			Message m=new Message();
			m.setCon(iam);
			m.setMesType(MessageType.message_ret_onLineFriend);
			//取出在线人的id
			String onLineUserId=it.next().toString();
			System.out.println(onLineUserId);
			try {
				ObjectOutputStream oos=new ObjectOutputStream(ManageClientThread.getClientThread(onLineUserId).s.getOutputStream());
				m.setGetter(onLineUserId);
				oos.writeObject(m);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
		}
	}
	
	public void run()
	{
		
		while(true)
		{
			
			//这里该线程就可以接收客户端的信息.
			try {
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
				
			//	System.out.println(m.getSender()+" 给 "+m.getGetter()+" 说:"+m.getCon());
				
				//对从客户端取得的消息进行类型判断，然后做相应的处理
				if(m.getMesType().equals(MessageType.message_comm_mes))
				{
					//一会完成转发.
					//取得接收人的通信线程
					SerConClientThread sc=ManageClientThread.getClientThread(m.getGetter());
					ObjectOutputStream oos=new ObjectOutputStream(sc.s.getOutputStream());
					oos.writeObject(m);
				}else if(m.getMesType().equals(MessageType.message_get_onLineFriend))
				{
					
					System.out.println(m.getSender()+" 要他的好友");
					//把在服务器的好友给该客户端返回.
					String res=ManageClientThread.getAllOnLineUserid();
					Message m2=new Message();
					m2.setMesType(MessageType.message_ret_onLineFriend);
					m2.setCon(res);
					m2.setGetter(m.getSender());
					ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(m2);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			
			
		}
		
		
	}
}
  /**
   * 定义包的种类*/
       interface MessageType {

		String message_succeed="1";//表明是登陆成功
		String message_login_fail="2";//表明登录失败
		String message_comm_mes="3";//普通信息包
		String message_get_onLineFriend="4";//要求在线好友的包
		String message_ret_onLineFriend="5";//返回在线好友的包
	}

  class ManageClientThread {

		public static HashMap hm=new HashMap<String, SerConClientThread>();
		
		//向hm中添加一个客户端通讯线程
		public static  void addClientThread(String uid,SerConClientThread ct)
		{
			hm.put(uid, ct);
		}
		
		public static SerConClientThread getClientThread(String uid)
		{
			return (SerConClientThread)hm.get(uid);
		}
		
		//返回当前在线的人的情况
		public static String getAllOnLineUserid()
		{
			//使用迭代器完成
			Iterator it=hm.keySet().iterator();
			String res="";
			while(it.hasNext())
			{
				res+=it.next().toString()+" ";
			}
			return res;
		}
	}

  
  

