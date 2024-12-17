import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class AppMain {

    public static void main(String args[]) {
        EscalonadorSJF sjf = new EscalonadorSJF();
        sjf.ordenarProcessos();
        List<Processo> processos = sjf.getProcessos();

        
        System.out.println
        //("ID - Chegada - Execução - Início - Interrupção - Conclusão - Espera - TurnArround;
        ("ID\tCh\tTExe\tIn\tInter\tCon\tEsp\tTnArr");
        int somaEspera = 0, somaTurnArround = 0;
        for(Processo processoAtual : processos) {
            System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\n", 
                processoAtual.getId(), 
                processoAtual.getTempoChegada(), 
                processoAtual.getTempoExecucao(),
                processoAtual.getTempoInicio(),
                processoAtual.getTempoInterrupcao(),
                processoAtual.getTempoConclusao(),
                processoAtual.getTempoEspera(),
                processoAtual.getTempoTurnArround());
            
            somaEspera += processoAtual.getTempoEspera();
            somaTurnArround += processoAtual.getTempoTurnArround();
        }
        
        System.out.printf("\n Tempo médio de espera: " +(double) somaEspera/processos.size());
        System.out.printf("\n Tempo médio de TurnArround: " +(double) somaTurnArround/processos.size());  
        System.out.println();
    }
    
}