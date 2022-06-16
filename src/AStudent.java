import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public  class AStudent extends JPanel implements ActionListener{
    JLabel Snolabel;
    JLabel Snamelabel;
    JLabel Sbirthlabel;
    JLabel Ssexlabel;
    JLabel Sdeptlabel;
    JLabel Spasswordlabel;

    JTextField Snotext;
    JTextField Snametext;
    JTextField Sbirthtext;
    JTextField SSextext;
    JTextField Sdepttext;
    JTextField Spasswordtext;

    JButton Addbt;
    JScrollPane scrollpane;
    JTable table;


    public AStudent() {
        this.setSize(1000,850);
        this.setLocation(100, 20);
        this.setLayout(null);
        this.setBackground(Color.lightGray);


        Snolabel=new JLabel("请输入学生学号");
        Snolabel.setSize(100,30);
        Snolabel.setLocation(60, 20);

        this.add(Snolabel);

        Snotext=new JTextField();
        Snotext.setSize(120,30);
        Snotext.setLocation(180, 20);
        this.add(Snotext);

        Snamelabel=new JLabel("请输入学生姓名");
        Snamelabel.setSize(100,30);
        Snamelabel.setLocation(60, 60);
        this.add(Snamelabel);

        Snametext=new JTextField();
        Snametext.setSize(120,30);
        Snametext.setLocation(180, 60);
        this.add(Snametext);

        Ssexlabel=new JLabel("请输入学生性别");
        Ssexlabel.setSize(100,30);
        Ssexlabel.setLocation(60, 100);
        this.add(Ssexlabel);

        SSextext=new JTextField();
        SSextext.setSize(120,30);
        SSextext.setLocation(180, 100);
        this.add(SSextext);

        Sdeptlabel=new JLabel("请输入所在系");
        Sdeptlabel.setSize(100,30);
        Sdeptlabel.setLocation(60, 140);
        this.add(Sdeptlabel);

        Sdepttext=new JTextField();
        Sdepttext.setSize(120,30);
        Sdepttext.setLocation(180, 140);
        this.add(Sdepttext);


        Sbirthlabel=new JLabel("请输入出生日期");
        Sbirthlabel.setSize(100,30);
        Sbirthlabel.setLocation(60, 180);
        this.add(Sbirthlabel);

        Sbirthtext=new JTextField();
        Sbirthtext.setSize(120,30);
        Sbirthtext.setLocation(180, 180);
        this.add(Sbirthtext);

        Addbt=new JButton("添加");
        Addbt.setSize(80,30);
        Addbt.setLocation(350, 80);
        this.add(Addbt);
        Addbt.addActionListener(this);


        Spasswordlabel=new JLabel("请输入学生密码");
        Spasswordlabel.setSize(100,30);
        Spasswordlabel.setLocation(60, 220);
        this.add(Spasswordlabel);

        Spasswordtext=new JTextField();
        Spasswordtext.setSize(120,30);
        Spasswordtext.setLocation(180, 220);
        this.add(Spasswordtext);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String addSno=Snotext.getText();
        String addSname=Snametext.getText();
        String addSsex=SSextext.getText();
        String addSbirth=Sbirthtext.getText();
        String addSdept=Sdepttext.getText();
        String addSpassword=Spasswordtext.getText();

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

            String  strSQL="insert into tb_student values('"+addSno+"','"+addSname+"','"+addSsex+"','"+addSbirth+"','"+addSpassword+"','"+addSdept+"','"+"001"+"')";
            String  strSQL1="(Select* from tb_student where StudentNum='"+addSno+"' )";

            if(!addSno.trim().equals(""))
            {
                ResultSet rs1=st.executeQuery(strSQL1);

                if(rs1.next())
                {
                    JOptionPane.showMessageDialog(null,"该学生信息已存在");     }
                else {
                    int rs=st.executeUpdate(strSQL);

                    if(rs==1) {
                        JOptionPane.showMessageDialog(null,"学生信息添加成功");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"学生信息添加失败");
                    }
                }
            }
            else
            { JOptionPane.showMessageDialog(null,"请输入学生信息");
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



