package me.ssagan.iterator._main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class _Main {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        Predicate<Integer> integerPredicate = integer -> integer%2 != 0;
        PredicateIterator<Integer> predicateIterator = new PredicateIterator<>(integers, integerPredicate);
        while (predicateIterator.hasNext()){
            System.out.println(predicateIterator.next());
        }
    }

    static class PredicateIterator<T> implements Iterator<T> {
        private final List<T> list;
        private Iterator<T> filteredIterator;
        private final Predicate<T> predicate;

        public PredicateIterator(List<T> list, Predicate<T> predicate){
            this.list = list;
            this.predicate = predicate;
            filteredIterator = list.stream().filter(predicate).iterator();
        }

        @Override
        public boolean hasNext() {
            //проверяет. есть ли элемент удовлетворяющий условию
            return filteredIterator.hasNext();
        }

        @Override
        public T next() {
            //возвращает элемент, удовлетворяющий условию
            return filteredIterator.next();
        }
    }
}
