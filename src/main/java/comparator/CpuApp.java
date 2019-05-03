package comparator;

import java.util.List;

public class CpuApp {

    public static void main(String[] args) {

        List<Cpu> cpus =
                List.of(new Cpu(2.4F, 2.8F, (short) 4, (short) 8),
                        new Cpu(2.4F, 3F, (short) 6, (short) 8),
                        new Cpu(4, 5F, (short) 12, (short) 24),
                        new Cpu(2.8F, 3.2F, (short) 6, (short) 8),
                        new Cpu(2.8F, 3.2F, (short) 6, (short) 12));


    }
}