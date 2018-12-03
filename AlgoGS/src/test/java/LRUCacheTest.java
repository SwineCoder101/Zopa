import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {

    LRUCache lruCache;

    @Before
    public void init(){
        lruCache = new LRUCache(10);
    }


    @Test
    public void shouldSetLRUCache(){
        lruCache.set(5,6);
        lruCache.set(421,6);
        lruCache.set(54,6);
        lruCache.set(231,6);
        lruCache.set(342,6);
        lruCache.set(0,6);
        lruCache.set(2,6);
        lruCache.set(3,6);
        lruCache.set(5,6);
        lruCache.set(6,6);
        lruCache.set(3,6);

        lruCache.get(5);
    }




}
