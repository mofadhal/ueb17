import java.util.function.Predicate;
/**
*
* @author (Mofadhal Al-Manari und Leen Alkhadraa)
* @version (09.06.2021)
* 
*/

	
	
	@FunctionalInterface
     interface Conditionate extends MyFunction {
	 /**
	 *Diese Methode nimmt ein Prädikat als Argument entgegen und
     * gibt einen Lambda-Ausdruck zurück. Der Lambda-Ausdruck prüft für einen gegebenen
     * Integer-Wert, ob dieser das Prädikat erfüllt. Ist das Prädikat erfüllt, wird das Ergebnis der
     * apply-Methode des Interfaces zurückgegeben, ansonsten wird 0 zurückgegeben 
     */
	  default MyFunction conditionateInput(Predicate<Integer> predicate) {
	    return x -> (predicate.test(x) ? this.apply(x) : 0);
	  }
     /**
     * Diese Methode nimmt ebenfalls ein Prädikat als Argument entgegen und gibt einen Lambda-Ausdruck zurück. Der Lambda-Ausdruck prüft, ob das
     *  Ergebnis der apply-Methode das Prädikat erfüllt. Ist das Prädikat erfüllt, wird das Ergebnis zurückgegeben, ansonsten 0.
     */
	  default MyFunction conditionateOutput(Predicate<Integer> predicate) {
	    return x -> (predicate.test(this.apply(x)) ? this.apply(x) : 0);
	  }
	}


