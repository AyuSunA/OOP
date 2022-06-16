import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/*
该程序是管理员对于选课系统的管理
 */
public class MainWindow extends JFrame implements ActionListener {

    JButton bt1;
    JButton bt2;
    JButton bt3;
    JButton bt4;
    JButton bt5;
    JButton bt6;
    JPanel panel;
    JPanel panel2;
    JLabel label;


    MainWindow(){
        this.setSize(1200, 1000);
        this.setTitle("学生选课管理系统");
        this.setLayout(null);
        this.setLocation(400,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bt1=new JButton("发布课程信息");
        bt1.setSize(150, 50);
        bt1.setLocation(150, 400);
        bt1.addActionListener(this);
        bt1.setActionCommand("发布课程信息");

        bt2=new JButton("查询课程");
        bt2.setSize(150, 50);
        bt2.setLocation(150, 500);
        bt2.addActionListener(this);
        bt2.setActionCommand("查询课程");

        bt3=new JButton("删除课程");
        bt3.setSize(150, 50);
        bt3.setLocation(350, 400);
        bt3.addActionListener(this);
        bt3.setActionCommand("删除课程");


        bt4=new JButton("学生管理");
        bt4.setSize(150, 50);
        bt4.setLocation(350, 500);
        bt4.addActionListener(this);
        bt4.setActionCommand("学生管理");

        bt5=new JButton("教师管理");
        bt5.setSize(150, 50);
        bt5.setLocation(550, 400);
        bt5.addActionListener(this);
        bt5.setActionCommand("教师管理");

        this.add(bt1);
        this.add(bt2);
        this.add(bt3);
        this.add(bt4);
        this.add(bt5);

        panel=new JPanel();
        panel.setLocation(100, 20);
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        this.add(panel);

        panel2=new JPanel();
        panel2.setSize(650,350);
        panel2.setLocation(100, 20);
        panel2.setLayout(null);
        panel2.setBackground(Color.lightGray);

        label=new JLabel();
        label.setText("欢迎登陆课程管理系统");
        label.setLocation(165,60);
        label.setSize(500, 200);
        panel2.add(label);
        label.setFont( (new Font("仿宋",Font.BOLD,30)));
        this.add(panel2);
        panel2.setVisible(true);

        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        JButton bt=(JButton )e.getSource();
        //移除上一个面板
        if(bt!=null)
        {
            this.remove(panel2);
            this.remove(panel);
        }
        if(bt.getText().equals("发布课程信息"))
        {
            panel=new SubmitCourse();
            panel.setLocation(100, 20);
            this.add(panel);
            this.repaint();
        }

        else {
            if(bt.getText().equals("查询课程"))
            {
                panel=new FindCourse();
                panel.setLocation(100, 20);
                this.add(panel);
                this.repaint();
            }

            else {
                if(bt.getText().equals("删除课程"))
                {
                    panel=new DeleteCourse();
                    panel.setLocation(100, 20);
                    this.add(panel);
                    this.repaint();
                }

                else {
                    if(bt.getText().equals("学生管理"))
                    {
                        panel=new AStudent();
                        panel.setLocation(100, 20);
                        this.add(panel);
                        this.repaint();
                    }
                    else{
                        if(bt.getText().equals("教师管理"))
                        {
                            panel = new ATeacher();
                            panel.setLocation(100, 20);
                            this.add(panel);
                            this.repaint();
                        }
                    }
                }
            }
        }
    }

}


