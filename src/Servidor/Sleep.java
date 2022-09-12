package Servidor;

public class Sleep implements IComando {
    
	private String delayTime;
	
	public Sleep(String delayTime) {
        this.delayTime = delayTime;
    }
	
	@Override
    public void execute() {
        int delay = this.getDelayTime();
        System.out.println("Iniciando execução do comando Sleep com " + delay);
        try {
			Thread.sleep(this.getDelayTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println("Finalizado execução do comando Sleep com " + delay);
    }

    private int getDelayTime() {
        try {
            return Integer.parseInt(delayTime);
        } catch (RuntimeException e) {
            throw new RuntimeException("Comando sleep deve especificar um tempo de delay");
        }
    }

}
