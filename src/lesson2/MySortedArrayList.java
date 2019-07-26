package lesson2;

public class MySortedArrayList<Item extends Comparable> extends MyArrayList<Item> {

    @Override
    public void add(Item item) {
        int i = 0;
        while (i < this.size() && item.compareTo(get(i)) >= 0) {
            i++;
        }
        super.add(i, item);
    }

    @Override
    public void add(int index, Item item) {
        add(item);
    }

    @Override
    public void set(int index, Item item) {
    }

    public boolean binaryFind(Item item) {
        return recBinaryFind(item,0,size()-1);
//        int lo = 0;
//        int hi = size() - 1;
//
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2; //(hi + lo) / 2;
//
//            if (item.compareTo(get(mid)) < 0) {
//                hi = mid - 1;
//            } else if (item.compareTo(get(mid)) > 0) {
//                lo = mid + 1;
//            } else {
//                return true;
//            }
//        }
//        return false;
    }

    private boolean recBinaryFind(Item item, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (item.compareTo(get(mid)) == 0) {
            return true;
        } else if (lo == hi) {
            return false;
        } else if (item.compareTo(get(mid)) < 0) {
            return recBinaryFind(item, lo, mid);
        } else if (item.compareTo(get(mid)) > 0) {
            return recBinaryFind(item, mid + 1, hi);
        }
        return false;
    }
}
