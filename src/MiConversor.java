import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class MiConversor {

	private JFrame frmConversorDeMoneda;
	private JLabel lbl;
	private JComboBox cmb;
	private JButton btn;
	private JTextField txt;
	
	public enum Moneda{
		dolar,
		euro,
		libra,
		real,
		
	}
	
	public double dolar = 4104.47;
	public double euro = 4525.79;
	public double libra = 5232.37;
	public double real = 849.55;

	
	public double valorInput = 0.00;
	private JLabel lblNewLabel;
	private JLabel lblIngreseElValor;
	private JLabel lbl_1;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiConversor window = new MiConversor();
					window.frmConversorDeMoneda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MiConversor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConversorDeMoneda = new JFrame();
		frmConversorDeMoneda.setTitle("CONVERSOR DE MONEDA");
		frmConversorDeMoneda.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\kno_a\\Downloads\\change.jpg"));
		frmConversorDeMoneda.getContentPane().setBackground(Color.WHITE);
		frmConversorDeMoneda.getContentPane().setFont(new Font("Consolas", Font.BOLD, 15));
		frmConversorDeMoneda.setBounds(100, 100, 450, 300);
		frmConversorDeMoneda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversorDeMoneda.getContentPane().setLayout(null);
		
		txt = new JTextField();
		txt.setBackground(Color.WHITE);
		txt.setFont(new Font("Consolas", Font.BOLD, 15));
		txt.setBounds(35, 49, 239, 25);
		frmConversorDeMoneda.getContentPane().add(txt);
		txt.setColumns(10);
		
		cmb = new JComboBox<Moneda>();
		cmb.setForeground(new Color(0, 0, 0));
		cmb.setBackground(Color.WHITE);
		cmb.setFont(new Font("Consolas", Font.BOLD, 14));
		cmb.setModel(new DefaultComboBoxModel<>(Moneda.values()));
		cmb.setBounds(35, 108, 104, 40);
		frmConversorDeMoneda.getContentPane().add(cmb);
		
		//Evento Boton
		btn = new JButton("CONVERTIR");
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("Consolas", Font.BOLD, 15));
		btn.setBackground(Color.RED);
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btn.setBounds(35, 175, 140, 45);
		frmConversorDeMoneda.getContentPane().add(btn);
		
		lbl = new JLabel("00.00");
		lbl.setForeground(Color.RED);
		lbl.setFont(new Font("Consolas", Font.BOLD, 25));
		lbl.setBounds(233, 175, 145, 45);
		frmConversorDeMoneda.getContentPane().add(lbl);
		
		lblNewLabel = new JLabel("¿A qué valor desea convertirlo?");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(35, 85, 301, 25);
		frmConversorDeMoneda.getContentPane().add(lblNewLabel);
		
		lblIngreseElValor = new JLabel("Ingrese el valor en pesos colombianos");
		lblIngreseElValor.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 15));
		lblIngreseElValor.setBounds(35, 22, 301, 25);
		frmConversorDeMoneda.getContentPane().add(lblIngreseElValor);
		
		lbl_1 = new JLabel("$");
		lbl_1.setForeground(Color.RED);
		lbl_1.setFont(new Font("Consolas", Font.BOLD, 25));
		lbl_1.setBounds(212, 175, 166, 45);
		frmConversorDeMoneda.getContentPane().add(lbl_1);
	}
	
	//Funcionalidad boton convertir
	public void Convertir()
	{
		if(Validar(txt.getText())) {
			Moneda moneda = (Moneda) cmb.getSelectedItem();
			
			switch(moneda) {
			case dolar:
				PesosAMoneda(dolar);
				break;
			case euro:
				PesosAMoneda(euro);
				break;
			case libra:
				PesosAMoneda(libra);
				break;
			case real:
				PesosAMoneda(real);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value " + moneda);
			}
		}
	}
	public void PesosAMoneda(double moneda) {
		double res = valorInput/moneda;
		lbl.setText(Redondear(res));
		
	}
	
	public String Redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}
	
	public boolean Validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if(x>0);
			valorInput = x;
			return true;
		} catch(NumberFormatException e) {
			lbl.setText("Ingresa un valor");
			return false;
		}
	}
}



