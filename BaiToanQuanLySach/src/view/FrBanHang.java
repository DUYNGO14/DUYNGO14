package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.loaibean;
import bean.sachbean;
import bo.loaibo;
import bo.sachbo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrBanHang extends JFrame {

	private JPanel contentPane;
	private JTextField txttensach;
	private JTextField txttacgia;
	private JTextField txtgia;
	private JTextField txtsoluong;
	private JTextField txtsl;
	private JTextField txtthanhtien;
	JList list = new JList();
	JComboBox cmbmasach = new JComboBox();
	loaibo lbo = new loaibo();
	sachbo sbo = new sachbo();
	ArrayList<sachbean> ds;
	private JTable table;

	void NhapBang(ArrayList<sachbean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Mã sách");
		mh.addColumn("Tên sách");
		mh.addColumn("Số lượng");
		mh.addColumn("Giá");
		mh.addColumn("Mã loại");
		mh.addColumn("Số tập");
		mh.addColumn("Ảnh");
		mh.addColumn("Ngày nhập");
		mh.addColumn("Tác giả");
		for (sachbean s : ds) {
			Object[] t = new Object[9];
			t[0] = s.getMasach();
			t[1] = s.getTensach();
			t[2] = s.getSoluong();
			t[3] = s.getGia();
			t[4] = s.getMaloai();
			t[5] = s.getSotap();
			t[6] = s.getAnh();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String ngaysinh = formatter.format(s.getNgayNhap());
			t[7] = ngaysinh;
			t[8] = s.getTacgia();
			mh.addRow(t);
		}
		table.setModel(mh);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrBanHang frame = new FrBanHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrBanHang() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					DefaultListModel<loaibean> mh = new DefaultListModel<loaibean>();
					for (loaibean loai : lbo.getloai()) {
						mh.addElement(loai);
					}
					list.setModel(mh);
					ds = sbo.getsach();
					NhapBang(ds);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Chọn 1 mã loại sách");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 12, 142, 28);
		contentPane.add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 48, 153, 241);
		contentPane.add(scrollPane);

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try {
					loaibean loai = (loaibean) list.getSelectedValue();
					NhapBang(sbo.TimSachMaLoai(loai.getMaloai()));
					DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
					for (sachbean s : sbo.TimSachMaLoai(loai.getMaloai())) {
						model.addElement(s.getMasach());
					}
					cmbmasach.setModel(model);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});

		scrollPane.setViewportView(list);
		JLabel lblmasach = new JLabel("Mã Sách");
		lblmasach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblmasach.setBounds(238, 20, 85, 13);
		contentPane.add(lblmasach);
		cmbmasach.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String masach = cmbmasach.getSelectedItem().toString();
				try {
					sachbean kq = sbo.TimSachMaSach(masach);
					txttensach.setText(kq.getTensach());
					txttacgia.setText(kq.getTacgia());
					txtsoluong.setText(String.valueOf(kq.getSoluong()));
					txtgia.setText(String.valueOf(kq.getGia()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		cmbmasach.setBounds(350, 16, 189, 21);
		contentPane.add(cmbmasach);

		JLabel lbltensach = new JLabel("Tên Sách");
		lbltensach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbltensach.setBounds(238, 64, 85, 13);
		contentPane.add(lbltensach);

		JLabel lbltacgia = new JLabel("Tác Giả");
		lbltacgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbltacgia.setBounds(238, 106, 85, 13);
		contentPane.add(lbltacgia);

		JLabel lblgia = new JLabel("Giá");
		lblgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblgia.setBounds(238, 150, 85, 13);
		contentPane.add(lblgia);

		JLabel lblsoluong = new JLabel("Số Lượng");
		lblsoluong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblsoluong.setBounds(234, 187, 85, 21);
		contentPane.add(lblsoluong);

		JLabel lblNhpSl = new JLabel("Nhập sl");
		lblNhpSl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNhpSl.setBounds(238, 225, 85, 21);
		contentPane.add(lblNhpSl);

		JLabel lblThnhTin = new JLabel("Thành Tiền");
		lblThnhTin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThnhTin.setBounds(238, 268, 85, 21);
		contentPane.add(lblThnhTin);

		txttensach = new JTextField();
		txttensach.setBounds(350, 62, 189, 19);
		contentPane.add(txttensach);
		txttensach.setColumns(10);

		txttacgia = new JTextField();
		txttacgia.setBounds(350, 106, 189, 19);
		contentPane.add(txttacgia);
		txttacgia.setColumns(10);

		txtgia = new JTextField();
		txtgia.setColumns(10);
		txtgia.setBounds(350, 145, 189, 19);
		contentPane.add(txtgia);

		txtsoluong = new JTextField();
		txtsoluong.setColumns(10);
		txtsoluong.setBounds(350, 187, 189, 19);
		contentPane.add(txtsoluong);

		txtsl = new JTextField();
		txtsl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					Long sl = Long.parseLong(txtsl.getText());
					Long gia = Long.parseLong(txtgia.getText());
					Long soluong = Long.parseLong(txtsoluong.getText());
					Long kq = sl * gia;
					txtthanhtien.setText(kq.toString() + " vnd");
				}
			}
		});
		txtsl.setColumns(10);
		txtsl.setBounds(351, 227, 188, 19);
		contentPane.add(txtsl);

		txtthanhtien = new JTextField();
		txtthanhtien.setColumns(10);
		txtthanhtien.setBounds(350, 270, 189, 19);
		contentPane.add(txtthanhtien);

		JButton btnban = new JButton("Bán");
		btnban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Long sl = Long.parseLong(txtsl.getText());
					Long gia = Long.parseLong(txtgia.getText());
					Long soluong = Long.parseLong(txtsoluong.getText());
					String masach = cmbmasach.getSelectedItem().toString();
					if (sl > soluong) {
						JOptionPane.showMessageDialog(null, "Không đủ số lượng để bán");
					} else {
						Long kq = sl * gia;
						txtthanhtien.setText(kq.toString() + " vnd");
						JOptionPane.showMessageDialog(null,
								"Đã bán" + "\n" + "Tên sách: " + txttensach.getText() + "\n" + "Số lượng :"
										+ txtsl.getText().toString() + "\n" + "Tổng tiền: "
										+ txtthanhtien.getText().toString());
						loaibean loai = (loaibean) list.getSelectedValue();
						sbo.SuaSoLuong(masach, sl);
						NhapBang(sbo.TimSachMaLoai(loai.getMaloai()));
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		btnban.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnban.setBounds(609, 16, 85, 21);
		contentPane.add(btnban);

		JButton btnTmMSch = new JButton("Tìm mã sách");
		btnTmMSch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String masach = JOptionPane.showInputDialog("Nhập vào mã sách cần tìm: ");
				try {
					NhapBang(sbo.TimSachMaSach1(masach));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		});
		btnTmMSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTmMSch.setBounds(609, 62, 127, 21);
		contentPane.add(btnTmMSch);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 323, 772, 157);
		contentPane.add(tabbedPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane_1, null);

		table = new JTable();
		scrollPane_1.setColumnHeaderView(table);
		scrollPane_1.setViewportView(table);
	}
}
