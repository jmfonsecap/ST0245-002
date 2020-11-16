import java.util.Set;
public class Pairs<K, V> {

        private final K element0;
        private final V element1;
    
        public static <K, V> Pairs<K, V> createPair(K element0, V element1) {
            return new Pairs<K, V>(element0, element1);
        }
    
        public Pairs(K element0, V element1) {
            this.element0 = element0;
            this.element1 = element1;
        }
        public Pairs()
        {
            element0=null;
            element1=null;
        }
    
        public K getElement0() {
            return element0;
        }
    
        public V getElement1() {
            return element1;
        }
       
    }

