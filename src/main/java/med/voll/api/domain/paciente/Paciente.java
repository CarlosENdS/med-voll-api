package med.voll.api.domain.paciente;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    
    public Paciente(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
        
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String cpf;

    @Embedded
    private Endereco endereco;

    private boolean ativo;


    public void atualizarInformacoes(DadosAtualizacaoPaciente dadosAtualizacaoPaciente) {
        this.nome = ( dadosAtualizacaoPaciente.nome() != null)? dadosAtualizacaoPaciente.nome(): this.nome;
        this.telefone = ( dadosAtualizacaoPaciente.telefone() != null)? dadosAtualizacaoPaciente.telefone(): this.telefone;
        if(dadosAtualizacaoPaciente.endereco() != null){
            this.endereco.atualizarInformacoes(dadosAtualizacaoPaciente.endereco());
        }
    }


    public void excluir() {
        this.ativo = false;
    }
    
}
