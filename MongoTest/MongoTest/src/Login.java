import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class Login extends javax.swing.JFrame {


    public Login() {
        initComponents();
        init();
    }

    private void init() {
        this.setTitle("登录界面");
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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        mainPicture = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("注册");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("重置");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("楷体", 0, 18)); // NOI18N
        jLabel1.setText("用户名");

        jLabel2.setFont(new java.awt.Font("楷体", 0, 18)); // NOI18N
        jLabel2.setText("密  码");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        mainPicture.setFont(new java.awt.Font("黑体", 1, 36)); // NOI18N
        //mainPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/resource/user.jpg"))); // NOI18N
        mainPicture.setText("图书管理系统");

        jButton2.setText("登录");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton3)
                                                .addGap(37, 37, 37)
                                                .addComponent(jButton2)
                                                .addGap(72, 72, 72))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                                        .addComponent(username))
                                                .addContainerGap(38, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(mainPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addGap(44, 44, 44))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        UserRegister ur = new UserRegister();
        ur.setVisible(true);
        this.dispose();
    }

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        this.username.setText("");
        this.password.setText("");
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
              /*
        思路：
        A:获取用户名和密码
        B:正则表达式校验用户名和密码
        C:创建对象调用功能，返回一个boolean值
        D:根据boolean值给出提示
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

        //连接数据库
        Demo demo = new Demo();
        demo.getConnect(27021,"users");
        //调用数据库内的数据，验证是否满足
        boolean flag = demo.login(username1,password1);
        if(flag){
            JOptionPane.showMessageDialog(this, "恭喜你登录成功");
        }else{
            JOptionPane.showMessageDialog(this, "用户名或者密码有误");
            this.username.setText("");
            this.password.setText("");
            this.username.requestFocus();
        }

    }


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel mainPicture;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;

}