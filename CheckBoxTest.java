// Testando CheckBoxFrame.
import javax.swing.JFrame; // importação de bliblioteca.modulo.componente
// import javax.swing.*; // carrega todos os componentes do módulo swing da biblioteca javax || sugestão do professor para evitar o erro de não carregar algum componente do módulo

public class CheckBoxTest
{
   public static void main(String[] args)
   { 
      CheckBoxFrame checkBoxFrame = new CheckBoxFrame(); 
      checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      checkBoxFrame.setSize(285, 100); 
      checkBoxFrame.setVisible(true); 
   } 
} // fim da classe CheckBoxTest