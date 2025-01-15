import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class EscalonadorSJF {

    private int quantMinProcessos = 2;
    private int quantMaxProcessos = 100;
    private int quantTotalProcessos;
    private List<Processo> processos;
    
    //construtor
    public EscalonadorSJF() {
        this.processos = new ArrayList<>();
    }
    
    public int getQuantMinProcessos() {
        return quantMinProcessos;
    }

    public int getQuantMaxProcessos() {
        return quantMaxProcessos;
    }
  
    public int getQuantTotalProcessos() {
        return quantTotalProcessos;
    }
  
    public void setQuantTotalProcessos(int quantTotalProcessos) {
        this.quantTotalProcessos = quantTotalProcessos;
    }

    public List<Processo> getProcessos() {
        return processos;
    }
  
    public void ordenarProcessos(){
        Random gerador = new Random();
        
        //O método nextInt(n) gera um número entre 0 e n-1
        //Aqui é add 1 para que o valor vá até o máximo 
        setQuantTotalProcessos(gerador.nextInt(getQuantMaxProcessos() - getQuantMinProcessos() + 1 + getQuantMinProcessos()));

        for(int i = 1; i <= getQuantTotalProcessos(); i++) {
            //processos.add(new Processo(getId(), getTempoChegada(), getTempoExecucao()));
            processos.add(new Processo(i, gerador.nextInt(10)+1, gerador.nextInt(10) + 1));
             
            //primeiro compara o tempo de execução e depois o tempo de chegada
            //não precisa colocar () ao fazer a chamaada dos métodos por causa da expressão lambda dentro do Comparator
            processos.sort(Comparator.comparingInt(Processo::getTempoExecucao).thenComparingInt(Processo::getTempoChegada));
  
    
            int tempoAtual = 0;
            for(Processo processoAtual : processos) {
                processoAtual.setTempoInicio(Math.max(processoAtual.getTempoChegada(), tempoAtual));
                
                processoAtual.setTempoInterrupcao(gerador.nextInt(4));
                
                processoAtual.setTempoConclusao(processoAtual.getTempoInicio() + processoAtual.getTempoExecucao() + processoAtual.getTempoInterrupcao());
                processoAtual.setTempoEspera(processoAtual.getTempoInicio() - processoAtual.getTempoChegada());
                processoAtual.setTempoTurnArround(processoAtual.getTempoConclusao() - processoAtual.getTempoChegada());
                    
                //garante que o atual só execute quando o anterior terminar
                tempoAtual = processoAtual.getTempoConclusao();

            }
        }
    }
    
}
