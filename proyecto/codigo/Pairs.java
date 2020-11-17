
public class Pairs<K, V> {

        private final K element0;
        private final V element1;
        /**
         * Metodo para crear  parejas que nos deja asignarle el tipo de dato que sera cada dato bajo la notacion<K,V>
         * @param <K> tipo de dato de la primera componente
         * @param <V> tipo de dato de la segunda componente
         * @param element0 primera componente de la pareja
         * @param element1 segunda componente de la pareja
         * @return
         */
        public static <K, V> Pairs<K, V> createPair(K element0, V element1) {
            return new Pairs<K, V>(element0, element1);
        }
        
        /**
         * Constructor de parejas
         * @param element0 primer componente de la pareja
         * @param element1 segunda componente de la pareja
         */
        public Pairs(K element0, V element1) {
            this.element0 = element0;
            this.element1 = element1;
        }
        /**
         * Constructor vacio que asigna a ambas parejas el null
         */
        public Pairs()
        {
            element0=null;
            element1=null;
        }
        /**
         * Metodo que retorna la primera componente de la pareja
         * @return la primera componente de la pareja
         */
        public K getElement0() {
            return element0;
        }
        
        /**
         * Metodo que retorna la segunda componente de la pareja
         * @return la segunda componente de la pareja
         */
        public V getElement1() {
            return element1;
        }
       
    }

