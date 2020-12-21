package controlador.visao.modal.editar;

import controlador.visao.modal.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.modal.editar.ViewEditar;

/**
 * <p>Classe de Controle <b>ControllerViewEditar</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewEditar.</p>
 * @author Leandro
 * @since  21/12/2020
 * @see    controlador.visao.modal.ControllerViewModal
 * @see    visao.modal.editar.ViewEditar
 */
public abstract class ControllerViewEditar extends ControllerViewModal {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar.
     */
    public ControllerViewEditar(ViewEditar view) {
        super(view);
    }

    /**
     * Metodo abstrato responsavel por Checar os Valores.
     * @return Valores checados.
     */
    public abstract boolean check();
    
    /**
     * Metodo abstrato responsavel por Salvar os Valores.
     */
    public abstract void salvar();
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if (getView().getButtonSalvar().equals(event.getSource()) && check())
            salvar();
        else if (getView().getButtonCancelar().equals(event.getSource()))
            getView().dispose();
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);
        switch (event.getKeyCode()) {
            case F1:
                if (check())
                    salvar();
                break;
            case F2:
                getView().dispose();
                break;
            default:
                break;
        }
    }
    
    @Override
    public ViewEditar getView() {
        return (ViewEditar) view;
    }
}