import java.awt.Color;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public  class SubmitCourse extends JPanel implements ActionListener{
    JLabel Cnolabel;
    JLabel Cnamelabel;
    JLabel Creditlabel;
    JTextField Cnotext;
    JTextField Cnametext;
    JTextField Credittext;
    //JComboBox<String> Typecom;
    JButton Addbt;
    JScrollPane scrollpane;
    JTable table;


    public SubmitCourse() {
        this.setSize(650,350);
        this.setLocation(100, 20);
        this.setLayout(null);
        this.setBackground(Color.lightGray);


        Cnolabel=new JLabel("请输入课程号");
        Cnolabel.setSize(100,30);
        Cnolabel.setLocation(60, 20);

        this.add(Cnolabel);

        Cnotext=new JTextField();
        Cnotext.setSize(120,30);
        Cnotext.setLocation(180, 20);
        this.add(Cnotext);

        //--------------------------------------------------

        Cnamelabel=new JLabel("请输入课程名称");
        Cnamelabel.setSize(100,30);
        Cnamelabel.setLocation(60, 60);
        this.add(Cnamelabel);

        Cnametext=new JTextField();
        Cnametext.setSize(120,30);
        Cnametext.setLocation(180, 60);
        this.add(Cnametext);
        //------------------------------------------------------------


        Creditlabel=new JLabel("请输入课程学分");
        Creditlabel.setSize(100,30);
        Creditlabel.setLocation(60, 140);
        this.add(Creditlabel);

        Credittext=new JTextField();
        Credittext.setSize(120,30);
        Credittext.setLocation(180, 140);
        this.add(Credittext);
        this.setVisible(true);

        //----------------------------------------------------

        Addbt=new JButton("添加");
        Addbt.setSize(80,30);
        Addbt.setLocation(350, 80);
        this.add(Addbt);
        Addbt.addActionListener(this);



    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String addCno=Cnotext.getText();
        String addCname=Cnametext.getText();
        String addCredit=Credittext.getText();

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

            String  strSQL="insert into tb_course values('"+addCno+"','"+addCname+"','"+addCredit+"','"+"001"+"')";
            String  strSQL1="(Select* from tb_course where CourseNum ='"+addCno+"' )";//下面用来判断课程是否存在

            if(!addCno.trim().equals("")&&!addCname.trim().equals("")&&!addCredit.trim().equals(""))
            {
                ResultSet rs1=st.executeQuery(strSQL1);

                if(rs1.next())
                {
                    JOptionPane.showMessageDialog(null,"该课程已存在");     }
                else {
                    int rs=st.executeUpdate(strSQL);

                    if(rs==1) {
                        JOptionPane.showMessageDialog(null,"课程添加成功");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"课程添加失败");
                    }
                }
            }
            else
            { JOptionPane.showMessageDialog(null,"请输入课程信息");
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




