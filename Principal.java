
package pacotePI;

import javax.swing.JOptionPane;
import java.util.ArrayList;

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

public class Principal {
    
    
    static ArrayList<Carro> listaDeCarros = new ArrayList<Carro>();
    static ArrayList<Moto> listaDeMotos = new ArrayList<Moto>();    
    static ArrayList<Caminhao> listaDeCaminhoes = new ArrayList<Caminhao>();
    
    
    private static final String menu = "Sistema Stars Concessionaria\n\n"
            + "1 --> Cadastrar Veiculo\n"
            + "2 --> Editar Veiculo\n"
            + "3 --> Excluir Veiculo\n"
            + "4 --> Exibição de Veiculos Cadastrados\n\n"
            + "5 --> Sair do Sistema\n";

    private static final String menuCadastroVeiculo = "Sistema Stars Concessionaria\n\n"
            + "1 --> Cadastrar Carro\n"
            + "2 --> Cadastrar Moto\n"
            + "3 --> Cadastar Caminhão\n\n"
            + "4 --> Voltar\n";
    
    private static final String selecaoExibicao = "Sistema Stars Concessionaria\n\n"
            +"Qual tipo de veiculo deve ser exibido ?\n\n"
            + "1 --> Carro\n"
            + "2 --> Moto\n"
            + "3 --> Caminhão\n\n"
            + "4 --> Voltar\n";
    
    private static final String menuDeletar ="Sistema Stars Concessionaria\n\n"
            + "Informe o tipo de veiculo a ser deletado\n\n"
            + "Atenção\n Você irá necessitar do codigo de cadastro do veiculo para a exclusão do mesmo\n\n"
            + "1 --> Deletar Carro\n"
            + "2 --> Deletar Moto\n"
            + "3 --> Deletar Caminhão\n\n"
            + "4 --> Voltar\n";
    
    private static final String menuAlterar = "Sistema Stars Concessionaria\n\n"
            + "Informe o tipo de veiculo a ser alterado\n\n"
            + "Atenção\n Você irá necessitar do codigo de cadastro do veiculo para a alteração do mesmo\n\n"
            + "1 --> Alterar Carro\n"
            + "2 --> Alterar Moto\n"
            + "3 --> Alterar Caminhão\n\n"
            + "4 --> Voltar\n";
    
    private static final String escolhaAlteracao= "Informe o que deseja alterar\n"
            + "1 --> Marca\n"
            + "2 --> Modelo\n"
            + "3 --> Cor\n"
            + "4 --> Ano\n"
            + "5 --> Preço\n"
            + "6 --> Final da Placa\n"
            + "7 --> Tudo\n"
            + "8 --> Cancelar\n";
    
    
    
    public static void main(String[] args) {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcao) {
                case 1:
                    menuVeiculo();
                    break;
                case 2:
                    alteraVeiculo();
                    break;
                case 3:
                    deletaVeiculo();
                    break;
                case 4:
                    listarVeiculos();
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Você deve escolher uma opção do menu!");
            }
        } while (opcao != 5);
        
    }
    


    private static void menuVeiculo() {
        int opcaoV;
        do{
            opcaoV = Integer.parseInt(JOptionPane.showInputDialog(menuCadastroVeiculo));
            switch (opcaoV) {
                case 1:
                    cadastraCarro();
                    break;
                case 2:
                    cadastraMoto();
                    break;
                case 3:
                    cadastraCaminhao();
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Você deve escolher uma opção do menu!");
            }   
        }while(opcaoV != 4);        
    }
    
    /**
        *Cadastro do veiculo tipo carro
     */
    
    private static void cadastraCarro() {
        
        Carro veiculo = new Carro();
        
        //Chamando metodo para cadastrar o objeto
        veiculo.cadastraVCarro();
        
        //Cadastro na arraylist
        listaDeCarros.add(veiculo);
        
        JOptionPane.showMessageDialog(null, "Sistema Stars Concessionaria\n\n" + "O veiculo " + veiculo.getMarca() +" "+ veiculo.getModelo() + " foi cadastrado corretamente!\n\n" +
                "O codigo de cadastro dele foi gerado e será exibido na listagem de veiculos ! \n");
        
    }
    
    /**
     *Cadastro do veiculo tipo moto
     */
    
    private static void cadastraMoto() {
        
        Moto veiculoM = new Moto();
        
        veiculoM.cadastraVMoto();
        
        listaDeMotos.add(veiculoM);                
        JOptionPane.showMessageDialog(null, "Sistema Stars Concessionaria\n\n" + "A motocicleta " + veiculoM.getModelo() + " foi cadastrada corretamente!");
    }
    
    /**
     *Cadastro do veiculo tipo caminhão
     */
    private static void cadastraCaminhao() {
          
        Caminhao veiculoC = new Caminhao();   
        
        veiculoC.cadastraVCaminhao();
        
        listaDeCaminhoes.add(veiculoC);        
        JOptionPane.showMessageDialog(null, "Sistema Stars Concessionaria\n\n" + "O caminhão " + veiculoC.getModelo() + " foi cadastrado corretamente!");
    }

    /**
     *Alteração dos atributos do veiculo cadastrado
     */
    
    private static void alteraVeiculo() {
        int opcaoA;
        do{
            opcaoA = Integer.parseInt(JOptionPane.showInputDialog(menuAlterar));
            switch(opcaoA){
                case 1:
                    if(listaDeCarros.isEmpty()){ //Tratamento de erro caso a lista esteja vazia
                        JOptionPane.showMessageDialog(null,"Não existem veiculos do tipo (carro) cadastrados para a alteração.");
                        break;
                    }else{
                        int index = Integer.parseInt(JOptionPane.showInputDialog("Sistema Stars Concessionaria\n\n" + "Insira o codigo de cadastro do veiculo que você deseja alterar" + 
                                "\n\nO codigo de cadastro é informado na exibição de veiculos.\n\n"));
                        int resp = Integer.parseInt(JOptionPane.showInputDialog("O veiculo a ser alterado é: \n"+ listaDeCarros.get(index).getMarca() + " " +listaDeCarros.get(index).getModelo() + "\n"
                        +"Deseja continuar ?" +"\n"
                        +"1 --> Sim\n"
                        +"2 --> Cancelar\n"));
                        switch(resp){
                        case 1:
                             int escolhaCarro;
                             escolhaCarro = Integer.parseInt(JOptionPane.showInputDialog(escolhaAlteracao));
                             switch(escolhaCarro){
                                 case 1:
                                    listaDeCarros.get(index).setMarca(JOptionPane.showInputDialog("Digite uma nova marca para a alteração"));
                                    JOptionPane.showMessageDialog(null,"A marca do veiculo foi alterado com sucesso");
                                    break;
                                 case 2:
                                     listaDeCarros.get(index).setModelo(JOptionPane.showInputDialog("Digite um novo modelo para a alteração"));
                                    JOptionPane.showMessageDialog(null,"O modelo do veiculo foi alterado com sucesso");
                                    break;
                                 case 3:
                                    listaDeCarros.get(index).setCor(JOptionPane.showInputDialog("Digite uma nova cor para a alteração"));
                                    JOptionPane.showMessageDialog(null,"A cor do veiculo foi alterado com sucesso");
                                    break;
                                 case 4:
                                     listaDeCarros.get(index).setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite um novo ano para a alteração")));
                                    JOptionPane.showMessageDialog(null,"O ano do veiculo foi alterado com sucesso");
                                    break;
                                 case 5:
                                    listaDeCarros.get(index).setPreco(Float.parseFloat(JOptionPane.showInputDialog("Digite um novo preço para a alteração")));
                                    JOptionPane.showMessageDialog(null,"O preço veiculo foi alterado com sucesso");
                                    break;
                                 case 6:
                                    listaDeCarros.get(index).setFinalPlaca(Integer.parseInt(JOptionPane.showInputDialog("Digite o final da placa para a alteração")));
                                    JOptionPane.showMessageDialog(null,"O final da placa do veiculo foi alterado com sucesso");
                                    break;
                                 case 7:
                                     listaDeCarros.get(index).setMarca(JOptionPane.showInputDialog("Digite uma nova marca para a alteração"));
                                     listaDeCarros.get(index).setModelo(JOptionPane.showInputDialog("Digite um novo modelo para a alteração"));
                                     listaDeCarros.get(index).setCor(JOptionPane.showInputDialog("Digite uma nova cor para a alteração"));
                                     listaDeCarros.get(index).setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite um novo ano para a alteração")));
                                     listaDeCarros.get(index).setPreco(Float.parseFloat(JOptionPane.showInputDialog("Digite um novo preço para a alteração")));
                                     listaDeCarros.get(index).setFinalPlaca(Integer.parseInt(JOptionPane.showInputDialog("Digite o final da placa para a alteração")));
                                     JOptionPane.showMessageDialog(null,"O veiculo foi completamente alterado com sucesso");
                                     break;
                                 case 8:
                                     break;
                             }
                            break;
                        case 2:
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Você deve escolher uma opção do menu!");
                        }
                        break;
                    }
                case 2:
                    if(listaDeMotos.isEmpty()){ //Tratamento de erro caso a lista esteja vazia
                        JOptionPane.showMessageDialog(null,"Não existem veiculos do tipo (moto) cadastrados para a alteração.");
                        break;
                    }else{
                        int index = Integer.parseInt(JOptionPane.showInputDialog("Sistema Stars Concessionaria\n\n" + "Insira o codigo de cadastro do veiculo que você deseja alterar" + 
                                "\nO codigo de cadastro é informado na exibição de veiculos.\n"));
                        int resp = Integer.parseInt(JOptionPane.showInputDialog("O veiculo a ser alterado é: \n"+ listaDeMotos.get(index).getMarca() +" "+ listaDeMotos.get(index).getModelo() + "\n"
                        +"Deseja continuar ?" +"\n"
                        +"1 --> Sim\n"
                        +"2 --> Cancelar\n"));
                        switch(resp){
                        case 1:
                            int escolhaMoto;
                            escolhaMoto = Integer.parseInt(JOptionPane.showInputDialog(escolhaAlteracao));
                            switch(escolhaMoto){
                                 case 1:
                                    listaDeMotos.get(index).setMarca(JOptionPane.showInputDialog("Digite uma nova marca para a alteração"));
                                    JOptionPane.showMessageDialog(null,"A marca do veiculo foi alterado com sucesso");
                                    break;
                                 case 2:
                                     listaDeMotos.get(index).setModelo(JOptionPane.showInputDialog("Digite um novo modelo para a alteração"));
                                    JOptionPane.showMessageDialog(null,"O modelo do veiculo foi alterado com sucesso");
                                    break;
                                 case 3:
                                    listaDeMotos.get(index).setCor(JOptionPane.showInputDialog("Digite uma nova cor para a alteração"));
                                    JOptionPane.showMessageDialog(null,"A cor do veiculo foi alterado com sucesso");
                                    break;
                                 case 4:
                                     listaDeMotos.get(index).setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite um novo ano para a alteração")));
                                    JOptionPane.showMessageDialog(null,"O ano do veiculo foi alterado com sucesso");
                                    break;
                                 case 5:
                                    listaDeMotos.get(index).setPreco(Float.parseFloat(JOptionPane.showInputDialog("Digite um novo preço para a alteração")));
                                    JOptionPane.showMessageDialog(null,"O preço veiculo foi alterado com sucesso");
                                    break;
                                 case 6:
                                    listaDeMotos.get(index).setFinalPlaca(Integer.parseInt(JOptionPane.showInputDialog("Digite o final da placa para a alteração")));
                                    JOptionPane.showMessageDialog(null,"O final da placa do veiculo foi alterado com sucesso");
                                    break;
                                 case 7:
                                     listaDeMotos.get(index).setMarca(JOptionPane.showInputDialog("Digite uma nova marca para a alteração"));
                                     listaDeMotos.get(index).setModelo(JOptionPane.showInputDialog("Digite um novo modelo para a alteração"));
                                     listaDeMotos.get(index).setCor(JOptionPane.showInputDialog("Digite uma nova cor para a alteração"));
                                     listaDeMotos.get(index).setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite um novo ano para a alteração")));
                                     listaDeMotos.get(index).setPreco(Float.parseFloat(JOptionPane.showInputDialog("Digite um novo preço para a alteração")));
                                     listaDeMotos.get(index).setFinalPlaca(Integer.parseInt(JOptionPane.showInputDialog("Digite o final da placa para a alteração")));
                                     JOptionPane.showMessageDialog(null,"O veiculo foi completamente alterado com sucesso");
                                     break;
                                 case 8:
                                     break;
                             }
                            break;
                        case 2:
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Você deve escolher uma opção do menu!");
                        }
                        break;
                    }
                case 3:
                    if(listaDeCaminhoes.isEmpty()){ //Tratamento de erro caso a lista esteja vazia
                        JOptionPane.showMessageDialog(null,"Não existem veiculos do tipo (Caminhão) cadastrados para a exclusão.");
                        break;
                    }else{
                        int index = Integer.parseInt(JOptionPane.showInputDialog("Sistema Stars Concessionaria\n\n" + "Insira o codigo de cadastro do veiculo que você deseja alterar" + 
                                "\nO codigo de cadastro é informado na exibição de veiculos.\n"));
                        int resp = Integer.parseInt(JOptionPane.showInputDialog("O veiculo a ser alterado é: \n"+ listaDeCaminhoes.get(index).getMarca() +" "+ listaDeCaminhoes.get(index).getModelo() + "\n"
                        +"Deseja continuar ?" +"\n"
                        +"1 --> Sim\n"
                        +"2 --> Cancelar\n"));
                        switch(resp){
                        case 1:                            
                             int escolhaCaminhao;
                             escolhaCaminhao = Integer.parseInt(JOptionPane.showInputDialog(escolhaAlteracao));
                             switch(escolhaCaminhao){
                                 case 1:
                                    listaDeCaminhoes.get(index).setMarca(JOptionPane.showInputDialog("Digite uma nova marca para a alteração"));
                                    JOptionPane.showMessageDialog(null,"A marca do veiculo foi alterado com sucesso");
                                    break;
                                 case 2:
                                     listaDeCaminhoes.get(index).setModelo(JOptionPane.showInputDialog("Digite um novo modelo para a alteração"));
                                    JOptionPane.showMessageDialog(null,"O modelo do veiculo foi alterado com sucesso");
                                    break;
                                 case 3:
                                    listaDeCaminhoes.get(index).setCor(JOptionPane.showInputDialog("Digite uma nova cor para a alteração"));
                                    JOptionPane.showMessageDialog(null,"A cor do veiculo foi alterado com sucesso");
                                    break;
                                 case 4:
                                     listaDeCaminhoes.get(index).setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite um novo ano para a alteração")));
                                    JOptionPane.showMessageDialog(null,"O ano do veiculo foi alterado com sucesso");
                                    break;
                                 case 5:
                                    listaDeCaminhoes.get(index).setPreco(Float.parseFloat(JOptionPane.showInputDialog("Digite um novo preço para a alteração")));
                                    JOptionPane.showMessageDialog(null,"O preço veiculo foi alterado com sucesso");
                                    break;
                                 case 6:
                                    listaDeCaminhoes.get(index).setFinalPlaca(Integer.parseInt(JOptionPane.showInputDialog("Digite o final da placa para a alteração")));
                                    JOptionPane.showMessageDialog(null,"O final da placa do veiculo foi alterado com sucesso");
                                    break;
                                 case 7:
                                     listaDeCaminhoes.get(index).setMarca(JOptionPane.showInputDialog("Digite uma nova marca para a alteração"));
                                     listaDeCaminhoes.get(index).setModelo(JOptionPane.showInputDialog("Digite um novo modelo para a alteração"));
                                     listaDeCaminhoes.get(index).setCor(JOptionPane.showInputDialog("Digite uma nova cor para a alteração"));
                                     listaDeCaminhoes.get(index).setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite um novo ano para a alteração")));
                                     listaDeCaminhoes.get(index).setPreco(Float.parseFloat(JOptionPane.showInputDialog("Digite um novo preço para a alteração")));
                                     listaDeCaminhoes.get(index).setFinalPlaca(Integer.parseInt(JOptionPane.showInputDialog("Digite o final da placa para a alteração")));
                                     JOptionPane.showMessageDialog(null,"O veiculo foi completamente alterado com sucesso");
                                     break;
                                 case 8:
                                     break;
                             }
                            break;
                        case 2:
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Você deve escolher uma opção do menu!");
                        }
                        break;
                    }
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Você deve escolher uma opção do menu!");                    
                }
        }while(opcaoA != 4);
    }
    /*
        *Exclusão do veiculo cadastrado
     */
    private static void deletaVeiculo() {
        int opcaoD;
        do{
            opcaoD = Integer.parseInt(JOptionPane.showInputDialog(menuDeletar));
            switch(opcaoD){
                case 1:
                    if(listaDeCarros.isEmpty()){ //Tratamento de erro caso a lista esteja vazia
                        JOptionPane.showMessageDialog(null,"Não existem veiculos do tipo (carro) cadastrados para a exclusão.");
                        break;
                    }else{
                        int index = Integer.parseInt(JOptionPane.showInputDialog("Sistema Stars Concessionaria\n\n" + "Insira o codigo de cadastro do carro que você deseja deletar" + 
                                "\n\nO codigo de cadastro é informado na exibição de veiculos.\n\n"));
                        int resp = Integer.parseInt(JOptionPane.showInputDialog("O veiculo a ser deletado é: \n"+ listaDeCarros.get(index).getMarca() + " " +listaDeCarros.get(index).getModelo() + "\n"
                        +"Deseja continuar ?" +"\n"
                        +"1 --> Sim\n"
                        +"2 --> Cancelar\n"));                        
                        switch(resp){
                        case 1:
                            listaDeCarros.remove(index);
                            JOptionPane.showMessageDialog(null,"O veiculo foi deletado com sucesso");
                        case 2:
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Você deve escolher uma opção do menu!");
                        }
                        break;
                    }
                case 2:
                    if(listaDeMotos.isEmpty()){ //Tratamento de erro caso a lista esteja vazia
                        JOptionPane.showMessageDialog(null,"Não existem veiculos do tipo (moto) cadastrados para a exclusão.");
                        break;
                    }else{
                        int index = Integer.parseInt(JOptionPane.showInputDialog("Sistema Stars Concessionaria\n\n" + "Insira o codigo de cadastro da moto que você deseja deletar" + 
                                "\nO codigo de cadastro é informado na exibição de veiculos.\n"));
                        int resp = Integer.parseInt(JOptionPane.showInputDialog("O veiculo a ser deletado é: \n"+ listaDeMotos.get(index).getMarca() +" "+ listaDeMotos.get(index).getModelo() + "\n"
                        +"Deseja continuar ?" +"\n"
                        +"1 --> Sim\n"
                        +"2 --> Cancelar\n"));
                        switch(resp){
                        case 1:
                            listaDeMotos.remove(index);
                            JOptionPane.showMessageDialog(null,"O veiculo foi deletado com sucesso");
                        case 2:
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Você deve escolher uma opção do menu!");
                        }
                        break;
                    }
                case 3:
                    if(listaDeCaminhoes.isEmpty()){ //Tratamento de erro caso a lista esteja vazia
                        JOptionPane.showMessageDialog(null,"Não existem veiculos do tipo (caminhão) cadastrados para a exclusão.");
                        break;
                    }else{
                        int index = Integer.parseInt(JOptionPane.showInputDialog("Sistema Stars Concessionaria\n\n" + "Insira o codigo de cadastro do caminhão que você deseja deletar" + 
                                "\n\nO codigo de cadastro é informado na exibição de veiculos.\n"));
                        int resp = Integer.parseInt(JOptionPane.showInputDialog("O veiculo a ser deletado é: \n"+ listaDeCaminhoes.get(index).getMarca() +" "+ listaDeCaminhoes.get(index).getModelo() + "\n"
                        +"Deseja continuar ?" +"\n"
                        +"1 --> Sim\n"
                        +"2 --> Cancelar\n"));
                        switch(resp){
                        case 1:
                            listaDeCaminhoes.remove(index);
                            JOptionPane.showMessageDialog(null,"O veiculo foi deletado com sucesso");
                        case 2:
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Você deve escolher uma opção do menu!");
                        }
                        break;
                    }
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Você deve escolher uma opção do menu!");                    
            }
        }while(opcaoD != 4);
    }
    
    /*
        *Exibição dos veiculos cadastrados
     */
    
    private static void listarVeiculos() {
        int opcaoL;
        
        do{
            opcaoL= Integer.parseInt(JOptionPane.showInputDialog(selecaoExibicao));            
                switch (opcaoL) {
                case 1:
                    if(listaDeCarros.isEmpty()){//Tratamento de erro caso a lista esteja vazia
                        JOptionPane.showMessageDialog(null, "Sistema Stars Concessionaria\n\n" 
                                + "Não existem veiculos do tipo (Carro) cadastrados");
                        break;
                    }else{
                        int n = listaDeCarros.size() ;
                        for (int i = 0; i < n; i++) {
                            JOptionPane.showMessageDialog(null, "Sistema Stars Concessionaria\n\n"                         
                                    +"Veiculos do tipo (carro) cadastrados\n\n"
                                    +"Codigo de cadastro do veiculo: " + i + "\n\n"
                                    +listaDeCarros.get(i)
                                    +"Pressione OK para continuar");
                        }                    
                     break;
                    }
                case 2:
                    if(listaDeMotos.isEmpty()){//Tratamento de erro caso a lista esteja vazia
                        JOptionPane.showMessageDialog(null, "Sistema Stars Concessionaria\n\n" 
                                + "Não existem veiculos do tipo (moto) cadastrados");
                        break;
                    }else{
                        int m = listaDeMotos.size() ;
                        for (int i = 0; i < m; i++) {
                            JOptionPane.showMessageDialog(null, "Sistema Stars Concessionaria\n\n"
                                    +"Veiculos do tipo : Moto cadastrados\n\n" 
                                    +"Codigo de cadastro do veiculo: " + i + "\n\n"
                                    +listaDeMotos.get(i)
                                    +"Pressione OK para continuar");
                         }
                    }                    
                    break;
                case 3:
                    if(listaDeCaminhoes.isEmpty()){//Tratamento de erro caso a lista esteja vazia
                        JOptionPane.showMessageDialog(null, "Sistema Stars Concessionaria\n\n" 
                                + "Não existem veiculos do tipo (Caminhão) cadastrados");
                        break;
                    }else{
                        int c = listaDeCaminhoes.size() ;
                        for (int i = 0; i < c; i++) {
                        JOptionPane.showMessageDialog(null, "Sistema Stars Concessionaria\n\n"
                                +"Veiculos do tipo (Caminhão) cadastrados:\n\n" 
                                +"Codigo de cadastro do veiculo: " + i + "\n\n"
                                +listaDeCaminhoes.get(i)
                                +"Pressione OK para continuar");
                        }
                    }                    
                    break;
                 case 4:
                    break; 
                default:
                    JOptionPane.showMessageDialog(null, "Você deve escolher uma opção do menu!");
            }
        }while(opcaoL != 4);
    }
}
