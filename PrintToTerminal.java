// ----- Uso isto para fazer todo o tipo de prints no terminal.
public class PrintToTerminal
{
    // ----- ISTO NÃO É A FORMA CORRETA DE SE FAZER NÃO TIVE TEMPO PARA CORRIGIR.
    void PrintToTerminal(String a)
    {
        String str_temp_1 = "", str_temp_2 = "";

        if(a.equals("conta")) // ----- Pergunta da conta.
        {
            str_temp_1 = "\n   ┌  (somar       ->  1 + 9)"
                       + "\n   │  (subtrair    ->  1 - 9)"
                       + "\n   │  (dividir     ->  1 / 9)"
                       + "\n   │  (multiplicar ->  1 * 9)"
                       + "\n   └";

            str_temp_2 = " Escreve a tua conta aqui:  ";

            System.out.print( TEXT_BLUE
                            + str_temp_1
                            + TEXT_DEFAULT
                            + str_temp_2
                            + TEXT_YELLOW);
            
            return; // ----- É preciso isto para manter o TEXT_YELLOW no input do utilizar.
        }
        else if(a.equals("repetir")) // ----- Pergunta final.
        {
            str_temp_1 = "\n\n   ┌  (exemplo:  Sim)"
                       + "\n   │  (exemplo:  Nao)"
                       + "\n   └";

            str_temp_2 = " Queres voltar a repetir?  ";

            System.out.print( TEXT_BLUE
                            + str_temp_1
                            + TEXT_DEFAULT
                            + str_temp_2
                            + TEXT_YELLOW);
            
            return; // ----- É preciso isto para manter o TEXT_YELLOW no input do utilizar.
        }
        else if(a.equals("titulo")) // ----- Título da calculadora.
        {
            // ----- https://manytools.org/hacker-tools/ascii-banner/
            System.out.print( TEXT_GREEN
                            + "  ,-.     .         .       .             \n"
                            + " /        |         |       |             \n"
                            + " |    ,-: | ,-. . . | ,-: ,-| ,-. ;-. ,-: \n"
                            + " |    | | | |   | | | | | | | | | |   | | \n"
                            + "  `-' `-´ ' `-' `-` ' `-´ `-' `-' '   `-´ \n\n");
        }
        else if(a.equals("encerrar")) // ----- Mensagem de encerramento da calculadora.
        {
            System.out.print( TEXT_GREENBOLD
                            + "\nEscolheste NÃO repetir."
                            + "\nA calculadora irá se auto-desligar em 10 segundos.");
        }
        else if(a.equals("consola")) // ----- Consola da calculadora.
        {
            String str_temp_a = "";
            String str_temp_b = "┌──[CONSOLA]─────────────────────────────┐\n";

            if(CalculadoraAlface.int_ConsoleMessage == 0)
            {
                str_temp_a += TEXT_GREEN;
                str_temp_a += str_temp_b;
                str_temp_a += "│  👍  Sem erros.                        │\n";
            }
            else if(CalculadoraAlface.int_ConsoleMessage == 1)
            {
                str_temp_a += TEXT_RED;
                str_temp_a += str_temp_b;
                str_temp_a += "│  ❌  Apenas são permitidos números.    │\n";
            }
            else if(CalculadoraAlface.int_ConsoleMessage == 2)
            {
                str_temp_a += TEXT_GREEN;
                str_temp_a += str_temp_b;
                str_temp_a += "│  🥗  Repetição com sucesso!            │\n";
            }
            else if(CalculadoraAlface.int_ConsoleMessage == 3)
            {
                str_temp_a += TEXT_GREEN;
                str_temp_a += str_temp_b;
                str_temp_a += "│  🏆  Cálculo feito com sucesso!        │\n";
            }
            else if(CalculadoraAlface.int_ConsoleMessage == 4)
            {
                str_temp_a += TEXT_RED;
                str_temp_a += str_temp_b;
                str_temp_a += "│  ❌  Apenas números de 0 a 9.          │\n";
            }
            else if(CalculadoraAlface.int_ConsoleMessage == 5)
            {
                str_temp_a += TEXT_YELLOW;
                str_temp_a += str_temp_b;
                str_temp_a += "│  🕒  A encerrar calculadora...         │\n";
            }
            else if(CalculadoraAlface.int_ConsoleMessage == 6)
            {
                str_temp_a += TEXT_RED;
                str_temp_a += str_temp_b;
                str_temp_a += "│  ❌  O operador é inválido.            │\n";
            }

            str_temp_a += "└────────────────────────────────────────┘\n";

            System.out.print(str_temp_a);
        }
        else if(a.equals("resultado")) // ----- Mostrar o resultado.
        {
            // ----- Strings para escolher os espaços do |.
            String str_temp;
            String str_tempSpace = "                    |";;

            // ----- Primeira parte.
            System.out.print( TEXT_GREEN
                            + "\n┌──[RESULTADO]───────────────────────────┐\n"
                            + "│      "
                            + TEXT_YELLOW
                            + CalculadoraAlface.int_InputValue_1
                            + "  "
                            + CalculadoraAlface.str_InputValue_2
                            + "  "
                            + CalculadoraAlface.int_InputValue_3
                            + "  =  ");
            
            // ----- Meter o resultado da conta na variável & fazer print da Segunda parte.
            int int_Result = 0;
            double double_ResultDiv = 0;

            if(CalculadoraAlface.str_InputValue_2.equals("+"))
            {
                int_Result = Calculate.intSum(CalculadoraAlface.int_InputValue_1, CalculadoraAlface.int_InputValue_3);
                System.out.print(int_Result);
            }
            else if(CalculadoraAlface.str_InputValue_2.equals("-"))
            {
                int_Result = Calculate.intSub(CalculadoraAlface.int_InputValue_1, CalculadoraAlface.int_InputValue_3);
                System.out.print(int_Result);
            }
            else if(CalculadoraAlface.str_InputValue_2.equals("/"))
            {
                double_ResultDiv = Calculate.intDiv(CalculadoraAlface.int_InputValue_1, CalculadoraAlface.int_InputValue_3);

                // ----- Para meter menos números décimais.
                // ----- https://stackoverflow.com/questions/8895337/how-do-i-limit-the-number-of-decimals-printed-for-a-double
                System.out.printf("%.2f", double_ResultDiv);
                str_tempSpace = "                 |";
                //System.out.print(double_ResultDiv);
            }
            else if(CalculadoraAlface.str_InputValue_2.equals("*"))
            {
                int_Result = Calculate.intMulti(CalculadoraAlface.int_InputValue_1, CalculadoraAlface.int_InputValue_3);
                System.out.print(int_Result);
            }
            // ----- Isto é para fazer com que o caracter │ fique corretamente posicionado (exceto no double).
            if(int_Result >= 0 && int_Result <= 9)
                str_temp = " ";
            else
                str_temp = "";

            // ----- Terceira parte.
            System.out.print( TEXT_GREEN
                            + str_temp
                            + str_tempSpace
                            + "\n└────────────────────────────────────────┘");
        }

        resetTextColors();
    }

    // ----- Para mudar as cores do texto nos prints do terminal.
    // ----- https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String TEXT_DEFAULT = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_GREENBOLD = "\033[1;32m";
    public static final String TEXT_YELLOW = "\033[0;33m";
    public static final String TEXT_RED = "\033[0;31m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static void resetTextColors() { System.out.print(TEXT_DEFAULT); } // ----- Convém usar isto sempre no final.
}