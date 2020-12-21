package visao.painel.editar;

import visao.modal.editar.ViewEditar;
import visao.painel.Panel;

/**
 * <p>Classe de Visao <b>PanelEditar</b>.</p> 
 * <p>Classe responsavel por definir um Modelo Abstrato para o <b>Painel Editar</b> do SGBov.</p>
 * @author Leandro
 * @since  21/12/2020
 * @see    controlador.visao.painel.
 * @see    visao.modal.editar.ViewEditar
 * @see    visao.painel.Panel
 */
public abstract class PanelEditar extends Panel {
    protected ViewEditar view;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar.
     */
    public PanelEditar(ViewEditar view) {
        this.view = view;
    }
    
    /**
     * Metodo abstrato responsavel por definir as Propriedades do Panel Editar.
     */
    protected abstract void setProperties();
    
    /**
     * Metodo abstrato responsavel por apresentar os Valores do Panel Editar.
     */
    public abstract void setValues();
    
    /**
     * Metodo responsavel por retornar a View Editar.
     * @return View Editar.
     */
    public ViewEditar getView() {
        return (ViewEditar) view;
    }
}