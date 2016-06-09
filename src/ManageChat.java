/**
 * 这是一个管理用户聊天界面的类
 */

import java.util.*;

public class ManageChat {

	private static HashMap hm=new HashMap<String, dialog_panel>();
	
	//加入
	public static void addQqChat(String loginIdAnFriendId,dialog_panel dialog)
	{
		hm.put(loginIdAnFriendId, dialog);
	}
	//取出
	public static dialog_panel getQqChat(String loginIdAnFriendId )
	{
		return (dialog_panel)hm.get(loginIdAnFriendId);
	}
	
}
