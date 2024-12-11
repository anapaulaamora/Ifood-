package com.mycompany.ifoodd.java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class IfooddJava {

   
    private static Cliente clienteCadastrado;
    private static DonoRestaurante donoCadastrado;
    private static List<Restaurante> restaurantesCadastrados = new ArrayList<>();

    public static void main(String[] args) {
        mostrarTelaLogin();
    }


    public static void mostrarTelaLogin() {
        JFrame frameLogin = new JFrame("LOGIN - JAMP IFOOD!!");
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setSize(600, 400);

        JPanel panelLogin = new JPanel();
        panelLogin.setLayout(new GridLayout(4, 1, 10, 10));
        panelLogin.setBackground(Color.RED);
        panelLogin.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblUsuario = new JLabel("E-MAIL:");
        JTextField txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 18)); 

        JLabel lblSenha = new JLabel("SENHA:");
        JPasswordField txtSenha = new JPasswordField();
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 18)); 

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

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameLogin.dispose(); 
                mostrarTelaCadastro(); 
            }
        });

        frameLogin.setVisible(true);
    }

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
        JButton btnVoltar = new JButton("Voltar");

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
        panelButton.add(btnVoltar);

        frameCadastro.add(panelCadastro, BorderLayout.CENTER);
        frameCadastro.add(panelButton, BorderLayout.SOUTH);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String email = txtEmail.getText();
                String senha = new String(txtSenha.getPassword());
                String telefone = txtTelefone.getText();
                String endereco = txtEndereco.getText();
                String cidade = txtCidade.getText();
                String estado = txtEstado.getText();
                String tipoUsuario = (String) comboTipoUsuario.getSelectedItem();

                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || telefone.isEmpty() || endereco.isEmpty() || cidade.isEmpty() || estado.isEmpty()) {
                    JOptionPane.showMessageDialog(frameCadastro, 
                        "Por favor, preencha todos os campos para realizar o cadastro.", 
                        "Erro de Cadastro", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!telefone.matches("\\d{11}")) {
                    JOptionPane.showMessageDialog(frameCadastro, 
                        "O número de telefone deve conter exatamente 11 dígitos.", 
                        "Erro de Cadastro", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
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

                frameCadastro.dispose(); 
                mostrarTelaLogin();
            }
        });

     
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCadastro.dispose();
                mostrarTelaLogin();
            }
        });

        frameCadastro.setVisible(true);
    }

    public static void mostrarTelaCadastroRestaurante() {
        JFrame frameCadastroRestaurante = new JFrame("Cadastro de Restaurante");
        frameCadastroRestaurante.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCadastroRestaurante.setSize(500, 500);

        JPanel panelCadastro = new JPanel(new GridLayout(3, 2, 10, 10));
        panelCadastro.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblNomeRestaurante = new JLabel("Nome do Restaurante:");
        JTextField txtNomeRestaurante = new JTextField();

        JLabel lblEnderecoRestaurante = new JLabel("Endereço do Restaurante:");
        JTextField txtEnderecoRestaurante = new JTextField();

        JButton btnCadastrarRestaurante = new JButton("Cadastrar");
        JButton btnVoltar = new JButton("Voltar");

        panelCadastro.add(lblNomeRestaurante);
        panelCadastro.add(txtNomeRestaurante);

        panelCadastro.add(lblEnderecoRestaurante);
        panelCadastro.add(txtEnderecoRestaurante);

        panelCadastro.add(btnCadastrarRestaurante);
        panelCadastro.add(btnVoltar);

        frameCadastroRestaurante.add(panelCadastro);

        btnCadastrarRestaurante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNomeRestaurante.getText();
                String endereco = txtEnderecoRestaurante.getText();

                if (!nome.isEmpty() && !endereco.isEmpty()) {
                    restaurantesCadastrados.add(new Restaurante(nome, endereco));
                    JOptionPane.showMessageDialog(frameCadastroRestaurante, 
                        "Restaurante cadastrado com sucesso!", 
                        "Cadastro", 
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frameCadastroRestaurante, 
                        "Por favor, preencha todos os campos.", 
                        "Erro", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCadastroRestaurante.dispose();
                mostrarTelaLogin();
            }
        });

        frameCadastroRestaurante.setVisible(true);
    }


    public static void mostrarTelaVisualizacaoRestaurantes() {
        JFrame frameRestaurantes = new JFrame("Restaurantes Disponíveis");
        frameRestaurantes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRestaurantes.setSize(400, 400);

        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        StringBuilder listaRestaurantes = new StringBuilder("Restaurantes cadastrados:\n\n");
        for (Restaurante restaurante : restaurantesCadastrados) {
            listaRestaurantes.append("- ").append(restaurante.getNome()).append(", ").append(restaurante.getEndereco()).append("\n");
        }

        textArea.setText(listaRestaurantes.toString());

        JButton btnVoltar = new JButton("Voltar");

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(btnVoltar, BorderLayout.SOUTH);

        frameRestaurantes.add(panel);

     
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameRestaurantes.dispose();
                mostrarTelaLogin();
            }
        });

        frameRestaurantes.setVisible(true);
    }
}
