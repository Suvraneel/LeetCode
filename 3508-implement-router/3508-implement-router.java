public class Packet {
    int src;
    int dest;
    int tsp;

    public Packet(int source, int destination, int timestamp) {
        src = source;
        dest = destination;
        tsp = timestamp;
    }

    @Override
    public boolean equals(Object other) {
        Packet o = (Packet) other;
        return this.src == o.src && this.dest == o.dest && this.tsp == o.tsp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(src, dest, tsp);
    }
}

class Router {
    int memCap;
    LinkedHashSet<Packet> q;
    TreeMap<Integer, Map<Integer, Integer>> tspBasedDestMap;

    public Router(int memoryLimit) {
        q = new LinkedHashSet<>();
        tspBasedDestMap = new TreeMap<>();
        memCap = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet newPacket = new Packet(source, destination, timestamp);
        if (q.contains(newPacket))
            return false;
        if (q.size() == memCap) {
            Iterator<Packet> it = q.iterator();
            Packet top = it.next();
            tspBasedDestMap.get(top.tsp).put(top.dest, tspBasedDestMap.get(top.tsp).get(top.dest) - 1);
            it.remove();
        }
        q.add(newPacket);
        tspBasedDestMap.putIfAbsent(timestamp, new HashMap<>());
        tspBasedDestMap.get(timestamp).put(destination,
                tspBasedDestMap.get(timestamp).getOrDefault(destination, 0) + 1);
        return true;
    }

    public int[] forwardPacket() {
        if (q.isEmpty())
            return new int[0];
        Iterator<Packet> it = q.iterator();
        Packet top = it.next();
        tspBasedDestMap.get(top.tsp).put(top.dest, tspBasedDestMap.get(top.tsp).get(top.dest) - 1);
        it.remove();
        return new int[] { top.src, top.dest, top.tsp };
    }

    public int getCount(int destination, int startTime, int endTime) {
        int matchCount = 0;
        NavigableMap<Integer, Map<Integer, Integer>> tailMap = tspBasedDestMap.tailMap(startTime, true);
        for (Map.Entry<Integer, Map<Integer, Integer>> e : tailMap.entrySet()) {
            if (e.getKey() > endTime)
                break;
            matchCount += e.getValue().getOrDefault(destination, 0);
        }
        return matchCount;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */