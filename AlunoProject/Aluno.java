import java.util.UUID;
//Eduardo Miranda e Cauã Barros

public class Aluno {
    private String nome;
    private int idade;
    private String endereco;
    private UUID uuid;

    public Aluno(String nome, int idade, String endereco) {
        this.uuid = UUID.randomUUID();
        this.nome = nome ;
        this.idade = idade;
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "ID='" + uuid +
                ", Nome='" + nome + '\'' +
                ", Idade='" + idade + '\'' +
                ", Endereço='" + endereco + '\'' +
                '}';
    }
}
