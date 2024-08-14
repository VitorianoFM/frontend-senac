// Programa de adição que usa JOptionPane para entrada e saída.
import javax.swing.JOptionPane; // importa a biblioteca JOptionPane, uma classe que possibilita a criação de uma caixa de dialogo padrão que ou solicita um valor para o usuário ou retorna uma informação || "import biblioteca.módulo.componente;"

public class Addition // criado (declarado) a classe Addition (adição)
{
   public static void main(String[] args) // criado (declarado) o método executor main || "[]" = matriz
   {
      // obter entrada do usuário a partir de diálogos de entrada JOptionPane
      String firstNumber = // instância a classe String para receber o primeiro número || "=" é igual operador de atribuição
         JOptionPane.showInputDialog("Digite o primeiro número inteiro"); // exibe uma caixa com texto/parâmetro solicitando a entrada de dados pelo usuário em um campo de texto, e botões OK e Cancel
      String secondNumber = // instância a classe String para receber o segundo número || "=" é igual operador de atribuição
          JOptionPane.showInputDialog("Digite o segundo número inteiro"); // exibe uma caixa com texto/parâmetro solicitando a entrada de dados pelo usuário em um campo de texto, e botões OK e Cancel
      String thirdNumber = // instância a classe String para receber o terceiro número || "=" é igual operador de atribuição
          JOptionPane.showInputDialog("Digite o terceiro número inteiro"); // exibe uma caixa com texto/parâmetro solicitando a entrada de dados pelo usuário em um campo de texto, e botões OK e Cancel

      // converter entradas de String (texto) em valores int para uso no cálculo
      int number1 = Integer.parseInt(firstNumber); // converte a entrada da String firstNumber para uma variável tipo (número) inteiro number1 || "=" é igual operador de atribuição
      int number2 = Integer.parseInt(secondNumber); // converte a entrada da String secondNumber para uma variável tipo (número) inteiro number2 || "=" é igual operador de atribuição
      int number3 = Integer.parseInt(thirdNumber); // converte a entrada da String secondNumber para uma variável tipo (número) inteiro number3 || "=" é igual operador de atribuição

      int sum = number1 + number2 + number3; // realiza a soma dos dois números inteiros, somando o number1 + number2 + number3 resultando na variável sum

      // exibir resultado em uma caixa de diálogo de mensagem JOptionPane
      JOptionPane.showMessageDialog(null, "A soma é " + sum, // mostra o resultado da soma (sum) após a impressão do texto || o pacote showMessageDialog já converte a variável posterior quando é concatenado com uma String || "," = separador de parâmetro
         "Soma dos dois números inteiros", JOptionPane.PLAIN_MESSAGE); // imprime o titulo da janela com o texto
   } 
} // fim da classe Addition (adição)