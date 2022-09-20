package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    /* Erro 11 [doc] - Na doc, esta classe não possui atributos */
    protected PapelMoeda[] papeisMoeda;

    /* Erro 19 [código] - Repetição desnecessária de código */
    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int count = 0;
        while (valor % 100 != 0) { /* Erro 20 [código] - loop infinito porque a variável valor não é alterada */
            count++;
        }
        papeisMoeda[5] = new PapelMoeda(100, count);
        count = 0;
        while (valor % 50 != 0) { /* Erro 21 [código] - loop infinito porque a variável valor não é alterada */
            count++;
        }
        papeisMoeda[4] = new PapelMoeda(50, count);
        count = 0;
        while (valor % 20 != 0) { /* Erro 22 [código] - loop infinito porque a variável valor não é alterada */
            count++;
        }
        papeisMoeda[3] = new PapelMoeda(20, count);
        count = 0;
        while (valor % 10 != 0) { /* Erro 23 [código] - loop infinito porque a variável valor não é alterada */
            count++;
        }
        papeisMoeda[2] = new PapelMoeda(10, count);
        count = 0;
        while (valor % 5 != 0) { /* Erro 24 [código] - loop infinito porque a variável valor não é alterada */
            count++;
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        count = 0;
        while (valor % 2 != 0) { /* Erro 25 [código] - loop infinito porque a variável valor não é alterada */
            count++;
        }
        papeisMoeda[1] = new PapelMoeda(2, count); /* Erro 17 [código] - sobrescrita do segundo elemento */
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        /* Erro 12 [doc] - Na doc, esta classe não possui atributos */
        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            /* Erro 15 [código] - IndexOutOfBounds */
            for (int i = 6; i >= 0; i++) { /* Erro 13 [código] - loop infinito */
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            /* Erro 16 [código] - IndexOutOfBounds */
            for (int i = 6; i >= 0 && ret != null; i++) {  /* Erro 14 [código] - loop infinito */
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null; /* Erro 18 - Remoção desnecessária dos elementos do array */
                }
            }
            return ret;
        }

        @Override
        public void remove() {
            next();
        }
    }
}
