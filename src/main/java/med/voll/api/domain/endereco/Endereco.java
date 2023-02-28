package med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();

    }

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public void atualizarInformacoes(DadosEndereco dadosEndereco) {
        this.logradouro = (dadosEndereco.logradouro() != null) ? dadosEndereco.logradouro() : this.logradouro;
        this.bairro = (dadosEndereco.bairro() != null) ? dadosEndereco.bairro() : this.bairro;
        this.cep = (dadosEndereco.cep() != null) ? dadosEndereco.cep() : this.cep;
        this.numero = (dadosEndereco.numero() != null) ? dadosEndereco.numero() : this.numero;
        this.complemento = (dadosEndereco.complemento() != null) ? dadosEndereco.complemento() : this.complemento;
        this.cidade = (dadosEndereco.cidade() != null) ? dadosEndereco.cidade() : this.cidade;
        this.uf = (dadosEndereco.uf() != null) ? dadosEndereco.uf() : this.uf;
    }
}
