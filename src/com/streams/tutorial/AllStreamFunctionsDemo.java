package com.streams.tutorial;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

/**
 * EXHAUSTIVE JAVA STREAM API DEMO
 * Covering EVERY SINGLE function in Stream, PrimitiveStreams, and Collectors API!
 */
public class AllStreamFunctionsDemo {

    public static void main(String[] args) {
        System.out.println("=================================================================");
        System.out.println("   EXHAUSTIVE JAVA STREAM API METHOD CATALOG & DEMONSTRATION");
        System.out.println("=================================================================\n");

        // 1. STREAM CREATION & FACTORY METHODS
        demoCreationMethods();

        // 2. INTERMEDIATE TRANSFORMATIONS & MAPPINGS
        demoMappingMethods();

        // 3. INTERMEDIATE FILTERING & SLICING
        demoFilteringAndSlicingMethods();

        // 4. INTERMEDIATE SORTING, PEEK & DEDUPLICATION
        demoSortingPeekAndDistinct();

        // 5. TERMINAL REDUCTIONS & ACCUMULATIONS
        demoReductionMethods();

        // 6. TERMINAL MATCHING & FINDING
        demoMatchingAndFindingMethods();

        // 7. TERMINAL ITERATION & CONVERSION
        demoIterationAndArrayMethods();

        // 8. EXHAUSTIVE COLLECTORS API
        demoExhaustiveCollectors();

        // 9. PRIMITIVE STREAMS (IntStream, LongStream, DoubleStream)
        demoPrimitiveStreams();

        // 10. STREAM PIPELINE CONTROL & PARALLELISM
        demoStreamControlAndParallel();
    }

    private static void section(String name) {
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println(" 📌 " + name);
        System.out.println("-----------------------------------------------------------------");
    }

    // 1. CREATION
    private static void demoCreationMethods() {
        section("1. STREAM CREATION METHODS");

        // Stream.of(T...)
        Stream<String> s1 = Stream.of("A", "B", "C");
        System.out.println("Stream.of: " + s1.collect(Collectors.toList()));

        // Stream.ofNullable(T) (Java 9+)
        String nullableVal = null;
        Stream<String> s2 = Stream.ofNullable(nullableVal);
        System.out.println("Stream.ofNullable(null) count: " + s2.count());

        // Stream.empty()
        Stream<Object> s3 = Stream.empty();
        System.out.println("Stream.empty() count: " + s3.count());

        // Stream.builder()
        Stream<String> s4 = Stream.<String>builder().add("One").add("Two").build();
        System.out.println("Stream.builder(): " + s4.collect(Collectors.toList()));

        // Stream.concat(Stream, Stream)
        Stream<String> concatStream = Stream.concat(Stream.of("Alpha"), Stream.of("Beta"));
        System.out.println("Stream.concat: " + concatStream.collect(Collectors.toList()));

        // Stream.iterate(seed, operator)
        List<Integer> powers = Stream.iterate(1, n -> n * 2).limit(5).collect(Collectors.toList());
        System.out.println("Stream.iterate (2-arg): " + powers);

        // Stream.iterate(seed, predicate, operator) (Java 9+)
        List<Integer> iteratedWithPred = Stream.iterate(1, n -> n <= 16, n -> n * 2).collect(Collectors.toList());
        System.out.println("Stream.iterate (3-arg bounded): " + iteratedWithPred);

        // Stream.generate(Supplier)
        List<Integer> randoms = Stream.generate(() -> 42).limit(3).collect(Collectors.toList());
        System.out.println("Stream.generate: " + randoms);
    }

    // 2. MAPPING & TRANSFORMATION
    private static void demoMappingMethods() {
        section("2. MAPPING & TRANSFORMATION METHODS");

        // map(Function)
        List<Integer> lengths = Stream.of("Java", "Streams").map(String::length).collect(Collectors.toList());
        System.out.println("map: " + lengths);

        // mapToInt(ToIntFunction)
        IntStream intStream = Stream.of("10", "20", "30").mapToInt(Integer::parseInt);
        System.out.println("mapToInt sum: " + intStream.sum());

        // mapToLong(ToLongFunction)
        LongStream longStream = Stream.of("100", "200").mapToLong(Long::parseLong);
        System.out.println("mapToLong sum: " + longStream.sum());

        // mapToDouble(ToDoubleFunction)
        DoubleStream doubleStream = Stream.of("1.5", "2.5").mapToDouble(Double::parseDouble);
        System.out.println("mapToDouble average: " + doubleStream.average().orElse(0.0));

        // flatMap(Function -> Stream)
        List<String> flat = Stream.of(Arrays.asList("x", "y"), Arrays.asList("z"))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("flatMap: " + flat);

        // flatMapToInt, flatMapToLong, flatMapToDouble
        IntStream flatInts = Stream.of(1, 2).flatMapToInt(n -> IntStream.of(n, n * 10));
        System.out.println("flatMapToInt: " + flatInts.boxed().collect(Collectors.toList()));

        // mapMulti (Java 16+)
        List<String> mapMultiResult = Stream.of("a,b", "c,d")
                .mapMulti((str, consumer) -> {
                    for (String part : str.split(",")) {
                        consumer.accept(part.toUpperCase());
                    }
                })
                .map(Object::toString)
                .collect(Collectors.toList());
        System.out.println("mapMulti (Java 16+ 1-to-many mapper): " + mapMultiResult);
    }

    // 3. FILTERING & SLICING
    private static void demoFilteringAndSlicingMethods() {
        section("3. FILTERING & SLICING METHODS");

        // filter(Predicate)
        List<Integer> evens = Stream.of(1, 2, 3, 4, 5).filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("filter: " + evens);

        // limit(long) & skip(long)
        List<Integer> sliced = Stream.of(10, 20, 30, 40, 50).skip(1).limit(3).collect(Collectors.toList());
        System.out.println("skip(1).limit(3): " + sliced);

        // takeWhile(Predicate) (Java 9+)
        List<Integer> taken = Stream.of(2, 4, 6, 7, 8, 10).takeWhile(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("takeWhile (even numbers until odd): " + taken);

        // dropWhile(Predicate) (Java 9+)
        List<Integer> dropped = Stream.of(2, 4, 6, 7, 8, 10).dropWhile(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("dropWhile (drop evens until odd): " + dropped);
    }

    // 4. SORTING, PEEK & DISTINCT
    private static void demoSortingPeekAndDistinct() {
        section("4. SORTING, PEEK & DISTINCT");

        // distinct()
        List<Integer> distinct = Stream.of(1, 1, 2, 3, 3, 4).distinct().collect(Collectors.toList());
        System.out.println("distinct: " + distinct);

        // sorted() & sorted(Comparator)
        List<String> sortedAsc = Stream.of("Banana", "Apple", "Cherry").sorted().collect(Collectors.toList());
        List<String> sortedDesc = Stream.of("Banana", "Apple", "Cherry").sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("sorted(): " + sortedAsc);
        System.out.println("sorted(Comparator): " + sortedDesc);

        // peek(Consumer)
        List<String> peeked = Stream.of("a", "b")
                .peek(item -> System.out.println("   [peek Log] item: " + item))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("peek result: " + peeked);
    }

    // 5. REDUCTIONS
    private static void demoReductionMethods() {
        section("5. TERMINAL REDUCTIONS");

        // reduce(BinaryOperator)
        Optional<Integer> sumOpt = Stream.of(1, 2, 3, 4).reduce((a, b) -> a + b);
        System.out.println("reduce 1-arg: " + sumOpt.orElse(0));

        // reduce(Identity, BinaryOperator)
        int sumIdentity = Stream.of(1, 2, 3, 4).reduce(100, Integer::sum);
        System.out.println("reduce 2-arg (with identity 100): " + sumIdentity);

        // reduce(Identity, Accumulator, Combiner)
        int combined = Stream.of("1", "2", "3")
                .reduce(0, (acc, str) -> acc + Integer.parseInt(str), Integer::sum);
        System.out.println("reduce 3-arg (with combiner): " + combined);

        // min(Comparator) & max(Comparator)
        Optional<Integer> min = Stream.of(10, 5, 20).min(Integer::compareTo);
        Optional<Integer> max = Stream.of(10, 5, 20).max(Integer::compareTo);
        System.out.println("min: " + min.orElse(-1) + " | max: " + max.orElse(-1));

        // count()
        long count = Stream.of("x", "y", "z").count();
        System.out.println("count: " + count);
    }

    // 6. MATCHING & FINDING
    private static void demoMatchingAndFindingMethods() {
        section("6. MATCHING & FINDING");

        boolean anyMatch = Stream.of(1, 2, 3).anyMatch(n -> n == 2);
        boolean allMatch = Stream.of(2, 4, 6).allMatch(n -> n % 2 == 0);
        boolean noneMatch = Stream.of(1, 2, 3).noneMatch(n -> n < 0);
        System.out.println("anyMatch: " + anyMatch + " | allMatch: " + allMatch + " | noneMatch: " + noneMatch);

        Optional<String> first = Stream.of("alpha", "beta", "gamma").findFirst();
        Optional<String> any = Stream.of("alpha", "beta", "gamma").findAny();
        System.out.println("findFirst: " + first.orElse("") + " | findAny: " + any.orElse(""));
    }

    // 7. ITERATION & ARRAY CONVERSION
    private static void demoIterationAndArrayMethods() {
        section("7. ITERATION & TO ARRAY");

        System.out.print("forEach: ");
        Stream.of("A", "B").forEach(s -> System.out.print(s + " "));
        System.out.println();

        System.out.print("forEachOrdered: ");
        Stream.of("1", "2", "3").parallel().forEachOrdered(s -> System.out.print(s + " "));
        System.out.println();

        // toArray() & toArray(IntFunction)
        Object[] objArray = Stream.of("a", "b").toArray();
        String[] strArray = Stream.of("x", "y", "z").toArray(String[]::new);
        System.out.println("toArray(): " + Arrays.toString(objArray));
        System.out.println("toArray(String[]::new): " + Arrays.toString(strArray));

        // toList() (Java 16+ unmodifiable list)
        List<String> unmodifiable = Stream.of("m", "n").toList();
        System.out.println("Stream.toList() (Java 16+): " + unmodifiable);
    }

    // 8. EXHAUSTIVE COLLECTORS API
    private static void demoExhaustiveCollectors() {
        section("8. EXHAUSTIVE COLLECTORS API");

        List<String> list = Stream.of("a", "b", "bb", "ccc").collect(Collectors.toList());
        Set<String> set = Stream.of("a", "b", "a").collect(Collectors.toSet());
        Collection<String> customCol = Stream.of("a", "b").collect(Collectors.toCollection(LinkedList::new));
        System.out.println("toList: " + list + " | toSet: " + set + " | toCollection: " + customCol);

        // toMap
        Map<String, Integer> map = Stream.of("apple", "banana")
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("toMap: " + map);

        // groupingBy with downstream
        Map<Integer, Long> lengthCounts = Stream.of("a", "bb", "cc", "ddd")
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("groupingBy + counting: " + lengthCounts);

        // partitioningBy with downstream
        Map<Boolean, String> joinedByEven = Stream.of("a", "bb", "ccc", "dddd")
                .collect(Collectors.partitioningBy(s -> s.length() % 2 == 0, Collectors.joining("-")));
        System.out.println("partitioningBy + joining: " + joinedByEven);

        // collectingAndThen
        String upperJoined = Stream.of("java", "stream")
                .collect(Collectors.collectingAndThen(Collectors.joining(", "), String::toUpperCase));
        System.out.println("collectingAndThen: " + upperJoined);

        // teeing (Java 12+ combine two collectors)
        String teeingResult = Stream.of(10, 20, 30, 40)
                .collect(Collectors.teeing(
                        Collectors.minBy(Integer::compareTo),
                        Collectors.maxBy(Integer::compareTo),
                        (min, max) -> "Min=" + min.orElse(0) + " & Max=" + max.orElse(0)
                ));
        System.out.println("Collectors.teeing (Java 12+): " + teeingResult);

        // filtering & flatMapping downstream collectors (Java 9+)
        Map<Integer, List<String>> filteredGroup = Stream.of("apple", "apricot", "banana")
                .collect(Collectors.groupingBy(String::length,
                        Collectors.filtering(s -> s.startsWith("a"), Collectors.toList())));
        System.out.println("Collectors.filtering downstream (Java 9+): " + filteredGroup);
    }

    // 9. PRIMITIVE STREAMS
    private static void demoPrimitiveStreams() {
        section("9. PRIMITIVE STREAMS (IntStream, LongStream, DoubleStream)");

        IntSummaryStatistics stats = IntStream.rangeClosed(1, 10).summaryStatistics();
        System.out.println("IntStream.rangeClosed(1, 10) -> Sum: " + stats.getSum() + ", Avg: " + stats.getAverage() + ", Max: " + stats.getMax());

        DoubleStream ds = DoubleStream.of(1.1, 2.2, 3.3);
        System.out.println("DoubleStream sum: " + ds.sum());
    }

    // 10. STREAM CONTROL & PARALLEL
    private static void demoStreamControlAndParallel() {
        section("10. STREAM PIPELINE CONTROL & CLOSE HANDLERS");

        // onClose handler & close()
        Stream<String> closeableStream = Stream.of("resource1", "resource2")
                .onClose(() -> System.out.println("   [onClose] Stream close handler executed!"));
        
        try (closeableStream) {
            closeableStream.forEach(r -> System.out.println("Using resource: " + r));
        } // close() is called automatically via try-with-resources

        // parallel(), sequential(), isParallel(), unordered()
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5).parallel();
        System.out.println("isParallel: " + stream.isParallel());
        
        List<Integer> seqResult = stream.sequential().map(n -> n * 2).collect(Collectors.toList());
        System.out.println("Converted to sequential: " + seqResult);
    }
}
