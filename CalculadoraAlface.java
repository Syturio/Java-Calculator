/*
*   TIAGO ALFACE
*   16/02/2021
*/

import java.util.Scanner; // ----- Para poder utilizar o 'Scanner'.
import java.util.Arrays; // ----- Para poder utilizar o 'Arrays.asList'.

public class CalculadoraAlface
{
    // ----- Variáveis "globais".
    public static int int_ConsoleMessage = 0;
    public static int int_InputValue_1 = 10;
    public static String str_InputValue_2 = "";
    public static int int_InputValue_3 = 10;

    public static void main(String[] args)
    {
        PrintToTerminal ObjectPrintToTerminal = new PrintToTerminal();

        ClearTerminal(); // ----- Fazer clear ao terminal.
        ObjectPrintToTerminal.PrintToTerminal("titulo"); // ----- Título da calculadora.
        ObjectPrintToTerminal.PrintToTerminal("consola"); // ----- Consola da calculadora.
        ObjectPrintToTerminal.PrintToTerminal("conta"); // ----- Pergunta da conta.

        String[] str_Restart = null; // ----- Para no final dar para dar restart à calculadora.

        // ----- Não sei porquê dá erro no .close() e então tenho de meter o scanner dentro de um try.
        try(Scanner scanner_1 = new Scanner(System.in))
        {
            // ----- Para impedir que se meta letras no 1º input.
            if(!scanner_1.hasNextInt())
            {
                CalculadoraAlface.int_ConsoleMessage = 1;
                main(str_Restart);
                return;
            }

            int_InputValue_1 = scanner_1.nextInt();

            // ----- Para impedir valores negativos, ou superiores a 9.
            if(!(int_InputValue_1 >= 0 && int_InputValue_1 <= 9))
            {
                CalculadoraAlface.int_ConsoleMessage = 4;
                main(str_Restart);
                return;
            }

            ClearTerminal(); // ----- Fazer clear ao terminal.
            ObjectPrintToTerminal.PrintToTerminal("titulo"); // ----- Título da calculadora.
            ObjectPrintToTerminal.PrintToTerminal("consola"); // ----- Consola da calculadora.

            str_InputValue_2 = scanner_1.next();

            // ----- Para impedir que se meta outros caracteres para além dos operadores.
            if(!(Arrays.asList("+", "-", "/", "*").contains(str_InputValue_2)))
            {
                CalculadoraAlface.int_ConsoleMessage = 6;
                main(str_Restart);
                return;
            }

            // ----- Para impedir que se meta letras no 3º input.
            if(!scanner_1.hasNextInt())
            {
                CalculadoraAlface.int_ConsoleMessage = 1;
                main(str_Restart);
                return;
            }

            int_InputValue_3 = scanner_1.nextInt();

            // ----- Para impedir valores negativos, ou superiores a 9.
            if(!(int_InputValue_3 >= 0 && int_InputValue_3 <= 9))
            {
                CalculadoraAlface.int_ConsoleMessage = 4;
                main(str_Restart);
                return;
            }

            ClearTerminal(); // ----- Fazer clear ao terminal.
            ObjectPrintToTerminal.PrintToTerminal("titulo"); // ----- Título da calculadora.
            CalculadoraAlface.int_ConsoleMessage = 3;
            ObjectPrintToTerminal.PrintToTerminal("consola"); // ----- Consola da calculadora.

            ObjectPrintToTerminal.PrintToTerminal("resultado"); // ----- Mostrar o resultado.
            ObjectPrintToTerminal.PrintToTerminal("repetir"); // ----- Pergunta final.

            String str_InputValue_4 = scanner_1.next();

            if(str_InputValue_4.equals("Sim")
            || str_InputValue_4.equals("sim")
            || str_InputValue_4.equals("S")
            || str_InputValue_4.equals("s"))
            {
                CalculadoraAlface.int_ConsoleMessage = 2;
                main(str_Restart);
                return;
            }
            else
            {
                CalculadoraAlface.int_ConsoleMessage = 5;

                ClearTerminal(); // ----- Fazer clear ao terminal.
                ObjectPrintToTerminal.PrintToTerminal("titulo"); // ----- Título da calculadora.
                ObjectPrintToTerminal.PrintToTerminal("consola"); // ----- Consola da calculadora.
                ObjectPrintToTerminal.PrintToTerminal("encerrar"); // ----- Mensagem de encerramento da calculadora.
                
                SetTask CloseCalculator = new SetTask(10); // ----- Desliga o programa ao fim de 10 segundos.
            }
        }

        System.out.print("\n\n\n"); // ----- Meter um espaço no final do output do terminal.
        ObjectPrintToTerminal.PrintToTerminal(""); // ----- Retornar as cores default do terminal.
    }

    // ----- Isto serve para limpar o terminal.
    // ----- http://techno-terminal.blogspot.com/2014/12/clear-command-line-console-and-bold.html
    public static void ClearTerminal()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}