// ----- Isto serve para executar código ao fim de X segundos.
// -----
// ----- Uso isto no final da calculadora, quando ela pergunta se o utilizador
// ----- quer continuar a fazer contas, caso escreva 'Nao' este código 
// ----- executa o 'ClearTerminal.java' ao fim de 10 segundos.
// -----
// ----- https://www.iitk.ac.in/esc101/05Aug/tutorial/essential/threads/timer.html

import java.util.Timer;
import java.util.TimerTask;

public class SetTask
{
    Timer timer;

    public SetTask(int seconds)
    {
        timer = new Timer();
        timer.schedule(new ExecTask(), seconds*1000);
	}

    class ExecTask extends TimerTask
    {
        public void run()
        {
            // ----- Limpar o terminal.
            CalculadoraAlface.ClearTerminal();

            timer.cancel();
        }
    }
}