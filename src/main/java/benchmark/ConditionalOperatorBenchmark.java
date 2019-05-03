package benchmark;

import comparator.ComparatorCpuToNotUse;
import comparator.ComparatorCpuToNotUseSlightlyImproved;
import comparator.Cpu;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ConditionalOperatorBenchmark {

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder().include(ConditionalOperatorBenchmark.class.getSimpleName())
                                      .warmupIterations(5)
                                      .measurementIterations(5)
                                      .forks(1)
                                      .build();
    new Runner(opt).run();
  }

  @State(Scope.Benchmark)
  public static class NestedConditionalOperatorState {

    public List<Cpu> cpus;

    @Setup(Level.Iteration)
    public void doSetup() {
      cpus = createCpus();
    }

  }

  @State(Scope.Benchmark)
  public static class FlattenedConditionalOperatorState {

    public List<Cpu> cpus;

    @Setup(Level.Iteration)
    public void doSetup() {
      cpus = createCpus();
    }

  }

  private static List<Cpu> createCpus() {
    List<Cpu> cpus =
        IntStream.range(0, 100).mapToObj(i -> new Cpu(2.4F, 2.8F, (short) 4, (short) 1)).collect(toList());
    return cpus;
  }

  @Benchmark
  public void _1_sort_with_nested_conditional_operator(NestedConditionalOperatorState state) {
    state.cpus.sort(new ComparatorCpuToNotUse());
  }

  @Benchmark
  public void _2_sort_with_flattened_conditional_operator(FlattenedConditionalOperatorState state) {
    state.cpus.sort(new ComparatorCpuToNotUseSlightlyImproved());
  }

}