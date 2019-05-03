package comparator;

import java.util.Comparator;

public class ComparatorCpuToNotUse implements Comparator<Cpu> {

    @Override
    public int compare(Cpu o1, Cpu o2) {

        int compareResult = (int) (o1.getBaseClockInGHz() - o2.getBaseClockInGHz());

        if (compareResult == 0) {
            compareResult = (int) (o1.getBoostClockInGHz() - o2.getBoostClockInGHz());

            if (compareResult == 0) {
                compareResult = o1.getNumberOfCore() - o2.getNumberOfCore();

                if (compareResult == 0) {
                    compareResult = o1.getNumberOfThread() - o2.getNumberOfThread();
                }
            }

        }
        return compareResult;

    }
}