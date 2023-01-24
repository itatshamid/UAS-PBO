package DaftarPasienRSView;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author abdul.wijaya
 */
public class RSGUI {

    JFrame LogReg = new JFrame();
    JLabel login, daftar, top;
    JRadioButton radiodokter, radiopasien;
    JTextField textkodelogin, textnama, textnotelp, texttgllahir, textkodedaftar, textalamat;
    JLabel labelkodelogin, labelnama, labelpasswordlogin, labelnotelp, labeltgllahir, labelkodedaftar, labelpassworddaftar, alamatlabel;
    JButton check, reg;
    JPasswordField passwordlogin, passworddaftar;
    private boolean ceklogin = false;

    public RSGUI() {
        LogReg.setSize(700, 630);
        LogReg.setLayout(null);
        LogReg.getContentPane().setBackground(Color.LIGHT_GRAY);

        top = new JLabel("TUGAS AKHIR PRAKTIKUM PBO");
        top.setBounds(100, 10, 600, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 28));
        LogReg.add(top);

        top = new JLabel("PENDAFTARAN PASIEN POLIKLINIK");
        top.setBounds(70, 40, 600, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 28));
        LogReg.add(top);

        login = new JLabel("Login");
        login.setBounds(100, 50, 100, 100);
        login.setFont(new Font("Times New Roman", Font.BOLD, 30));
        LogReg.add(login);
        radiodokter = new JRadioButton("Dokter");
        login.setBounds(100, 75, 100, 100);

        radiodokter.setBounds(30, 150, 100, 30);
        radiodokter.setBackground(Color.ORANGE);
        LogReg.add(radiodokter);
        radiopasien = new JRadioButton("Pasien");
        radiopasien.setBounds(149, 150, 100, 30);
        radiopasien.setBackground(Color.ORANGE);
        LogReg.add(radiopasien);
        labelkodelogin = new JLabel("Kode");
        labelkodelogin.setBounds(38, 188, 40, 20);
        LogReg.add(labelkodelogin);
        textkodelogin = new JTextField();
        textkodelogin.setBounds(30, 210, 200, 30);
        LogReg.add(textkodelogin);
        labelpasswordlogin = new JLabel("Password");
        labelpasswordlogin.setBounds(39, 240, 100, 30);
        LogReg.add(labelpasswordlogin);
        passwordlogin = new JPasswordField();
        passwordlogin.setBounds(30, 279, 280, 36);
        LogReg.add(passwordlogin);
        check = new JButton("Check");
        check.setBounds(90, 320, 180, 40);
        check.setBackground(Color.GREEN);
        LogReg.add(check);
        daftar = new JLabel("Daftar");
        daftar.setFont(new Font("Times New Roman", Font.BOLD, 30));
        daftar.setBounds(440, 75, 150, 100);
        LogReg.add(daftar);
        labelkodedaftar = new JLabel("Kode");
        labelkodedaftar.setBounds(400, 150, 30, 30);
        LogReg.add(labelkodedaftar);
        textkodedaftar = new JTextField();
        textkodedaftar.setBounds(400, 180, 200, 30);
        LogReg.add(textkodedaftar);
        labelnama = new JLabel("Nama");
        labelnama.setBounds(400, 210, 100, 30);
        LogReg.add(labelnama);
        textnama = new JTextField();
        textnama.setBounds(400, 240, 200, 30);
        LogReg.add(textnama);
        labelpassworddaftar = new JLabel("Password");
        labelpassworddaftar.setBounds(400, 270, 100, 30);
        LogReg.add(labelpassworddaftar);
        passworddaftar = new JPasswordField();
        passworddaftar.setBounds(400, 300, 200, 30);
        LogReg.add(passworddaftar);
        labelnotelp = new JLabel("No Telepon");
        labelnotelp.setBounds(400, 330, 100, 30);
        LogReg.add(labelnotelp);
        textnotelp = new JTextField();
        textnotelp.setBounds(400, 360, 200, 30);
        LogReg.add(textnotelp);
        labeltgllahir = new JLabel("tanggal Lahir (dd/mm/yyyy)");
        labeltgllahir.setBounds(400, 390, 200, 30);
        LogReg.add(labeltgllahir);
        texttgllahir = new JTextField();
        texttgllahir.setBounds(400, 420, 200, 30);
        LogReg.add(texttgllahir);
        alamatlabel = new JLabel("Alamat");
        alamatlabel.setBounds(400, 450, 200, 30);
        LogReg.add(alamatlabel);
        textalamat = new JTextField();
        textalamat.setBounds(400, 480, 200, 30);
        LogReg.add(textalamat);
        reg = new JButton("Daftar");
        reg.setBounds(460, 520, 100, 40);
        reg.setBackground(Color.GREEN);
        LogReg.add(reg);
        LogReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogReg.setVisible(true);
        LogReg.setLocationRelativeTo(null);

        radiodokter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (radiodokter.isSelected()) {
                    radiopasien.setSelected(false);
                    ceklogin = true;
                }
            }
        });
        radiopasien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (radiopasien.isSelected()) {
                    radiodokter.setSelected(false);
                    ceklogin = false;
                }
            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ceklogin == true) {
                    try {
                        Allobjectc.admin.dataDokter();
                        Allobjectc.admin.login(textkodelogin.getText(), passwordlogin.getText());
                        String nama = Allobjectc.admin.dokterEntity().getNama();
                        JOptionPane.showMessageDialog(null, "selamat datang " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                        DokterGUI dok = new DokterGUI();
                        LogReg.dispose();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(
                                null, "KODE atau password salah", "information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    }
                } else {
                    try {
                        Allobjectc.Pasien.login(textkodelogin.getText(), passwordlogin.getText());
                        String nama = Allobjectc.Pasien.pasienEntity().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat Datang " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                        PasienGUI pas = new PasienGUI();
                        LogReg.dispose();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "KODE atau password salah", " information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    }
                }
            }
        });
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String kode = textkodedaftar.getText();
                    String pass = passworddaftar.getText();
                    String nama = textnama.getText();
                    String notelp = textnotelp.getText();
                    Date tgllahir = new Date(texttgllahir.getText());
                    String alamat = textalamat.getText();
                    Allobjectc.Pasien.insert(kode, pass, nama, notelp, tgllahir, alamat);
                    JOptionPane.showMessageDialog(null, "Registrasi Sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Registrasi Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    void kosong() {
        textkodedaftar.setText(null);
        passworddaftar.setText(null);
        textnama.setText(null);
        textnotelp.setText(null);
        texttgllahir.setText(null);
        textkodelogin.setText(null);
        passwordlogin.setText(null);
        textalamat.setText(null);

    }
}
