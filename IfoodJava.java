package com.mycompany.ifoodd.java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IfooddJava {

    // Variáveis globais para armazenar os usuários cadastrados
    private static Cliente clienteCadastrado;
    private static DonoRestaurante donoCadastrado;

    public static void main(String[] args) {
        // Tela de login inicial
        mostrarTelaLogin();
    }

    // Tela de Login
    public static void mostrarTelaLogin() {
        JFrame frameLogin = new JFrame("Login - iFood");
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setSize(400, 300);

        JPanel panelLogin = new JPanel();
        panelLogin.setLayout(new GridLayout(4, 1, 10, 10));
        panelLogin.setBackground(Color.RED);
        panelLogin.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblUsuario = new JLabel("E-mail:");
        JTextField txtUsuario = new JTextField();

        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField();

        JButton btnEntrar = new JButton("Entrar");
        JButton btnCadastrar = new JButton("Cadastrar");

        panelLogin.add(lblUsuario);
        panelLogin.add(txtUsuario);
        panelLogin.add(lblSenha);
        panelLogin.add(txtSenha);

        JPanel panelButtons = new JPanel();
        panelButtons.add(btnEntrar);
        panelButtons.add(btnCadastrar);

        frameLogin.add(panelLogin, BorderLayout.CENTER);
        frameLogin.add(panelButtons, BorderLayout.SOUTH);

        // Ação do botão "Entrar"
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtUsuario.getText();
                String senha = new String(txtSenha.getPassword());

                if (clienteCadastrado != null && clienteCadastrado.getEmail().equals(email) && clienteCadastrado.getSenha().equals(senha)) {
                    JOptionPane.showMessageDialog(frameLogin, 
                        "Login realizado com sucesso! Bem-vindo, Cliente!", 
                        "Login", 
                        JOptionPane.INFORMATION_MESSAGE);
                    frameLogin.dispose();
                    mostrarTelaVisualizacaoRestaurantes();
                } else if (donoCadastrado != null && donoCadastrado.getEmail().equals(email) && donoCadastrado.getSenha().equals(senha)) {
                    JOptionPane.showMessageDialog(frameLogin, 
                        "Login realizado com sucesso! Bem-vindo, Dono de Restaurante!", 
                        "Login", 
                        JOptionPane.INFORMATION_MESSAGE);
                    frameLogin.dispose();
                    mostrarTelaCadastroRestaurante();
                } else {
                    JOptionPane.showMessageDialog(frameLogin, 
                        "E-mail ou senha inválidos.", 
                        "Erro", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ação do botão "Cadastrar"
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameLogin.dispose(); // Fecha a tela de login
                mostrarTelaCadastro(); // Abre a tela de cadastro
            }
        });

        frameLogin.setVisible(true);
    }

    // Tela de Cadastro
    public static void mostrarTelaCadastro() {
        JFrame frameCadastro = new JFrame("Cadastro de Usuário - iFood");
        frameCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCadastro.setSize(400, 600);

        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(new GridLayout(9, 2, 10, 10));
        panelCadastro.setBackground(Color.RED);
        panelCadastro.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();

        JLabel lblEmail = new JLabel("E-mail:");
        JTextField txtEmail = new JTextField();

        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField();

        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField();

        JLabel lblEndereco = new JLabel("Endereço:");
        JTextField txtEndereco = new JTextField();

        JLabel lblCidade = new JLabel("Cidade:");
        JTextField txtCidade = new JTextField();

        JLabel lblEstado = new JLabel("Estado:");
        JTextField txtEstado = new JTextField();

        JLabel lblTipoUsuario = new JLabel("Tipo de Usuário:");
        String[] tiposUsuario = {"Cliente", "Dono de Restaurante"};
        JComboBox<String> comboTipoUsuario = new JComboBox<>(tiposUsuario);

        JButton btnCadastrar = new JButton("Cadastrar");

        panelCadastro.add(lblNome);
        panelCadastro.add(txtNome);

        panelCadastro.add(lblEmail);
        panelCadastro.add(txtEmail);

        panelCadastro.add(lblSenha);
        panelCadastro.add(txtSenha);

        panelCadastro.add(lblTelefone);
        panelCadastro.add(txtTelefone);

        panelCadastro.add(lblEndereco);
        panelCadastro.add(txtEndereco);

        panelCadastro.add(lblCidade);
        panelCadastro.add(txtCidade);

        panelCadastro.add(lblEstado);
        panelCadastro.add(txtEstado);

        panelCadastro.add(lblTipoUsuario);
        panelCadastro.add(comboTipoUsuario);

        JPanel panelButton = new JPanel();
        panelButton.add(btnCadastrar);

        frameCadastro.add(panelCadastro, BorderLayout.CENTER);
        frameCadastro.add(panelButton, BorderLayout.SOUTH);

        // Ação do botão "Cadastrar"
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String email = txtEmail.getText();
                String senha = new String(txtSenha.getPassword());
                String tipoUsuario = (String) comboTipoUsuario.getSelectedItem();

                if (tipoUsuario.equals("Cliente")) {
                    clienteCadastrado = new Cliente(1, nome, email, senha);
                    JOptionPane.showMessageDialog(frameCadastro, 
                        "Cadastro realizado com sucesso!\n" +
                        "Bem-vindo, Cliente " + nome + "!", 
                        "Cadastro", 
                        JOptionPane.INFORMATION_MESSAGE);
                } else if (tipoUsuario.equals("Dono de Restaurante")) {
                    donoCadastrado = new DonoRestaurante(1, nome, email, senha);
                    JOptionPane.showMessageDialog(frameCadastro, 
                        "Cadastro realizado com sucesso!\n" +
                        "Bem-vindo, Dono de Restaurante " + nome + "!", 
                        "Cadastro", 
                        JOptionPane.INFORMATION_MESSAGE);
                }

                frameCadastro.dispose(); // Fecha a tela de cadastro
                mostrarTelaLogin(); // Retorna à tela de login
            }
        });

        frameCadastro.setVisible(true);
    }

    // Tela de Visualização de Restaurantes
    public static void mostrarTelaVisualizacaoRestaurantes() {
        JFrame frameRestaurantes = new JFrame("Restaurantes Disponíveis");
        frameRestaurantes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRestaurantes.setSize(400, 300);

        JLabel lblMensagem = new JLabel("Lista de Restaurantes", SwingConstants.CENTER);
        frameRestaurantes.add(lblMensagem);

        frameRestaurantes.setVisible(true);
    }

    // Tela de Cadastro de Restaurante
    public static void mostrarTelaCadastroRestaurante() {
        JFrame frameCadastroRestaurante = new JFrame("Cadastro de Restaurante");
        frameCadastroRestaurante.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCadastroRestaurante.setSize(400, 300);

        JLabel lblMensagem = new JLabel("Cadastro de Novo Restaurante", SwingConstants.CENTER);
        frameCadastroRestaurante.add(lblMensagem);

        frameCadastroRestaurante.setVisible(true);
    }
    
}
