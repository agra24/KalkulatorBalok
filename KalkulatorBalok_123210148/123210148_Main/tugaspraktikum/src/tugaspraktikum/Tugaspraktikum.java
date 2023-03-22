package tugaspraktikum;

    import java.awt.event.*;
    import java.awt.*;
    import javax.swing.*;


public class Tugaspraktikum extends JFrame implements ActionListener{
    
    private JFrame frame;
    private JPanel panel;
    private JLabel panjang,lebar,tinggi,hasil;
    private JTextField tpanjang,tlebar,ttinggi,thasil;
    private JButton hitung;
    private JRadioButton luas;
    private JRadioButton volume;
    private ButtonGroup btngroup;
    
    public Tugaspraktikum(){
        
        frame = new JFrame("Menghitung Luas dan Volume Balok");
        panel = new JPanel(new GridLayout(6, 2, 10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.add(panel);
        
        panjang = new JLabel("Panjang  ");
        lebar = new JLabel("Lebar  ");
        tinggi = new JLabel("Tinggi  ");
        hasil = new JLabel("Hasilnya  ");
        tpanjang = new JTextField();
        tlebar = new JTextField();
        ttinggi = new JTextField();
        thasil = new JTextField();
        thasil.setEditable(false);
        
        luas=new JRadioButton("Luas");
        volume=new JRadioButton("Volume");
        btngroup = new ButtonGroup();
        btngroup.add(luas);
        btngroup.add(volume);
        luas.setSelected(true);
        
        hitung = new JButton("Hitung");
        hitung.addActionListener(this);
        
        
        panel.add(panjang);
        panel.add(tpanjang);
        panel.add(lebar);
        panel.add(tlebar);
        panel.add(tinggi);
        panel.add(ttinggi);
        panel.add(luas);
        panel.add(volume);
        panel.add(hasil);
        panel.add(thasil);
        panel.add(new JLabel());
        panel.add(hitung);

        // Menampilkan JFrame
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {

        double p, l, t;
        try {
            p = Double.parseDouble(tpanjang.getText());
            l = Double.parseDouble(tlebar.getText());
            t = Double.parseDouble(ttinggi.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Input harus berupa angka dan tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double h;
        if (luas.isSelected()) {
            h = 2 * (p * l + p * t + l * t);
        } else {
            h = p * l * t;
        }
        
        thasil.setText(String.format("%.2f", h));
    }

    public static void main(String[] args) {
        new Tugaspraktikum();
    }
}
