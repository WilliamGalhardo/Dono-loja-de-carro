
package pacotePI;

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

public abstract class Veiculo {
    
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private float preco;
    private int finalPlaca;
    
    public abstract String toString();
    

    public String getMarca() {
        return marca;
    }

   
    public void setMarca(String marca) {
        this.marca = marca;
    }

    
    public String getModelo() {
        return modelo;
    }

    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
    public String getCor() {
        return cor;
    }

    
    public void setCor(String cor) {
        this.cor = cor;
    }

    
    public int getAno() {
        return ano;
    }

    
    public void setAno(int ano) {
        this.ano = ano;
    }

   
    public float getPreco() {
        return preco;
    }

    
    public void setPreco(float preco) {
        this.preco = preco;
    }

    
    public int getFinalPlaca() {
        return finalPlaca;
    }

    
    public void setFinalPlaca(int finalPlaca) {
        this.finalPlaca = finalPlaca;
    }   
}