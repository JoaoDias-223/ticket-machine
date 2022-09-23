package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;
    
    private int getNumeroNotas(int valorNota, int valorOriginal){
        int count = 0;
        while (valorOriginal % valorNota != 0) {
            count++;
        }
        
        return count;
    }

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        String[] notas = {200, 100, 50, 20, 10, 5, 2};
       
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

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            for (int i = 6; i >= 0; i--) {
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 6; i >= 0 && ret == null; i--) {
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
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
