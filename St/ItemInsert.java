import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ItemInsert implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3,l4,l5;
	JTextField tf1,tf2,tf3,tf4;
	JButton btn1;
	ItemInsert()
	{
		f=new JFrame(" stock management system");
		f.setVisible(true);
		f.setSize(800,800);
		l1=new JLabel("Insert Stock Item into the system");
		l2 = new JLabel("Enter Item  ID");
		l3 = new JLabel("Enter Item Type");
		l4 = new JLabel("Enter Item Price");
		l5 = new JLabel("Enter Item Quantaty");
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		btn1 = new JButton("Submit");
		l1.setBounds(100,30,400,30);
		l2.setBounds(80,70,200,30);
		l3.setBounds(80,110,200,30);
		l4.setBounds(80,150,200,30);
		l5.setBounds(80,190,200,30);
		tf1.setBounds(300,70,200,30);
		tf2.setBounds(300,110,200,30);
		tf3.setBounds(300,150,200,30);
		tf4.setBounds(300,190,200,30);
		btn1.setBounds(150,240,100,30);
		f.add(l1);
		f.add(l2);
		f.add(tf1);
		f.add(l3);
		f.add(tf2);
		f.add(l4);
		f.add(tf3);
		f.add(l5);
		f.add(tf4);
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
				 Connection con = null;
    			PreparedStatement pst = null;
					  try
					        {
					              String query = "INSERT INTO `item`(`itemNumber`, `itemType`, `itemPrice`, `itemQty`) VALUES (?,?,?,?)";
					              con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userregist?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
					            pst = con.prepareStatement(query);
					             pst.setString(1, tf1.getText());
					            pst.setString(2, tf2.getText());
					            pst.setString(3, tf3.getText());
					            pst.setString(4, tf4.getText());
					            pst.executeUpdate();
					          //  System.out.println("Product sucessfuly upadated");
					        }
					        catch(SQLException | HeadlessException ex)
					        {
					             System.out.println(ex);
      					    }
			}
			public static void main(String []args)
				{
					new ItemInsert();
			}



}