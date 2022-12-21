
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class UserRegister extends javax.swing.JFrame {


    public UserRegister() {
        initComponents();
        init();
    }

    private void init() {
        this.setTitle("注册界面");
        this.setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();

        //获取屏幕的宽和高
        Dimension d = tk.getScreenSize();
        double srceenWidth = d.getWidth();
        double srceenHeigth = d.getHeight();

        //获取窗体的宽和高
        int frameWidth = this.getWidth();
        int frameHeight = this.getHeight();

        //获取新的宽和高
        int width = (int) (srceenWidth - frameWidth) / 2;
        int height = (int) (srceenHeigth - frameHeight) / 2;

        //设置窗体坐标
        this.setLocation(width, height);
        //根据路径获取图片
        Image i = tk.getImage("E:\\壁纸\\timg1.jpg");

        //给窗体设置图片
        this.setIconImage(i);

    }

    private void initComponents() {

        password = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        mainPicture1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton4.setText("确认");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("取消");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("楷体", 0, 18)); // NOI18N
        jLabel5.setText("用户名");

        jLabel6.setFont(new java.awt.Font("楷体", 0, 18)); // NOI18N
        jLabel6.setText("密  码");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        mainPicture1.setFont(new java.awt.Font("黑体", 1, 36)); // NOI18N
        //mainPicture1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/resource/user.jpg"))); // NOI18N
        mainPicture1.setText("图书管理系统");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(54, 54, 54)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel6))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                                                        .addComponent(username)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGap(98, 98, 98)
                                                                .addComponent(jButton4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                                                .addComponent(jButton6)
                                                                .addGap(45, 45, 45)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(mainPicture1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(mainPicture1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton6)
                                        .addComponent(jButton4))
                                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        /*
        分析：
        A:获取用户名和密码
        B:用正则表达式做数据校验
        C:封装成用户对象
        D:调用用户操作的功能进行注册
        E:回到登录界面
        */
        //获取用户名和密码
        String username1 = this.username.getText().trim();
        String password1 = this.password.getText().trim();

        //用正则表达式做数据校验
        //定义规则
        //用户名规则
        String usernameRegex = "[a-zA-z]{5}";
        //密码规则
        String passwordRegex = "\\w{6,12}";

        //校验
        if(!username1.matches(usernameRegex)) {
            JOptionPane.showMessageDialog(this, "用户名不满足条件(5个英文字母组成)");
            this.username.setText("");
            this.username.requestFocus();
            return;
        }

        if(!password1.matches(passwordRegex)) {
            JOptionPane.showMessageDialog(this, "密码不满足条件(6-12个任意单词字符)");
            this.password.setText("");
            this.password.requestFocus();
            return;
        }

        Demo dmRgs = new Demo();
        //写入
        dmRgs.getConnect(27020,"users");
        boolean flag = dmRgs.register(username1,password1);
        if(!flag){
            //成功注册，给出提示
            JOptionPane.showMessageDialog(this, "用户注册成功，回到登录界面");
            goLogin();
        }else{
            JOptionPane.showMessageDialog(this, "用户名重复注册失败");
        }
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        goLogin();
    }

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void goLogin() {
        Login hf = new Login();
        hf.setVisible(true);
        this.dispose();
    }


    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel mainPicture1;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;

}