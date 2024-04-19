package crear_cuenta;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Crear_Cuenta {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Crear cuenta");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1));

        JLabel titleLabel = new JLabel("Crear una nueva cuenta", SwingConstants.CENTER);
        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField(20);
        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField(15);
        JLabel emailLabel = new JLabel("Correo:");
        JTextField emailField = new JTextField(20);
        JButton createButton = new JButton("Crear cuenta");

        panel.add(titleLabel);
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(createButton);

        frame.add(panel);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = userField.getText();
                String password = new String(passField.getPassword());
                String email = emailField.getText();

                if (username.length() > 20) {
                    JOptionPane.showMessageDialog(frame, "El nombre de usuario debe tener como máximo 20 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*\\d.*") || !password.matches(".*[^A-Za-z0-9].*")) {
                    JOptionPane.showMessageDialog(frame, "La contraseña debe tener minimo 8 caracteres, 1 mayúscula, 1 número y 1 carácter especial.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!email.contains("@")) {
                    JOptionPane.showMessageDialog(frame, "El correo debe contener el carácter '@'.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Cuenta creada exitosamente.");
                }
            }
        });

        frame.setVisible(true);
    }
}
    
