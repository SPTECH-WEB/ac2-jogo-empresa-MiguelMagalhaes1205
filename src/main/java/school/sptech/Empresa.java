package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.JogoInvalidoException;
import school.sptech.exception.JogoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Objects;

public class Empresa {

    private String nome;
    private List<Jogo> jogos;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public Empresa(){
        this.jogos = new ArrayList<>();
    }

    public void adicionarJogo(Jogo jogo) throws JogoInvalidoException {

        if (jogo == null){
            throw new JogoInvalidoException("Jogo não pode ser nulo.");
        }

        if (jogo.getCodigo() == null || jogo.getCodigo().isEmpty()){
            throw new JogoInvalidoException("Código do jogo não pode ser nulo.");
        }

        if (jogo.getNome() == null || jogo.getNome().isEmpty()){
            throw new JogoInvalidoException("O nome do jogo não pode ser nulo.");
        }

        if (jogo.getGenero() == null || jogo.getGenero().isEmpty()){
            throw new JogoInvalidoException("O gênero do jogo não pode ser nulo.");
        }

        if (jogo.getPreco() == null || jogo.getPreco() <= 0.0){
            throw new JogoInvalidoException("O preço do jogo não pode ser nulo ou negativo.");
        }

        if (jogo.getAvaliacao() < 0.0 || jogo.getAvaliacao() > 5.0){
            throw new JogoInvalidoException("A avaliação do jogo deve estar entre 0 e 5.");
        }

        if (jogo.getDataLancamento() == null || jogo.getDataLancamento().isAfter(LocalDate.now())){
            throw new JogoInvalidoException("A data não pode ser nula ou estar no futuro.");
        }

        jogos.add(jogo);

    }

    public Jogo buscarJogoPorCodigo(String codigo) throws ArgumentoInvalidoException, JogoNaoEncontradoException{

        if (codigo == null || codigo.isEmpty() || codigo.isBlank()){
            throw new ArgumentoInvalidoException("Codigo invalido.");
        }

        Jogo codigoEncontrado = null;

        for (Jogo jogo : jogos){
            if (jogo.getCodigo().equalsIgnoreCase(codigo)){
                codigoEncontrado = jogo;
                break;
            }
        }

        if (codigoEncontrado == null){
           throw new JogoNaoEncontradoException("Jogo não encontrado.");
        }

        return codigoEncontrado;
    }

    public void removerJogoPorCodigo(String codigo) throws ArgumentoInvalidoException, JogoNaoEncontradoException{

        if (codigo == null || codigo.isBlank() || codigo.isEmpty()){
            throw new ArgumentoInvalidoException("Codigo invalido.");
        }


        Jogo jogoEncontrado = null;

        for (Jogo jogo : jogos){
            if (jogo.getCodigo().equalsIgnoreCase(codigo)){
                jogoEncontrado = jogo;
                break;
            }
        }

        if (jogoEncontrado == null){
            throw new JogoNaoEncontradoException("Jogo não encontrado.");
        }

        jogos.remove(jogoEncontrado);
    }

    public Jogo buscarJogoComMelhorAvaliacao() throws JogoNaoEncontradoException{

        Jogo melhorJogo = null;

        for (Jogo jogo : jogos){

            if (melhorJogo == null){
                melhorJogo = jogo;
            }

            if (Objects.equals(jogo.getAvaliacao(), melhorJogo.getAvaliacao())){
                if (jogo.getDataLancamento().isAfter(melhorJogo.getDataLancamento())){
                    melhorJogo = jogo;
                }
            }

            if (jogo.getAvaliacao() > melhorJogo.getAvaliacao()){
                melhorJogo = jogo;
            }

        }

        if (jogos.isEmpty()){
            throw new JogoNaoEncontradoException("A lista de jogos está vazia");
        }

        return melhorJogo;
    }

    public List<Jogo> buscarJogoPorPeriodo(LocalDate dataInicio, LocalDate dataFim) throws ArgumentoInvalidoException{

        if (dataInicio == null || dataFim == null){
            throw new ArgumentoInvalidoException("Data de inicio ou fim estão nulas.");
        }

        if (dataInicio.isAfter(dataFim)){
            throw new ArgumentoInvalidoException("A data de inicio não pode ser depois do fim.");
        }

        List<Jogo> jogosEncontrados = new ArrayList<>();

        for (Jogo jogo : jogos){
            if (jogo.getDataLancamento().isAfter(dataInicio) && jogo.getDataLancamento().isBefore(dataFim)){
                jogosEncontrados.add(jogo);
            }
        }

        return jogosEncontrados;
    }
}
