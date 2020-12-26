package controlador.visao.modal.novo.estruturais;

import controlador.visao.modal.novo.ControllerViewNovo;
import java.awt.event.ActionEvent;
import modelo.dao.estruturais.DaoPesagem;
import modelo.entidade.estruturais.Bovino;
import modelo.entidade.estruturais.Pesagem;
import visao.modal.mensagem.ViewErro;
import visao.modal.mensagem.ViewMensagem;
import visao.modal.novo.estruturais.ViewNovoPesagem;
import visao.modal.pesquisa.estruturais.ViewPesquisaBovino;
import visao.painel.novo.estruturais.PanelNovoPesagem;

/**
 * <p>Classe de Controle <b>ControllerViewNovoPesagem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewNovoPesagem.</p>
 * @author Leandro
 * @since  23/12/2020
 * @see    controlador.visao.modal.novo.ControllerViewNovo
 * @see    modelo.entidade.estruturais.Pesagem
 * @see    visao.modal.novo.estruturais.ViewNovoPesagem
 */
public class ControllerViewNovoPesagem extends ControllerViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo Pesagem.
     */
    public ControllerViewNovoPesagem(ViewNovoPesagem view) {
        super(view);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        if (getPanel().getButtonPesquisa().equals(event.getSource()))
            new ViewPesquisaBovino(getView()).setVisible(true);
    }
    
    /**
     * Metodo responsavel por validar o Bovino.
     * @return Bovino e valido.
     */
    public boolean checkBovino() {
        if (getView().getBovino() == null) {
            new ViewErro(getView(), "Selecione um Bovino!").setVisible(true);
            return false;
        }
        return true;
    }
    
    /**
     * Metodo responsavel por validar a Data da Pesagem.
     * @return Data da Pesagem e valida.
     */
    public boolean checkData() {
        return checkData(getPanel().getTextFieldData(), "Data Inválida!");
    }
    
    /**
     * Metodo responsavel por validar o Peso.
     * @return Peso e valido.
     */
    public boolean checkPeso() {
        return checkValor(getPanel().getTextFieldPeso(), "Peso Inválido!");
    }
    
    @Override
    public boolean check() {
        return checkBovino()
            && checkData()
            && checkPeso();
    }
    
    @Override
    public void inserir() {
        Bovino  bovino  = getView().getBovino();
        Pesagem pesagem = new Pesagem();
                pesagem.setBovino(bovino);
                pesagem.setDataPesagem(getData(getPanel().getTextFieldData()));
                pesagem.setValor(getFloat(getPanel().getTextFieldPeso()));
        new DaoPesagem().insert(pesagem);
        new ViewMensagem(getView(), "Pesagem cadastrada com Sucesso!").setVisible(true);
        getView().getView().update();
        getView().dispose();
    }
    
    public PanelNovoPesagem getPanel() {
        return getView().getPanelNovo();
    }
    
    @Override
    public ViewNovoPesagem getView() {
        return (ViewNovoPesagem) view;
    }
}