package it.miriade.corsi.android.databindinglibrary.util.collection;

public interface CollectionConverter<V, T> {

    public T convert(V v);
}
