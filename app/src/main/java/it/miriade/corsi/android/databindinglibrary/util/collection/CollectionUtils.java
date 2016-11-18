package it.miriade.corsi.android.databindinglibrary.util.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtils {

    /**
     * Trasforma una collezione di un tipo in una collezione di un altro tipo
     *
     * @param converter  il metodo di trasformazione
     * @param collection la collezione da trasformare
     * @return una nuova lista contenente gli elementi della collezione trasformati dal metodo
     */
    public static <T, V> List<V> convertList(CollectionConverter<T, V> converter,
                                             Collection<T> collection) {

        return convertList(converter, collection, false);
    }

    /**
     * Trasforma una collezione di un tipo in una collezione di un altro tipo
     *
     * @param converter  il metodo di trasformazione
     * @param collection la collezione da trasformare
     * @param nulls      aggiunge i nulli alla lista o li ignora
     * @return una nuova lista contenente gli elementi della collezione trasformati dal metodo
     */
    public static <T, V> List<V> convertList(CollectionConverter<T, V> converter,
                                             Collection<T> collection, boolean nulls) {

        if (collection == null)
            throw new IllegalArgumentException("Collection is null");

        List<V> toRet = new ArrayList<V>(collection.size());

        for (T t : collection) {
            V v = converter.convert(t);
            if (v != null || nulls)
                toRet.add(v);
        }

        return toRet;
    }

}
