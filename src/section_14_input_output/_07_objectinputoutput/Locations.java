package section_14_input_output._07_objectinputoutput;

import java.io.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations_obj.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }
    }

    static {
//        try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
//            boolean eof = false;
//            while (!eof) {
//                try {
//                    Map<String, Integer> exits = new LinkedHashMap<>();
//                    int locID = locFile.readInt();
//                    String description = locFile.readUTF();
//                    int numExits = locFile.readInt();
//                    System.out.println("Read location " + locID + " : " + description);
//                    System.out.println("Found " + numExits + " exits");
//
//                    for (int i = 0; i < numExits; i++) {
//                        String direction = locFile.readUTF();
//                        int destination = locFile.readInt();
//                        exits.put(direction, destination);
//                        System.out.println("\t\t" + direction + "," + destination);
//                    }
//                    locations.put(locID, new Location(locID, description, exits));
//                } catch (EOFException e) {
//                    eof = true;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations_obj.dat")))) {
            boolean eof = false;
            while(!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() + " exits");
                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        } catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }

}
