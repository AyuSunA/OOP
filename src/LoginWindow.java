import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.sql.Connection;

public  class LoginWindow extends JFrame{

    private static Connection dbConn = null;

    //标签
    private JLabel lable1;
    private JLabel lable2;
    //文本框
    private JTextField text1;
    private JTextField text2;
    //按钮
    private JButton bt1;
    private JButton bt2;

    //构造函数
    public LoginWindow()
    {
        this.init();
        this.addComponent();
        this.addListener();
    }

    public void init()
    {
        this.setSize(500,400);
        this.setVisible(true);
        this.setTitle("登录界面");
        this.setLayout(null);
        this.setLocation(700, 300);
    }
    private void addComponent()
    {
        lable1 = new JLabel("用户名");
        lable1.setSize(100,70);
        lable1.setLocation(100,80);
        this.add(lable1);
        lable2 = new JLabel("密    码");
        lable2.setSize(100,70);
        lable2.setLocation(100,130);
        this.add(lable2);

        text1 = new JTextField();
        text1.setSize(150,30);
        text1.setLocation(160,100);
        this.add(text1);
        text2 = new JTextField();
        text2.setSize(150,30);
        text2.setLocation(160,150);
        this.add(text2);

        bt1 = new JButton("登录");
        bt1.setSize(70,30);
        bt1.setLocation(140,195);
        this.add(bt1);
        bt2 = new JButton("退出");
        bt2.setSize(70,30);
        bt2.setLocation(250,195);
        this.add(bt2);
        this.setBackground(Color.blue);
        //设置单击关闭按钮时的默认操作
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void addListener()
    {
        bt1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                if(text1.getText().equals("001")&&text2.getText().equals("123456"))
                //此处假设管理员只有一个 用户名为001 密码为123456
                {
                    new MainWindow();
                    dispose();

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "登陆密码错误");
                }
            }
        });

        bt2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        new LoginWindow();

    }
}

