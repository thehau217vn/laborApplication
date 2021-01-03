/**
 * @Author: Nhom 9
 * IUH
 */
package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.*;

public class SplashScreen extends JWindow {

    private static final long serialVersionUID = 1L;
    static boolean isRegistered;
    private static JProgressBar progressBar = new JProgressBar();
    private static SplashScreen execute;
    private static int count;
    private static Timer timer1;

    public SplashScreen() {

        Container container = getContentPane();
        container.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new javax.swing.border.EtchedBorder());
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 10, 450, 290);
        panel.setLayout(null);
        container.add(panel);

        JLabel label = new JLabel();
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo2.jpg")));
        label.setBounds(10, 10, 450, 290);
        panel.add(label);

        progressBar.setMaximum(10);
        progressBar.setBounds(10, 305, 449, 10);
        container.add(progressBar);
        loadProgressBar();
        setSize(470, 320);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadProgressBar() {
        ActionListener al = new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                count++;
                progressBar.setValue(count);
                System.out.println(count);
                if (count == 50) {
                    try {
                        createFrame();
                    } catch (HeadlessException | MalformedURLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    execute.setVisible(false);//swapped this around with timer1.stop()
                    timer1.stop();
                }

            }

            private void createFrame() throws HeadlessException, MalformedURLException {
                JFrame frame = new DangNhap();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        };
        timer1 = new Timer(40, al);
        timer1.start();
    }

    public static void main(String[] args) {
        execute = new SplashScreen();
    }
};