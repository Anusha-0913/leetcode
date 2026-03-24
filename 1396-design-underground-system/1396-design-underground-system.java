import java.util.*;

class UndergroundSystem {

    // Store check-in info
    class CheckInData {
        String station;
        int time;

        CheckInData(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Store travel statistics
    class TravelData {
        double totalTime;
        int count;

        TravelData(double totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    Map<Integer, CheckInData> checkInMap;
    Map<String, TravelData> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<Integer, CheckInData>();
        travelMap = new HashMap<String, TravelData>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData data = checkInMap.get(id);
        checkInMap.remove(id);

        String key = data.station + "->" + stationName;
        int time = t - data.time;

        if (!travelMap.containsKey(key)) {
            travelMap.put(key, new TravelData(time, 1));
        } else {
            TravelData travel = travelMap.get(key);
            travel.totalTime += time;
            travel.count += 1;
            travelMap.put(key, travel);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;
        TravelData travel = travelMap.get(key);
        return travel.totalTime / travel.count;
    }

    // Optional main method to test
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();

        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);

        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge")); // 14.0
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 11.0
    }
}