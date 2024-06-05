package ad_2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SortClassWrapper {

    private  static Class<?> getClass(Sorter alg){
        return alg.getSorterClass();
    }

    public static <T extends Comparable<? super T>> void doSort(Sorter sorter, T[] a) throws ReflectionException {
        Class<?> clazz = getClass(sorter);
        Method sort;
        try {
            sort = clazz.getMethod("sort", Comparable[].class );
            sort.invoke(null, new Object[]{a});
        } catch (NoSuchMethodException e) {
           throw new ReflectionException(e);
        } catch (IllegalAccessException e) {
            throw new ReflectionException(e);
        } catch (InvocationTargetException e) {
            throw new ReflectionException(e);
        }
    }
}


