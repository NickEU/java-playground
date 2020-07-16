package tf.nick.hypertrash.findTheSeed;

class SeedNumWithMax implements Comparable<SeedNumWithMax> {
    private final int seed;
    private final int maxNum;

    public SeedNumWithMax(int seed, int maxNum) {
        this.maxNum = maxNum;
        this.seed = seed;
    }

    public int getSeed() {
        return seed;
    }

    public int getMaxNum() {
        return maxNum;
    }

    @Override
    public int compareTo(SeedNumWithMax o) {
        return this.maxNum - o.maxNum == 0
                ? this.seed - o.seed
                : this.maxNum - o.maxNum;
    }
}
