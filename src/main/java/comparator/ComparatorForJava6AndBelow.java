package comparator;

import java.util.Comparator;

public class ComparatorForJava6AndBelow implements Comparator<Cpu> {

  @Override
  public int compare(Cpu o1, Cpu o2) {

    int compareResult = 0;

    if (o1.getBaseClockInGHz() < o2.getBaseClockInGHz()) {
      compareResult = -1;
    } else if (o1.getBaseClockInGHz() > o2.getBaseClockInGHz()) {
      compareResult = 1;
    }

    if (compareResult == 0) {
      if (o1.getBoostClockInGHz() < o2.getBoostClockInGHz()) {
        compareResult = -1;
      } else if (o1.getBoostClockInGHz() > o2.getBoostClockInGHz()) {
        compareResult = 1;
      }
    }

    if (compareResult == 0) {
      if (o1.getNumberOfCore() < o2.getNumberOfCore()) {
        compareResult = -1;
      } else if (o1.getNumberOfCore() > o2.getNumberOfCore()) {
        compareResult = 1;
      }
    }

    if (compareResult == 0) {
      if (o1.getNumberOfThread() < o2.getNumberOfThread()) {
        compareResult = -1;
      } else if (o1.getNumberOfThread() > o2.getNumberOfThread()) {
        compareResult = 1;
      }
    }

    return compareResult;
  }
}