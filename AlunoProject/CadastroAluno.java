import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroAluno extends JFrame {
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtEndereco;
    private JButton btnOk;
    private JButton btnLimpar;
    private JButton btnMostrar;
    private JButton btnSair;
    private List<Aluno> listaAlunos;

    public CadastroAluno() {
        setTitle("Cadastro do Aluno");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        listaAlunos = new ArrayList<>();

        JLabel lblNome = new JLabel("Nome:");
        JLabel lblIdade = new JLabel("Idade:");
        JLabel lblEndereco = new JLabel("Endereco:");

        txtNome = new JTextField(20);
        txtIdade = new JTextField(20);
        txtEndereco = new JTextField(20);

        btnOk = new JButton("OK");
        btnLimpar = new JButton("Limpar");
        btnMostrar = new JButton("Mostrar");
        btnSair = new JButton("Sair");

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(3, 2, 10, 10));  // 3 linhas, 2 colunas, hgap e vgap de 10px

        panelSuperior.add(lblNome);
        panelSuperior.add(txtNome);
        panelSuperior.add(lblIdade);
        panelSuperior.add(txtIdade);
        panelSuperior.add(lblEndereco);
        panelSuperior.add(txtEndereco);

        // Adicionando o painel superior ao layout da janela
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(panelSuperior, gbc);

        // Linha 4 - Botões
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new GridLayout(1, 1, 10, 10));

        panelBotoes.add(btnOk);
        panelBotoes.add(btnLimpar);
        panelBotoes.add(btnMostrar);
        panelBotoes.add(btnSair);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(panelBotoes, gbc);

        // Ações dos botões
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarAluno();
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAlunos();
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sairAplicacao();
            }
        });
    }

    private void cadastrarAluno() {
        String nome = txtNome.getText().trim();
        String endereco = txtEndereco.getText().trim();
        int idade;

        try {
            idade = Integer.parseInt(txtIdade.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Idade deve ser um número.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(nome.isEmpty() || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Aluno aluno = new Aluno(nome, idade, endereco);
        listaAlunos.add(aluno);
        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        limparCampos();
    }

    private void limparCampos() {
        txtNome.setText("");
        txtIdade.setText("");
        txtEndereco.setText("");
    }

    private void mostrarAlunos() {
        if(listaAlunos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum aluno cadastrado.", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(Aluno aluno : listaAlunos) {
            sb.append(aluno.toString()).append("\n");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(350, 200));

        JOptionPane.showMessageDialog(this, scrollPane, "Lista de Alunos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void sairAplicacao() {
        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja sair?", "Confirmar Saída", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroAluno().setVisible(true);
            }
        });
    }
}
