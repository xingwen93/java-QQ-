
import java.awt.Font;    


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
public class hover_press_utilclass {
	
	public static JButton getbtnText(String s)
	{
		JButton button=new JButton(s);
		button.setFont(new Font("楷体",Font.BOLD,12));
	    button.setFocusPainted(false);
	    button.setContentAreaFilled(false);
		return button;
		
	}
	
	public static JButton getbtnIcon(String iconpath)
	{
		JButton button=new JButton();
		button.setIcon(new ImageIcon(iconpath));
		button.setBorder(null);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		
		return button;
	}
	
	
	public static JButton getbtnButton(String iconpath,String rolloverIconpath,String pressIconpath)
	{ 
	
		JButton button=new JButton();
		button.setIcon(new ImageIcon(iconpath));
		button.setRolloverIcon(new ImageIcon(rolloverIconpath));
	    button.setPressedIcon(new ImageIcon(pressIconpath));
	    button.setBorder(null);
	    button.setFocusPainted(false);
	    button.setContentAreaFilled(false);
	  
	    return button;	
	
	}
	public static JButton getbtniconpresspress(String Iconpath1,String pressIconpath2,String pressIconpath3)
	{ 
	
		JButton button=new JButton();
		button.setIcon(new ImageIcon(Iconpath1));
		button.setPressedIcon(new ImageIcon(pressIconpath2));
	    button.setPressedIcon(new ImageIcon(pressIconpath3));
	    button.setBorder(null);
	    button.setFocusPainted(false);
	    button.setContentAreaFilled(false);
	  
	    return button;	
	
	}
	public static JButton getbtnMin() {
		
		JButton button=new JButton();
		button.setIcon(new ImageIcon("image/min.png"));
		button.setPressedIcon(new ImageIcon("image/min_press.png"));
		button.setRolloverIcon(new ImageIcon("image/min_hover.png"));
		button.setToolTipText("最小化");
		button.setBorder(null);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		return button;
		
	}
	public static JButton getbtnShezhi() {
		JButton button=new JButton();
		button.setIcon(new ImageIcon("image/shezhi.png"));
		button.setPressedIcon(new ImageIcon("image/shezhi_press.png"));
		button.setRolloverIcon(new ImageIcon("image/shezhi_hover.png"));
		button.setToolTipText("设置");
		button.setBorder(null);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		return button;
	}
	public static JButton getbtnClose()
	{
		JButton btnclose=new JButton();
		btnclose.setIcon(new ImageIcon("image/close.png"));
		btnclose.setRolloverIcon(new ImageIcon("image/close_hover.png"));
		btnclose.setPressedIcon(new ImageIcon("image/close_press.png"));
		btnclose.setBorder(null);
		return btnclose;
	}
	public static JCheckBox getIconCheckBox(String iconPath, String pressIconPath,
			String rolloverIconPath,String selectedIconPath) {
		JCheckBox checkBox = new JCheckBox();
		checkBox.setIcon(new ImageIcon(iconPath));
		checkBox.setPressedIcon(new ImageIcon(pressIconPath));
		checkBox.setRolloverIcon(new ImageIcon(rolloverIconPath));
		checkBox.setSelectedIcon(new ImageIcon(selectedIconPath));
		checkBox.setBorder(null);
		checkBox.setFocusPainted(false);
		checkBox.setContentAreaFilled(false);
		return checkBox;
	}

	

}

