package Front;

import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {

    private JTextField campoNome;
    private JTextField campoCPF;
    private JTextField campoEmail;
    private JPasswordField campoSenha;

    private JLabel nome;
    private JLabel cpf;
    private JLabel email;
    private JLabel senha;

    private JButton confirmar;

    public TelaCadastro(String titulo) {
        super(titulo);

        campoNome = new JTextField();
        campoCPF = new JTextField();
        campoEmail = new JTextField();
        campoSenha = new JPasswordField();

        nome = new JLabel("Nome:");
        cpf = new JLabel("CPF:");
        email = new JLabel("E-mail:");
        senha = new JLabel("Senha:");

        confirmar = new JButton("Confirmar");
    }

    public void mostrarTela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 300);

        setLayout(new GridLayout(2, 2));
        setSize(1000,1000);
        Container cp = getContentPane();
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(4, 4));
        panel.add(nome);
        panel.add(campoNome);
        panel.add(cpf);
        panel.add(campoCPF);
        panel.add(email);
        panel.add(campoEmail);
        panel.add(senha);
        panel.add(campoSenha);

        cp.add(panel);

        JPanel panelButton = new JPanel();
        panelButton.add(confirmar);

        cp.add(panelButton);

        pack();
        setVisible(true);
    }
}