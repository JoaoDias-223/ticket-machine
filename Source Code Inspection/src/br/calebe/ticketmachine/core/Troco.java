package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    /* Erro 11 [doc] - Na doc, esta classe não possui atributos */
    protected PapelMoeda[] papeisMoeda;
    
    private int getNumeroNotas(int valorNota, int valorOriginal){
        int count = 0;
        while (valorOriginal % valorNota != 0) {
            count++;
        }
        
        return count;
    }

    /* Erro 19 [código] - Repetição desnecessária de código */
    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        String[] notas = {100, 50, 20, 10, 5, 2};
        
        for (int i = 0; i < notas.length; i++) {
            int numeroDeNotas = this.getNumeroNotas(valor, notas[i]);
            papeisMoeda[i] = new PapelMoeda(notas[i], numeroDeNotas);
            valor-= numeroDeNotas * notas[i];
        }
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
