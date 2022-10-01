package sptech.correcao01;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.constraints.br.TituloEleitoral;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Usuario {

    @NotBlank // valida se não é nulo, texto vazio ou texto só com espaços em branco
    @Size(min = 3) // valida um tamanho para o texto
    private String usuario;

    @NotBlank(message = "Onde já se viu nenhuma senha?!") // valida se não é nulo, texto vazio ou texto só com espaços em branco
    @Size(min = 3, max = 16) // valida um tamanho para o texto
    private String senha;

    // @NotBlank // ERRO COMUM! NotBlank é só para String. Obrigatório p/ os demais tipos é @NotNull
    @NotNull // do pacote javax.validation - valida se o campo está presente e não é null
    @Min(0) // valida se o valor é pelo menos 0
    // @DecimalMin("0.01") // para numeros reais (Double, Float, BigDecimal)
//    @Negative
//    @NegativeOrZero
//    @Positive
//    @PositiveOrZero
    private Integer filhos;

    @Past // indica que só serão aceitas data passadas (antes de hoje)
//    @PastOrPresent
//    @Future
//    @FutureOrPresent
    private LocalDate dataNascimento; // formato: "aaaa-mm-dd"

    private String nome;
    private boolean autenticado;

    // outros exemplos abaixo
    @Email
    private String email;

    @CPF
    private String cpf;

    @CNPJ
    private String cnpj;

    @TituloEleitoral
    private String tituloEleitor;

    /*
    9999-9999
    99999-9999
    11-9999-9999
    11-99999-9999
    (11)9999-9999
    (11)99999-9999
     */
    @Pattern( // valida usando uma Regex (expressão regular)
        regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})",
        message = "Indique um telefone válido"
    )
    private String telefone;

    public boolean autenticar(String usuario, String senha) {
        autenticado = usuario.equals(this.usuario) && senha.equals(this.senha);
        return autenticado;
    }

    public boolean isValido() {
        return usuario!=null && usuario.length() >= 3
                && senha!=null && senha.length() >= 3;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public Integer getFilhos() {
        return filhos;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }
}
