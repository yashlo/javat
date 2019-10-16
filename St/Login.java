
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author yash
 */
public class Login implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3;
	JTextField tf1;
	JButton btn1;
	JPasswordField p1;
	Login()
	{
		f=new JFrame(" stock management system");
		f.setVisible(true);
		f.setSize(800,800);
		l1=new JLabel("Stock management system");
		l2 = new JLabel("Enter the User ID");
		l3 = new JLabel("Enter the Password");
		tf1 = new JTextField();
		p1 = new JPasswordField();
		btn1 = new JButton("Submit");
		l1.setBounds(100,30,400,30);
		l2.setBounds(80,70,200,30);
		l3.setBounds(80,110,200,30);
		tf1.setBounds(300,70,200,30);
		p1.setBounds(300,110,200,30);
		btn1.setBounds(150,160,100,30);
		f.add(l1);
		f.add(l2);
		f.add(tf1);
		f.add(l3);
		f.add(p1);
		f.add(btn1);
		f.setLayout(null);
		btn1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		showData();
	}
	public void showData()
	{
		//JFrame f1 = new JFrame();
		String str1 = tf1.getText();
		char [] p = p1.getPassword();
		String s2 = new String(p);
		 Connection conn = null;
		               PreparedStatement pstmt=null;
		               try{
		                      String query = "select name from login1 where uid=? and password= ? ";
		                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/userregist?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		        pstmt = conn.prepareStatement(query);
		        pstmt.setString(1, str1);
        pstmt.setString(2, s2);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
		{

			//Calc c=new Calc().setVisible(true);

		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}

	}
	public static void main(String []args)
	{
		new Login();
	}
}




