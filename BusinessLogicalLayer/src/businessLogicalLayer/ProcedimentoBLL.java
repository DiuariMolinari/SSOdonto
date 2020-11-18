/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

/**
 *
 * @author marci
 */
public class ProcedimentoBLL {
    int idProcedimento;
    String nomeProcedimento;
    String dsProcedimento;
    int idTipoProcedimento;

    public String NomeProcedimento
    {
        get
        {
            return nomeProcedimento;
        }
        set
        {
            nomeProcedimento = value;
        }
    }
}
