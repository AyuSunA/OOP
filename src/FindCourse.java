import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public  class FindCourse extends JPanel implements ActionListener{
    JLabel Inputlabel;
    JTextField Inputtext;
    JButton Findbt;
    JLabel Cnolabel;
    JLabel Cnamelabel;
    JLabel Creditlabel;
    JTextField Cnotext;
    JTextField Cnametext;
    JTextField Credittext;

    public FindCourse() {

        this.setSize(650,350);
        this.setLocation(100, 20);
        this.setLayout(null);
        this.setBackground(Color.lightGray);



        Cnolabel=new JLabel("课程号");
        Cnolabel.setSize(100,30);
        Cnolabel.setLocation(100, 120);
        this.add(Cnolabel);

        Cnotext=new JTextField();
        Cnotext.setSize(120,30);
        Cnotext.setLocation(220, 120);
        this.add(Cnotext);

        Cnamelabel=new JLabel("课程名称");
        Cnamelabel.setSize(100,30);
        Cnamelabel.setLocation(100, 160);
        this.add(Cnamelabel);

        Cnametext=new JTextField();
        Cnametext.setSize(120,30);
        Cnametext.setLocation(220, 160);
        this.add(Cnametext);

        Creditlabel=new JLabel("课程学分");
        Creditlabel.setSize(100,30);
        Creditlabel.setLocation(100, 240);
        this.add(Creditlabel);

        Credittext=new JTextField();
        Credittext.setSize(120, 30);
        Credittext.setLocation(220, 240);
        this.add(Credittext);


        Inputlabel=new JLabel("请输入课程号");
        Inputlabel.setSize(150,50);
        Inputlabel.setLocation(100, 45);
        this.add(Inputlabel);

        Inputtext=new JTextField();
        Inputtext.setSize(160,40);
        Inputtext.setLocation(200, 45);
        this.add(Inputtext);

        Findbt=new JButton("查询");
        Findbt.setSize(90,38);
        Findbt.setLocation(420, 45);
        this.add(Findbt);
        Findbt.addActionListener(this);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String inputName=Inputtext.getText();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //加载对应的jdbc驱动
            String url="jdbc:sqlserver://localhost:1433; DatabaseName=choose_course";
            //配置连接字符串
            String user="sa";//sa超级管理员
            String password="123456";//密码
            Connection conn=DriverManager.getConnection(url,user,password);
            //创建数据库连接对象
            Statement st=conn.createStatement();
            //创建SQL语句执行对象

            String  strSQL="(Select* from tb_course where CourseNum='"+inputName+"' )";
            ResultSet rs=st.executeQuery(strSQL);

            if(rs.next())
            {
                Cnotext.setText(rs.getString(1));
                Cnametext.setText(rs.getString(2));
                Credittext.setText(rs.getString(3));
            }
            else
            {
                JOptionPane.showMessageDialog(null, "您查询的课程不存在，请重新输入");
            }
            conn.close();

            //关闭数据库连接
        }
        catch (ClassNotFoundException ex) {
            System.out.println("没有找到对应的数据库驱动类");
        }
        catch (SQLException ex) {
            System.out.println("数据库连接或者是数据库操作失败");
        }

    }

}

