package controlador.visao.modal.excluir.estruturais;

import controlador.visao.modal.excluir.ControllerViewExcluir;
import modelo.dao.estruturais.DaoPesagem;
import visao.modal.excluir.estruturais.ViewExcluirPesagem;
import visao.modal.mensagem.ViewMensagem;

/**
 * <p>Classe de Controle <b>ControllerViewExcluirPesagem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewExcluirPesagem.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.modal.excluir.ControllerViewExcluir
 * @see    modelo.dao.estruturais.DaoPesagem
 * @see    visao.modal.excluir.estruturais.ViewExcluirPesagem
 */
public class ControllerViewExcluirPesagem extends ControllerViewExcluir {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Excluir Pesagem.
     */
    public ControllerViewExcluirPesagem(ViewExcluirPesagem view) {
        super(view);
    }
    
    @Override
    public void excluir() {
        new DaoPesagem().delete(getView().getPesagem().getId());
        new ViewMensagem(getView(), "Pesagem removida com Sucesso!").setVisible(true);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public ViewExcluirPesagem getView() {
        return (ViewExcluirPesagem) view;
    }
}