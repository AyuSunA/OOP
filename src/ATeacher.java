import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public  class ATeacher extends JPanel implements ActionListener{
    JLabel Tnolabel;
    JLabel Tnamelabel;
    JLabel Tbirthlabel;
    JLabel Tsexlabel;
    JLabel Tdeptlabel;
    JLabel Tpasswordlabel;
    JLabel Titlelabel;

    JTextField Tnotext;
    JTextField Tnametext;
    JTextField Tbirthtext;
    JTextField TSextext;
    JTextField Tdepttext;
    JTextField Tpasswordtext;
    JTextField Titletext;

    JButton Addbt;
    JScrollPane scrollpane;
    JTable table;


    public ATeacher() {
        this.setSize(1000,850);
        this.setLocation(100, 20);
        this.setLayout(null);
        this.setBackground(Color.lightGray);


        Tnolabel=new JLabel("请输入教工号");
        Tnolabel.setSize(100,30);
        Tnolabel.setLocation(60, 20);

        this.add(Tnolabel);

        Tnotext=new JTextField();
        Tnotext.setSize(120,30);
        Tnotext.setLocation(180, 20);
        this.add(Tnotext);

        Tnamelabel=new JLabel("请输入教师姓名");
        Tnamelabel.setSize(100,30);
        Tnamelabel.setLocation(60, 60);
        this.add(Tnamelabel);

        Tnametext=new JTextField();
        Tnametext.setSize(120,30);
        Tnametext.setLocation(180, 60);
        this.add(Tnametext);

        Tsexlabel=new JLabel("请输入教师性别");
        Tsexlabel.setSize(100,30);
        Tsexlabel.setLocation(60, 100);
        this.add(Tsexlabel);

        TSextext=new JTextField();
        TSextext.setSize(120,30);
        TSextext.setLocation(180, 100);
        this.add(TSextext);

        Tdeptlabel=new JLabel("请输入教师所在系");
        Tdeptlabel.setSize(100,30);
        Tdeptlabel.setLocation(60, 140);
        this.add(Tdeptlabel);

        Tdepttext=new JTextField();
        Tdepttext.setSize(120,30);
        Tdepttext.setLocation(180, 140);
        this.add(Tdepttext);


        Tbirthlabel=new JLabel("请输入出生日期");
        Tbirthlabel.setSize(100,30);
        Tbirthlabel.setLocation(60, 180);
        this.add(Tbirthlabel);

        Tbirthtext=new JTextField();
        Tbirthtext.setSize(120,30);
        Tbirthtext.setLocation(180, 180);
        this.add(Tbirthtext);

        Addbt=new JButton("添加");
        Addbt.setSize(80,30);
        Addbt.setLocation(350, 80);
        this.add(Addbt);
        Addbt.addActionListener(this);


        Tpasswordlabel=new JLabel("请输入教师密码");
        Tpasswordlabel.setSize(100,30);
        Tpasswordlabel.setLocation(60, 220);
        this.add(Tpasswordlabel);

        Tpasswordtext=new JTextField();
        Tpasswordtext.setSize(120,30);
        Tpasswordtext.setLocation(180, 220);
        this.add(Tpasswordtext);

        Titlelabel=new JLabel("请输入教师职称");
        Titlelabel.setSize(100,30);
        Titlelabel.setLocation(60, 260);
        this.add(Titlelabel);

        Titletext=new JTextField();
        Titletext.setSize(120,30);
        Titletext.setLocation(180, 260);
        this.add(Titletext);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String addTno=Tnotext.getText();
        String addTname=Tnametext.getText();
        String addTsex=TSextext.getText();
        String addTbirth=Tbirthtext.getText();
        String addTdept=Tdepttext.getText();
        String addTpassword=Tpasswordtext.getText();
        String addTitle=Titletext.getText();

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

            String  strSQL="insert into tb_teacher values('"+addTno+"','"+addTdept+"','"+addTname+"','"+addTsex+"','"+addTitle+"','"+addTbirth+"','"+addTpassword+"','"+"001"+"')";
            String  strSQL1="(Select* from tb_teacher where TeacherNum='"+addTno+"' )";

            if(!addTno.trim().equals(""))
            {
                ResultSet rs1=st.executeQuery(strSQL1);

                if(rs1.next())
                {
                    JOptionPane.showMessageDialog(null,"该教师信息已存在");     }
                else {
                    int rs=st.executeUpdate(strSQL);

                    if(rs==1) {
                        JOptionPane.showMessageDialog(null,"教师信息添加成功");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"教师信息添加失败");
                    }
                }
            }
            else
            { JOptionPane.showMessageDialog(null,"请输入教师信息");
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
