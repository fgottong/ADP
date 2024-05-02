import org.junit.Assert;
import org.junit.Test;
import Praktikum1.InplaceSuche;

import static Praktikum1.InplaceSuche.localMax;
import static org.junit.Assert.assertArrayEquals;

public class TestInplaceSuche {
    int[] ary1 = {1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};

    int[] resultAry1 = {1, 61, 89, 75, 16};
    int radius1 = 2;
    int[] ary2 = {1, 61, 16, 75, 89, 133, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38,
            78, 7, 6, 15};
    int[] resultAry2 = {16, 75, 89, 133, 89, 59, 28};
    int radius2 = 3;
    int[] ary3 = {99,1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38,
            78, 7, 6, 15};
    int[] resultAry3 = null;
    int radius3 = 1;

    @Test
    public void testeInplaceSuche1(){
        assertArrayEquals(resultAry1, localMax(ary1,radius1));
    }
    @Test
    public void testeInplaceSuche2(){
        assertArrayEquals(resultAry2, localMax(ary2,radius2));
    }
    @Test
    public void testeInplaceSuche3(){
        Assert.assertNull(localMax(ary3,radius3));
    }

}
