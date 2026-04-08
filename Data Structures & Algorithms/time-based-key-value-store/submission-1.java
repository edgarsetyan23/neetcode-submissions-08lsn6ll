class TimeMap {
    private Map<String, List<String[]>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // computeIfAbsent ensures the list exists before we add to it
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new String[] {value, String.valueOf(timestamp)});
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<String[]> entries = map.get(key);
        int left = 0;
        int right = entries.size() - 1;
        String result = "";

        // Standard binary search for the floor value
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midTime = Integer.parseInt(entries.get(mid)[1]);

            if (midTime <= timestamp) {
                // This is a potential candidate, store and look for a later one
                result = entries.get(mid)[0];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}