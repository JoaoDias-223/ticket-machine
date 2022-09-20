package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    /* Erro 1 [doc] - A classe não deveria ter atributos, pois não foi especificado no diagrama de classes */
    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100}; /* Erro 2 [doc] - Falta nota de 200 */
    /* Erro 9 [código] - Em vez de usar um array de Integer, ele poderia utilizar um array de PapelMoeda. Além disso, a variável
    * poderia ser renomeada para evitar ambiguidade com a entidade PapelMoeda */

    /* Erro 5 [código] - O primeiro argumento no construtor da classe deveria estar nomeado como precoDoBilhete */
    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[1] == quantia) { /* Erro 4 [código] - A variável i que deveria ser usada para acessar o array */
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }

    /* Erro 3 [código] - Na doc, está especificado que o saldo deve ser zerado ao solicitar o troco */
    /* Erro 8 [código] - A função getTroco deveria retornar um TrocoIterator */
    public Iterator<Integer> getTroco() {
        return null;
    }

    /* Erro 6 [código] - Na doc, a impressão do bilhete deveria debitar o valor do bilhete do saldo */
    /* Erro 7 [doc] - VER DOC, adicionar passo de débito no use case CSU02 */
    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
