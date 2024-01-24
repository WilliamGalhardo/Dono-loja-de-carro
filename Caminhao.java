
package pacotePI;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *  Responsaveis pelo desenvolvimento
 * 
 * @authors William Ferreira Galhardo - RGM:2938
 *  Breno Botelho - RGM 31638856
 *  Vinicius paz - RGM 31846513
 *  Davi - RGM 531865101
 *  Leo - RGM 530115299
 *  Kamila - RGM 31391770
 */
public class Caminhao extends Veiculo{
    
    static String padrao = "###,###.##";
    static DecimalFormat df = new DecimalFormat(padrao);
 
    public Caminhao(){
    }
    
    
    
    public void cadastraVCaminhao(){        
        String marca = JOptionPane.showInputDialog("Sistema Stars Concessionaria\n\n" + "Qual a marca do veiculo ?");
        String modelo = JOptionPane.showInputDialog("Sistema Stars Concessionaria\n\n" + "Qual o modelo do veiculo ?");
        String cor = JOptionPane.showInputDialog("Sistema Stars Concessionaria\n\n" + "Qual a cor do veiculo ?");
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Sistema Stars Concessionaria\n\n" + "Qual o ano do veiculo ?"));
        float preco = Float.parseFloat(JOptionPane.showInputDialog("Sistema Stars Concessionaria\n\n" + "Insira o valor de venda do veiculo"));
        int finalPlaca = Integer.parseInt(JOptionPane.showInputDialog("Sistema Stars Concessionaria\n\n" + "Insira o digito final da placa do veiculo"));
        
        setMarca(marca);
        setModelo(modelo);
        setCor(cor);
        setAno(ano);
        setPreco(preco);
        setFinalPlaca(finalPlaca);
    }
    
    
    @Override
    public String toString(){
        
        return "\n"+"Marca: "+ getMarca() + "\n" 
                +"Modelo: " +getModelo()+"\n"
                +"Ano: "+getAno()+"\n"
                +"Cor: "+getCor()+"\n"
                +"Preço: R$ "+ df.format(getPreco())+"\n"
                +"Digito final da placa: "+getFinalPlaca() + "\n\n";
    }
}
