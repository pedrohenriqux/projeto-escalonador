public class Processo {

    private int id;
    private int tempoChegada;
    private int tempoExecucao;
    private int tempoConclusao;
    private int tempoEspera;
    private int tempoInicio;
    private int tempoTurnArround;
    private int tempoInterrupcao;
    
    public Processo(int id, int tempoChegada, int tempoExecucao) {
        this.id = id;
        this.tempoChegada = tempoChegada;
        this.tempoExecucao = tempoExecucao;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }
    public void setTempoChegada(int tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }
    public void setTempoExecucao(int tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public int getTempoConclusao() {
        return tempoConclusao;
    }
    public void setTempoConclusao(int tempoConclusao) {
        this.tempoConclusao = tempoConclusao;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }
    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public int getTempoInicio() {
        return tempoInicio;
    }
    public void setTempoInicio(int tempoInicio) {
        this.tempoInicio = tempoInicio;
    }

    public int getTempoTurnArround() {
        return tempoTurnArround;
    }
    public void setTempoTurnArround(int tempoTurnArround) {
        this.tempoTurnArround = tempoTurnArround;
    }
    
    public int getTempoInterrupcao(){
      return tempoInterrupcao;
    }
    public void setTempoInterrupcao(int tempoInterrupcao){
        this.tempoInterrupcao = tempoInterrupcao;
    }
    
}