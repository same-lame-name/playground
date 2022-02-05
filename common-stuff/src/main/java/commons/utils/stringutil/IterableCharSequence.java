package commons.utils.stringutil;

import java.util.Iterator;

public class IterableCharSequence implements Iterable<Character> {
    CharSequence charSequence;

    public IterableCharSequence(CharSequence charSequence) {
        this.charSequence = charSequence;
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < charSequence.length();
            }

            @Override
            public Character next() {
                return charSequence.charAt(index++);
            }
        };
    }
}

