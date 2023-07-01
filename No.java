
import java.util.Comparator;

public class No implements Comparator<No> {
        int pos;
        String nodeName;
        String cityName;
        int weight;

        public No(int pos, String nodeName, String cityName, int weight) {
            this.pos = pos;
            this.nodeName = nodeName;
            this.cityName = cityName;
            this.weight = weight;
        }

        @Override public int compare(No node1, No node2)
        {
      
            if (node1.weight < node2.weight)
                return -1;
      
            if (node1.weight > node2.weight)
                return 1;
      
            return 0;
        }
    }