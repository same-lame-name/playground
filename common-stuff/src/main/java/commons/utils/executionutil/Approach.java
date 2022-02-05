package commons.utils.executionutil;

public interface Approach<T> {
    String getDescription();
    T apply(Object... args);
}
