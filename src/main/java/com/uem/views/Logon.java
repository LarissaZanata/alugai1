package com.uem.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

@SpringBootApplication	
public class Logon extends JFrame{
	
	@Autowired
	public JFrame frmAluga;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args){
		 ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Logon.class)
		            .headless(false).run(args);
		
		EventQueue.invokeLater(() -> {
		        Logon ex = ctx.getBean(Logon.class);
		        ex.initialize();
		        ex.frmAluga.setVisible(true);
		    });
		 
		
	}

	/**
	 * Create the application.
	 */
	public Logon() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAluga = new JFrame();
		frmAluga.setTitle("Alugaí 1.0");
		frmAluga.setBounds(100, 100, 800, 500);
		frmAluga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAluga.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblLogin.setBounds(234, 160, 46, 14);
		frmAluga.getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblSenha.setBounds(234, 210, 46, 14);
		frmAluga.getContentPane().add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(290, 157, 219, 20);
		frmAluga.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(textField.getText().equals("admin") && passwordField.getText().equals("admin1")) {
					JOptionPane.showMessageDialog(null, "Bem vindo à locadora!");
					Alugai window1 = new Alugai();
					window1.frame.setVisible(true);
					frmAluga.setVisible(false);						
				}
				else {
					JOptionPane.showMessageDialog(null, "Dados inválidos!");
				}
			}
		});
		btnEntrar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnEntrar.setBounds(434, 264, 75, 23);
		frmAluga.getContentPane().add(btnEntrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(290, 208, 219, 20);
		frmAluga.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Ajuda");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Login: digite seu login\nSenha: digite sua senha");
			}
		});
		btnNewButton.setBounds(679, 11, 75, 20);
		frmAluga.getContentPane().add(btnNewButton);
	}

}
